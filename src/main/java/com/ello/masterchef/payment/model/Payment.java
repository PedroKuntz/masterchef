package com.ello.masterchef.payment.model;

import com.ello.masterchef.commons.model.Entity;

import java.util.UUID;

public class Payment implements Entity {

    private UUID paymentId;
    private PaymentMethod paymentMethod;
    private Double value;

    public Payment() {}

    public UUID getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(UUID paymentId) {
        this.paymentId = paymentId;
    }

    public PaymentMethod getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }
}
