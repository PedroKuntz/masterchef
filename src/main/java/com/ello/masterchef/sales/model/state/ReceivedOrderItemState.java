package com.ello.masterchef.sales.model.state;

import com.ello.masterchef.commons.model.State;
import com.ello.masterchef.sales.model.PurchaseOrderItem;

import static com.ello.masterchef.integration.model.StateConstants.RECEIVED_ORDER_ITEM_STATE;

public class ReceivedOrderItemState implements State<PurchaseOrderItem> {

  public ReceivedOrderItemState() {}

  @Override
  public void next(PurchaseOrderItem purchaseOrderItem) {

  }

  @Override
  public void prev(PurchaseOrderItem purchaseOrderItem) {
    purchaseOrderItem.setPurchaseOrderItemState(new DeliveryOrderItemState());
  }

  @Override
  public void notify(PurchaseOrderItem purchaseOrderItem) {

  }

  @Override
  public String getValue() {
    return RECEIVED_ORDER_ITEM_STATE;
  }
}
