package com.ello.masterchef.sales.service;

import com.ello.masterchef.sales.dao.PurchaseOrderDao;
import com.ello.masterchef.sales.model.Cart;
import com.ello.masterchef.sales.model.PurchaseOrder;
import com.ello.masterchef.sales.model.PurchaseOrderItem;
import com.ello.masterchef.sales.model.PurchaseOrderItemDraft;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class PurchaseOrderService {

    private final PurchaseOrderDao purchaseOrderDao;
    private final CartService cartService;

    @Autowired
    public PurchaseOrderService(PurchaseOrderDao purchaseOrderDao,
                                CartService cartService) {
        this.purchaseOrderDao = purchaseOrderDao;
        this.cartService = cartService;
    }

    public PurchaseOrder createPurchaseOrder(PurchaseOrder purchaseOrder) {
        return new PurchaseOrder();
    }

    public void sendPurchaseOrder(UUID cartId) {
        //Get Cart in Redis
        Cart cart = cartService.findCartById(cartId);
        //Create PurchaseOrderItem
        List<PurchaseOrderItem> purchaseOrderItems = cart.getPurchaseOrderItemDraftList().stream().map(poi -> buildPurchaseOrderItem(poi)).collect(Collectors.toList());
        PurchaseOrder purchaseOrder = findPurchaseOrderById(cart.getPurchaseOrderId());
        purchaseOrder.setPurchaseOrderItems(purchaseOrderItems);
    }

    private PurchaseOrderItem buildPurchaseOrderItem(PurchaseOrderItemDraft purchaseOrderItemDraft) {
        return new PurchaseOrderItem();
    }

    private PurchaseOrder findPurchaseOrderById(UUID purchaseOrderId) {
        return new PurchaseOrder();
    }
}
