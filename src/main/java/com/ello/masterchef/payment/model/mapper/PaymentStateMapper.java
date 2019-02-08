package com.ello.masterchef.payment.model.mapper;

import com.ello.masterchef.commons.model.State;
import com.ello.masterchef.payment.model.ClosedPaymentOrderState;
import com.ello.masterchef.payment.model.OpenedPaymentOrderState;
import com.ello.masterchef.payment.model.PaymentOrder;

import static com.ello.masterchef.integration.model.StateConstants.OPENED_ORDER_STATE;

public class PaymentStateMapper {

    public static State<PaymentOrder> paymentOrderStateTo(String stateName) {
        if (OPENED_ORDER_STATE.equalsIgnoreCase(stateName)) {
            return new OpenedPaymentOrderState();
        } else {
            return new ClosedPaymentOrderState();
        }
    }
}
