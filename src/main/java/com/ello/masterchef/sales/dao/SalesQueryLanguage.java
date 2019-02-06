package com.ello.masterchef.sales.dao;

public class SalesQueryLanguage {

  protected static final String FIND_ALL_PURCHASE_ORDER =
    "SELECT " +
      "purchase_order_id, " +
      "employee_id, " +
      "purchase_order_state, " +
      "purchase_order_type, " +
      "channel, " +
      "total_price " +
      "FROM purchase_order ";

  protected static final String FIND_PURCHASE_ORDER_BY_ID =
    "SELECT " +
      "purchase_order_id, " +
      "employee_id, " +
      "purchase_order_state, " +
      "purchase_order_type, " +
      "channel, " +
      "total_price " +
      "FROM purchase_order " +
      "WHERE purchase_order_id = ?";

  protected static final String FIND_ALL_PURCHASE_ORDER_ITEM_BY_PURCHASE_ORDER_ID =
    "SELECT " +
      "purchase_order_item_id," +
      "catalog_item_id, " +
      "purchase_order_id, " +
      "purchase_order_item_state, " +
      "purchase_order_item_type, " +
      "price, " +
      "amount, " +
      "kg " +
      "FROM purchase_order_item " +
      "WHERE purchase_order_id = ?";

}
