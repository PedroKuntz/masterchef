package com.ello.masterchef.payment.service;

import com.ello.masterchef.payment.dao.PaymentOrderDao;
import com.ello.masterchef.payment.model.OpenedPaymentOrderState;
import com.ello.masterchef.payment.model.Payment;
import com.ello.masterchef.payment.model.PaymentOrder;
import com.ello.masterchef.sales.model.PurchaseOrder;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class PaymentService {

    private final PaymentOrderDao paymentOrderDao;
    private final Payment payment;

    public PaymentService(PaymentOrderDao paymentOrderDao, Payment payment) {
        this.paymentOrderDao = paymentOrderDao;
        this.payment = payment;
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

    public void addPaymentInPaymentOrder(UUID paymentOrder, Payment payment) {

    }

}
