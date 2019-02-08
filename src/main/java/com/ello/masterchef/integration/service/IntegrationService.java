package com.ello.masterchef.integration.service;

import com.ello.masterchef.catalog.model.CatalogItem;
import com.ello.masterchef.catalog.service.CatalogService;
import com.ello.masterchef.payment.service.PaymentService;
import com.ello.masterchef.sales.model.Cart;
import com.ello.masterchef.sales.model.PurchaseOrder;
import com.ello.masterchef.sales.service.CartService;
import com.ello.masterchef.sales.service.PrinterService;
import com.ello.masterchef.sales.service.PurchaseOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class IntegrationService {

    private final PurchaseOrderService purchaseOrderService;
    private final CartService cartService;
    private final PrinterService printerService;
    private final CatalogService catalogService;
    private final PaymentService paymentService;

    @Autowired
    public IntegrationService(PurchaseOrderService purchaseOrderService, CartService cartService, PrinterService printerService, CatalogService catalogService, PaymentService paymentService) {
        this.purchaseOrderService = purchaseOrderService;
        this.cartService = cartService;
        this.printerService = printerService;
        this.catalogService = catalogService;
        this.paymentService = paymentService;
    }

    public void createPaymentOrder(PurchaseOrder purchaseOrder) {
        paymentService.createPaymentOrder(purchaseOrder);
    }

    public Cart findCartById(UUID cartId) {
        return cartService.findCartById(cartId);
    }

    public void notifyToPrepare(PurchaseOrder purchaseOrder) {
        printerService.notifyToPrepare(purchaseOrder);
    }

    public CatalogItem findById(UUID catalogItemId) {
        return catalogService.findById(catalogItemId);
    }

}
