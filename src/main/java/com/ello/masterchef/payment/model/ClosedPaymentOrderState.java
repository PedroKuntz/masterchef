package com.ello.masterchef.payment.model;

import com.ello.masterchef.commons.model.State;

import static com.ello.masterchef.integration.model.StateConstants.CLOSED_ORDER_STATE;

public class ClosedPaymentOrderState implements State<PaymentOrder> {
    @Override
    public void next(PaymentOrder paymentOrder) {

    }

    @Override
    public void prev(PaymentOrder paymentOrder) {

    }

    @Override
    public void notify(PaymentOrder paymentOrder) {

    }

    @Override
    public String getValue() {
        return CLOSED_ORDER_STATE;
    }
}
