package com.ello.masterchef.sales.controller;

import com.ello.masterchef.sales.model.PurchaseOrderItem;
import com.ello.masterchef.sales.model.PurchaseOrderRequest;
import com.ello.masterchef.sales.service.PurchaseOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(value = "/purchaseOrder")
public class PurchaseOrderController {

  @Autowired
  private PurchaseOrderService purchaseOrderService;

  @PostMapping()
  public ResponseEntity<?> createPurchaseOrder(@RequestBody PurchaseOrderRequest purchaseOrderRequest) {
    return new ResponseEntity(purchaseOrderService.createPurchaseOrder(purchaseOrderRequest), HttpStatus.CREATED);
  }

  @PutMapping(value = "/send/{cart_id}")
  public ResponseEntity<?> sendPurchaseOrder(@PathVariable("cart_id") UUID cartId) {
    purchaseOrderService.sendPurchaseOrder(cartId);
    return new ResponseEntity(HttpStatus.CREATED);
  }

  @GetMapping
  public ResponseEntity<?> getAllPurchaseOrder() {
    return new ResponseEntity(purchaseOrderService.findAll(), HttpStatus.OK);
  }

  @GetMapping(value = "/{purchaseOrderId}/purchaseOrderItems")
  public ResponseEntity<?> getAllItemsByPurchaseOrderId(@PathVariable("purchaseOrderId") UUID purchaseOrderId) {
    List<PurchaseOrderItem> purchaseOrderItems = purchaseOrderService.findPurchaseOrderItemsByPurchaseOrderId(purchaseOrderId);
    return new ResponseEntity(purchaseOrderItems, HttpStatus.OK);
  }

}
