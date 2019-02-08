package com.ello.masterchef.payment.controller;

import com.ello.masterchef.payment.model.Payment;
import com.ello.masterchef.payment.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController(value = "/payment")
public class PaymentController {

  @Autowired
  private PaymentService paymentService;

  @PutMapping(value = "/{paymentOrder}")
  public ResponseEntity<?> addPayment(@RequestParam("paymentOrder") UUID paymentOrder,
                                      @RequestBody Payment payment) {
    paymentService.addPaymentInPaymentOrder(paymentOrder, payment);
    return new ResponseEntity(HttpStatus.CREATED);
  }

  @GetMapping(value = "/{purchaseOrderId}")
  public ResponseEntity<?> findPaymentOrdersByPurchaseOrderId(@RequestParam("purchaseOrderId") UUID purchaseOrderId) {
    return new ResponseEntity(paymentService.findByPurchaseOrderId(purchaseOrderId), HttpStatus.OK);
  }
}
