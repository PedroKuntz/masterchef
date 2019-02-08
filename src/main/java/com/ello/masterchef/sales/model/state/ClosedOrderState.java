package com.ello.masterchef.sales.model.state;

import com.ello.masterchef.commons.model.State;
import com.ello.masterchef.sales.model.PurchaseOrder;

import static com.ello.masterchef.integration.model.StateConstants.CLOSED_ORDER_STATE;

public class ClosedOrderState implements State<PurchaseOrder> {

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
    return CLOSED_ORDER_STATE;
  }
}
