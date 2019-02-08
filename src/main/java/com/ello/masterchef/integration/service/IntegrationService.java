package com.ello.masterchef.integration.service;

import com.ello.masterchef.catalog.model.CatalogItem;
import com.ello.masterchef.catalog.service.CatalogService;
import com.ello.masterchef.payment.model.PaymentOrder;
import com.ello.masterchef.payment.service.PaymentService;
import com.ello.masterchef.sales.model.Cart;
import com.ello.masterchef.sales.model.PurchaseOrder;
import com.ello.masterchef.sales.service.CartService;
import com.ello.masterchef.sales.service.PrinterService;
import com.ello.masterchef.sales.service.PurchaseOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
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

  //PAYMENT
  public void createPaymentOrder(PurchaseOrder purchaseOrder) {
    paymentService.createPaymentOrder(purchaseOrder);
  }

  public PaymentOrder findByPurchaseOrderId(UUID purchaseOrderId) {
    return paymentService.findByPurchaseOrderId(purchaseOrderId);
  }

  // CART
  public Optional<Cart> findCartById(UUID cartId) {
    return cartService.findCartById(cartId);
  }

  public Optional<Cart> findCartByIdAndDeleteCart(UUID cartId) {
    return cartService.findCartByIdAndDeleteCart(cartId);
  }

  //PRINT
  public void notifyToPrepare(PurchaseOrder purchaseOrder) {
    printerService.notifyToPrepare(purchaseOrder);
  }

  //CATALOG
  public CatalogItem findById(UUID catalogItemId) {
    return catalogService.findById(catalogItemId);
  }

  //SALES - PURCHASE_ORDER
  public void updatePurchaseOrderState(PurchaseOrder purchaseOrder) {
    purchaseOrderService.updateState(purchaseOrder);
  }

  public void sendPurchaseOrderByCartId(UUID cartId) {
    purchaseOrderService.sendPurchaseOrder(cartId);
  }

}
