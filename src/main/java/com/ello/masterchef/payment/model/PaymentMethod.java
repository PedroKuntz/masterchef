package com.ello.masterchef.payment.model;

public enum PaymentMethod {

    CREDIT_CARD("CREDIT_CARD"),
    MONEY("MONEY"),
    POS("POS"),
    TEF("TEF"),
    COURTESY("COURTESY");

    private String value;

    PaymentMethod(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
