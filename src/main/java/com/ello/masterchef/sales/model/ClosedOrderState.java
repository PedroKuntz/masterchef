package com.ello.masterchef.sales.model;

import com.ello.masterchef.integration.State;

public class ClosedOrderState implements State<PurchaseOrderItem> {

  public ClosedOrderState() {}

  @Override
  public void next(PurchaseOrderItem purchaseOrderItem) {

  }

  @Override
  public void prev(PurchaseOrderItem purchaseOrderItem) {

  }

  @Override
  public void notify(PurchaseOrderItem purchaseOrderItem) {

  }
}
