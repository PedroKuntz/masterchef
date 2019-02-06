package com.ello.masterchef.sales.model;

import com.ello.masterchef.integration.State;

import static com.ello.masterchef.integration.StateConstants.RECEIVED_ORDER_ITEM_STATE;

public class ReceivedOrderItemState implements State<PurchaseOrderItem> {

  public ReceivedOrderItemState() {}

  @Override
  public void next(PurchaseOrderItem purchaseOrderItem) {

  }

  @Override
  public void prev(PurchaseOrderItem purchaseOrderItem) {

  }

  @Override
  public void notify(PurchaseOrderItem purchaseOrderItem) {

  }

  @Override
  public String getValue() {
    return RECEIVED_ORDER_ITEM_STATE;
  }
}
