package com.ello.masterchef.sales.service;

import com.ello.masterchef.sales.dao.PurchaseOrderDao;
import com.ello.masterchef.sales.dao.PurchaseOrderItemDao;
import com.ello.masterchef.sales.model.Cart;
import com.ello.masterchef.sales.model.InProgressOrderItemState;
import com.ello.masterchef.sales.model.OpenedOrderState;
import com.ello.masterchef.sales.model.PurchaseOrder;
import com.ello.masterchef.sales.model.PurchaseOrderItem;
import com.ello.masterchef.sales.model.PurchaseOrderItemDraft;
import com.ello.masterchef.sales.model.PurchaseOrderItemType;
import com.ello.masterchef.sales.model.PurchaseOrderRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class PurchaseOrderService {

  private final PurchaseOrderDao purchaseOrderDao;
  private final PurchaseOrderItemDao purchaseOrderItemDao;
  private final CartService cartService;

  @Autowired
  public PurchaseOrderService(PurchaseOrderDao purchaseOrderDao,
                              PurchaseOrderItemDao purchaseOrderItemDao,
                              CartService cartService) {
    this.purchaseOrderDao = purchaseOrderDao;
    this.purchaseOrderItemDao = purchaseOrderItemDao;
    this.cartService = cartService;
  }

  public PurchaseOrder createPurchaseOrder(PurchaseOrderRequest purchaseOrderRequest) {
    PurchaseOrder purchaseOrder = buildPurchaseOrder(purchaseOrderRequest);
    purchaseOrderDao.save(purchaseOrder);
    return purchaseOrder;
  }

  public void sendPurchaseOrder(UUID cartId) {
    //Get Cart in Redis
    Cart cart = cartService.findCartById(cartId);
    //Create PurchaseOrderItem

    List<PurchaseOrderItem> itemsFirstLevel = cart.getPurchaseOrderItemDraftList().stream().filter(poi -> poi.getLevel() == 1).map(poi -> buildPurchaseOrderItem(poi, cart)).collect(Collectors.toList());
    itemsFirstLevel.stream().forEach(it -> {

    });

    List<PurchaseOrderItemDraft> subItemsCatalogItemId = cart.getPurchaseOrderItemDraftList().stream().map(poi -> poi.getSubItemsId()).flatMap(id -> id.stream()).collect(Collectors.toList());
    // Create PurchaseOrderItem second level
    List<PurchaseOrderItem> subItems = buildPurchaseOrderItems(cart, subItemsCatalogItemId);





    // Create PurchaseOrderItem first level

    PurchaseOrder purchaseOrder = findPurchaseOrderById(cart.getPurchaseOrderId());
    purchaseOrder.setPurchaseOrderItems(purchaseOrderItems);
    //Notifica cozinha
  }

  private List<PurchaseOrderItem> buildPurchaseOrderItemFirstLevel(Cart cart) {
    return cart.getPurchaseOrderItemDraftList()
      .stream()
      .filter(poi -> poi.getLevel() == 2)
      .map(poi -> buildPurchaseOrderItem(poi, cart, ))
      .collect(Collectors.toList());
  }

  private List<PurchaseOrderItem> buildPurchaseOrderItems(Cart cart, List<PurchaseOrderItemDraft> purchaseOrderItemDrafts) {
    return purchaseOrderItemDrafts
      .stream()
      .map(poi -> buildPurchaseOrderItem(poi, cart))
      .collect(Collectors.toList());
  }

  public List<PurchaseOrderItem> findPurchaseOrderItemsByPurchaseOrderId(UUID purchaseOrderId) {
    return purchaseOrderItemDao.findPurchaseOrderItemsByPurchaseOrderId(purchaseOrderId);
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

  private PurchaseOrderItem buildPurchaseOrderItem(PurchaseOrderItemDraft purchaseOrderItemDraft, Cart cart) {
    PurchaseOrderItem purchaseOrderItem = new PurchaseOrderItem();
    purchaseOrderItem.setPurchaseOrderItemId(UUID.randomUUID());
    purchaseOrderItem.setCatalogItemId(purchaseOrderItemDraft.getCatalogItemId());
    purchaseOrderItem.setPurchaseOrderItemState(new InProgressOrderItemState());
    purchaseOrderItem.setPurchaseOrderItemType(PurchaseOrderItemType(purchaseOrderItemDraft.getCatalogItemType().getValue()));
    purchaseOrderItem.setPrice(purchaseOrderItemDraft.getPrice());
    purchaseOrderItem.setAmount(purchaseOrderItemDraft.getAmount());
    purchaseOrderItem.setKg(purchaseOrderItemDraft.getKg());
    this.purchaseOrderItemDao.save(cart.getPurchaseOrderId(),purchaseOrderItem);
    return purchaseOrderItem;
  }

  private PurchaseOrderItem updatePurchaseOrderItemParent(PurchaseOrderItem purchaseOrderItem) {
    this.purchaseOrderItemDao.updateSubItems()
  }

  private PurchaseOrder findPurchaseOrderById(UUID purchaseOrderId) {
    return this.purchaseOrderDao.findById(purchaseOrderId);
  }

}
