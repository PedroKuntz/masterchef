package com.ello.masterchef.payment.model;

import com.ello.masterchef.commons.model.Entity;
import com.ello.masterchef.commons.model.State;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class PaymentOrder implements Entity {

    private UUID paymentOrderId;
    private UUID purchaseOrderId;
    private List<Payment> payments = new ArrayList<>();
    private State<PaymentOrder> paymentOrderState;

    public PaymentOrder() {}

    public UUID getPaymentOrderId() {
        return paymentOrderId;
    }

    public void setPaymentOrderId(UUID paymentOrderId) {
        this.paymentOrderId = paymentOrderId;
    }

    public UUID getPurchaseOrderId() {
        return purchaseOrderId;
    }

    public void setPurchaseOrderId(UUID purchaseOrderId) {
        this.purchaseOrderId = purchaseOrderId;
    }

    public List<Payment> getPayments() {
        return payments;
    }

    public void setPayments(List<Payment> payments) {
        this.payments = payments;
    }

    public State<PaymentOrder> getPaymentOrderState() {
        return paymentOrderState;
    }

    public void setPaymentOrderState(State<PaymentOrder> paymentOrderState) {
        this.paymentOrderState = paymentOrderState;
    }
}
