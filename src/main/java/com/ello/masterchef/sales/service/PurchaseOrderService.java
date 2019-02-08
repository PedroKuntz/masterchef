package com.ello.masterchef.sales.service;

import com.ello.masterchef.integration.service.IntegrationService;
import com.ello.masterchef.sales.dao.PurchaseOrderDao;
import com.ello.masterchef.sales.dao.PurchaseOrderItemDao;
import com.ello.masterchef.sales.model.*;
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
  private final IntegrationService integrationService;

  @Autowired
  public PurchaseOrderService(PurchaseOrderDao purchaseOrderDao,
                              PurchaseOrderItemDao purchaseOrderItemDao,
                              IntegrationService integrationService) {
    this.purchaseOrderDao = purchaseOrderDao;
    this.purchaseOrderItemDao = purchaseOrderItemDao;
    this.integrationService = integrationService;
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
    Cart cart = integrationService.findCartById(cartId);
    cart.getPurchaseOrderItemDraftList()
      .forEach(draft -> {
        PurchaseOrderItem purchaseOrderItem = buildPurchaseOrderItem(draft, cart, empty());
        List<PurchaseOrderItem> subItems = draft.getSubItemsId().stream().map(sub -> buildPurchaseOrderItem(sub, cart, of(purchaseOrderItem.getPurchaseOrderItemId()))).collect(Collectors.toList());
        purchaseOrderItems.add(purchaseOrderItem);
        purchaseOrderItems.addAll(subItems);
      });

    PurchaseOrder purchaseOrder = findPurchaseOrderById(cart.getPurchaseOrderId());
    purchaseOrder.setPurchaseOrderItems(purchaseOrderItems);
    //Notifica cozinha
    integrationService.notifyToPrepare(purchaseOrder);

  }

  public void preClosedPurchaseOrder(UUID purchaseOrderId) {
    PurchaseOrder purchaseOrder = purchaseOrderDao.findById(purchaseOrderId);
    integrationService.createPaymentOrder(purchaseOrder);
  }

  public void ClosePurchaseOrder(PurchaseOrder purchaseOrder) {
    purchaseOrder.setPurchaseOrderState(new ClosedOrderState());
    purchaseOrderDao.save(purchaseOrder);
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

  private PurchaseOrder findPurchaseOrderById(UUID purchaseOrderId) {
    return this.purchaseOrderDao.findById(purchaseOrderId);
  }

}
