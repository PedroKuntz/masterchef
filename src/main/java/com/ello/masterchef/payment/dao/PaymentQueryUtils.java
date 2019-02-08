package com.ello.masterchef.payment.dao;

public class PaymentQueryUtils {

    public static final String FIND_BY_PURCHASE_ORDER_ID =
            "SELECT payment_order_id, " +
            "purchase_order_id, " +
            "payment_order_state" +
            "FROM payment_order " +
            "WHERE purchase_order_id = ?";
}
