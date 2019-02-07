package com.ello.masterchef.payment.model;

import com.ello.masterchef.commons.model.Entity;
import com.ello.masterchef.commons.model.State;
import com.ello.masterchef.sales.model.PurchaseOrder;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class PaymentOrder implements Entity {

    private UUID paymentOrderId;
    private PurchaseOrder purchaseOrderId;
    private List<Payment> payments = new ArrayList<>();
    private State<PaymentOrder> paymentOrderState;

    public PaymentOrder() {}

    public UUID getPaymentOrderId() {
        return paymentOrderId;
    }

    public void setPaymentOrderId(UUID paymentOrderId) {
        this.paymentOrderId = paymentOrderId;
    }

    public PurchaseOrder getPurchaseOrderId() {
        return purchaseOrderId;
    }

    public void setPurchaseOrderId(PurchaseOrder purchaseOrderId) {
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
