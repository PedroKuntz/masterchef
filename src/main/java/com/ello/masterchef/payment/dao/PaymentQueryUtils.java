package com.ello.masterchef.payment.dao;

public class PaymentQueryUtils {

  public static final String FIND_BY_PURCHASE_ORDER_ID =
    "SELECT payment_order_id, " +
      "purchase_order_id, " +
      "payment_order_state" +
      "FROM payment_order " +
      "WHERE purchase_order_id = ?";

  public static final String FIND_COMPLETE_BY_PURCHASE_ORDER_ID =
      "SELECT p.payment_order_id as payment_order_id, " +
        "o.purchase_order_id as purchase_order_id, " +
        "o.payment_order_state as payment_order_state, " +
        "p.payment_id as payment_id, " +
        "p.payment_method as payment_method, " +
        "p.value as value " +
        "FROM payment_order as o JOIN payment as p " +
        "WHERE o.purchase_order_id = ?";
}
