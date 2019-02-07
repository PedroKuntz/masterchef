package com.ello.masterchef.payment.service;

import com.ello.masterchef.payment.model.OpenedPaymentOrderState;
import com.ello.masterchef.payment.model.Payment;
import com.ello.masterchef.payment.model.PaymentOrder;
import com.ello.masterchef.sales.model.PurchaseOrder;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class PaymentService {

    public void createPaymentOrder(PurchaseOrder purchaseOrder) {
        PaymentOrder paymentOrder = new PaymentOrder();
        paymentOrder.setPaymentOrderId(UUID.randomUUID());
        paymentOrder.setPurchaseOrderId(purchaseOrder);
        paymentOrder.setPaymentOrderState(new OpenedPaymentOrderState());
    }

    public void addPaymentInPaymentOrder(UUID paymentOrderId, Payment payment) {

    }

}
