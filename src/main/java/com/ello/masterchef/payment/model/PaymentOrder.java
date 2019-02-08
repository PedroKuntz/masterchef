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
    private Double totalValue;
    private Double reduceValue;
    private Double incrementValue;
    private Double tax;

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

    public Double getTotalValue() {
        return totalValue;
    }

    public PaymentOrder setTotalValue(Double totalValue) {
        this.totalValue = totalValue;
        return this;
    }

    public Double getReduceValue() {
        return reduceValue;
    }

    public PaymentOrder setReduceValue(Double reduceValue) {
        this.reduceValue = reduceValue;
        return this;
    }

    public Double getIncrementValue() {
        return incrementValue;
    }

    public PaymentOrder setIncrementValue(Double incrementValue) {
        this.incrementValue = incrementValue;
        return this;
    }

    public Double getTax() {
        return tax;
    }

    public PaymentOrder setTax(Double tax) {
        this.tax = tax;
        return this;
    }
}
