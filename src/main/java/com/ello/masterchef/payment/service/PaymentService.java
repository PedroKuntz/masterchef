package com.ello.masterchef.payment.service;

import com.ello.masterchef.payment.dao.PaymentOrderDao;
import com.ello.masterchef.payment.model.OpenedPaymentOrderState;
import com.ello.masterchef.payment.model.Payment;
import com.ello.masterchef.payment.model.PaymentOrder;
import com.ello.masterchef.sales.model.PurchaseOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class PaymentService {

  private final PaymentOrderDao paymentOrderDao;

  @Autowired
  public PaymentService(PaymentOrderDao paymentOrderDao) {
    this.paymentOrderDao = paymentOrderDao;
  }

  public void createPaymentOrder(PurchaseOrder purchaseOrder) {
    PaymentOrder paymentOrder = new PaymentOrder();
    paymentOrder.setPaymentOrderId(UUID.randomUUID());
    paymentOrder.setPurchaseOrderId(purchaseOrder.getPurchaseId());
    paymentOrder.setPaymentOrderState(new OpenedPaymentOrderState());
  }

  public PaymentOrder findByPurchaseOrderId(UUID purchaseOrderId) {
    return paymentOrderDao.findByPurchaseOrderId(purchaseOrderId);
  }

  public PaymentOrder findPaymentOrderCompleteByPurchaseOrderId(UUID purchaseOrderId) {
    return paymentOrderDao.findPaymentOrderCompleteByPurchaseOrderId(purchaseOrderId);
  }

  public void addPaymentInPaymentOrder(UUID paymentOrder, Payment payment) {

  }

}
