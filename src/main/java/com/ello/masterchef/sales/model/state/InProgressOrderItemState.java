package com.ello.masterchef.sales.model.state;

import com.ello.masterchef.commons.model.State;
import com.ello.masterchef.sales.model.PurchaseOrderItem;

import static com.ello.masterchef.integration.model.StateConstants.IN_PROGRESS_ORDER_ITEM_STATE;

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

  @Override
  public String getValue() {
    return IN_PROGRESS_ORDER_ITEM_STATE;
  }
}
