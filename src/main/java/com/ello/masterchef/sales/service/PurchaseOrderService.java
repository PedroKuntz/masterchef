package com.ello.masterchef.sales.service;

import com.ello.masterchef.sales.dao.PurchaseOrderDao;
import com.ello.masterchef.sales.dao.PurchaseOrderItemDao;
import com.ello.masterchef.sales.model.Cart;
import com.ello.masterchef.sales.model.PurchaseOrder;
import com.ello.masterchef.sales.model.PurchaseOrderItem;
import com.ello.masterchef.sales.model.PurchaseOrderItemDraft;
import com.ello.masterchef.sales.model.PurchaseOrderItemType;
import com.ello.masterchef.sales.model.PurchaseOrderRequest;
import com.ello.masterchef.sales.model.state.InProgressOrderItemState;
import com.ello.masterchef.sales.model.state.OpenedOrderState;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

import static java.util.Optional.empty;
import static java.util.Optional.of;

@Service
public class PurchaseOrderService {

  private final PurchaseOrderDao purchaseOrderDao;
  private final PurchaseOrderItemDao purchaseOrderItemDao;
  private final CartService cartService;
  private final PrinterService printerService;

  @Autowired
  public PurchaseOrderService(PurchaseOrderDao purchaseOrderDao,
                              PurchaseOrderItemDao purchaseOrderItemDao,
                              CartService cartService, PrinterService printerService) {
    this.purchaseOrderDao = purchaseOrderDao;
    this.purchaseOrderItemDao = purchaseOrderItemDao;
    this.cartService = cartService;
    this.printerService = printerService;
  }

  public List<PurchaseOrder> findAll() {
    return purchaseOrderDao.findAll();
  }

  public PurchaseOrder createPurchaseOrder(PurchaseOrderRequest purchaseOrderRequest) {
    PurchaseOrder purchaseOrder = buildPurchaseOrder(purchaseOrderRequest);
    purchaseOrderDao.save(purchaseOrder);
    return purchaseOrder;
  }

  public void sendPurchaseOrder(UUID cartId) {
    List<PurchaseOrderItem> purchaseOrderItems = new ArrayList<>();
    //Get Cart in Hazelcast
    Optional<Cart> cart = cartService.findCartByIdAndDeleteCart(cartId);
    cart.ifPresent(c -> {

      c.getPurchaseOrderItemDraftList()
      .forEach(draft -> {

        PurchaseOrderItem purchaseOrderItem = buildPurchaseOrderItem(draft, c, empty());
        List<PurchaseOrderItem> subItems = draft.getSubItemsId().stream().map(sub -> buildPurchaseOrderItem(sub, c, of(purchaseOrderItem.getPurchaseOrderItemId()))).collect(Collectors.toList());
        purchaseOrderItems.add(purchaseOrderItem);
        purchaseOrderItems.addAll(subItems);

      });

      PurchaseOrder purchaseOrder = findPurchaseOrderById(cart.get().getPurchaseOrderId());
      purchaseOrder.setPurchaseOrderItems(purchaseOrderItems);
      //Notifica cozinha
      printerService.notifyToPrepare(purchaseOrder);

    });

  }

  public void updateState(PurchaseOrder purchaseOrder) {
    purchaseOrderDao.updateState(purchaseOrder);
  }

  public List<PurchaseOrderItem> findPurchaseOrderItemsByPurchaseOrderId(UUID purchaseOrderId) {
    return purchaseOrderItemDao.findPurchaseOrderItemsByPurchaseOrderId(purchaseOrderId);
  }

  private PurchaseOrder findPurchaseOrderById(UUID purchaseOrderId) {
    return this.purchaseOrderDao.findById(purchaseOrderId);
  }

  private PurchaseOrder buildPurchaseOrder(PurchaseOrderRequest purchaseOrderRequest) {
    PurchaseOrder purchaseOrder = new PurchaseOrder();
    purchaseOrder.setPurchaseId(UUID.randomUUID());
    purchaseOrder.setEmployee(purchaseOrderRequest.getEmployeeId());
    purchaseOrder.setPurchaseOrderType(purchaseOrderRequest.getPurchaseOrderType());
    purchaseOrder.setChannel(purchaseOrderRequest.getChannel());
    purchaseOrder.setPurchaseOrderState(new OpenedOrderState());
    purchaseOrder.setPurchaseOrderItems(new ArrayList<>());
    purchaseOrder.setTotalPrice(0.0);
    return purchaseOrder;
  }

  private PurchaseOrderItem buildPurchaseOrderItem(PurchaseOrderItemDraft purchaseOrderItemDraft, Cart cart, Optional<UUID> parentId) {
    PurchaseOrderItem purchaseOrderItem = new PurchaseOrderItem();
    purchaseOrderItem.setPurchaseOrderItemId(UUID.randomUUID());
    purchaseOrderItem.setCatalogItemId(purchaseOrderItemDraft.getCatalogItemId());
    purchaseOrderItem.setPurchaseOrderItemState(new InProgressOrderItemState());
    purchaseOrderItem.setPurchaseOrderItemType(PurchaseOrderItemType.valueOf(purchaseOrderItemDraft.getCatalogItemType().getValue()));
    purchaseOrderItem.setPrice(purchaseOrderItemDraft.getPrice());
    purchaseOrderItem.setAmount(purchaseOrderItemDraft.getAmount());
    purchaseOrderItem.setKg(purchaseOrderItemDraft.getKg());
    purchaseOrderItem.setPurchaseOrderItemParentId(parentId);
    this.purchaseOrderItemDao.save(cart.getPurchaseOrderId(),purchaseOrderItem);
    return purchaseOrderItem;
  }

}
