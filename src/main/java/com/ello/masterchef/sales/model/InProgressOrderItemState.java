package com.ello.masterchef.sales.model;

import com.ello.masterchef.integration.State;

public class InProgressOrderItemState implements State<PurchaseOrderItem> {

  public InProgressOrderItemState() {}

  @Override
  public void next(PurchaseOrderItem orderItem) {

  }

  @Override
  public void prev(PurchaseOrderItem orderItem) {

  }

  @Override
  public void notify(PurchaseOrderItem orderItem) {

  }
}
