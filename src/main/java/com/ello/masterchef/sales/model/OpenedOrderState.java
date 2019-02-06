package com.ello.masterchef.sales.model;

import com.ello.masterchef.integration.State;

import static com.ello.masterchef.integration.StateConstants.OPENED_ORDER_STATE;

public class OpenedOrderState implements State<PurchaseOrder> {

  @Override
  public void next(PurchaseOrder purchaseOrder) {

  }

  @Override
  public void prev(PurchaseOrder purchaseOrder) {

  }

  @Override
  public void notify(PurchaseOrder purchaseOrder) {

  }

  @Override
  public String getValue() {
    return OPENED_ORDER_STATE;
  }
}
