package com.ello.masterchef.sales.model.state;

import com.ello.masterchef.commons.model.State;
import com.ello.masterchef.sales.model.PurchaseOrderItem;

import static com.ello.masterchef.integration.model.StateConstants.DELIVERY_ORDER_ITEM_STATE;

public class DeliveryOrderItemState implements State<PurchaseOrderItem> {

  public DeliveryOrderItemState() {}

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
    return DELIVERY_ORDER_ITEM_STATE;
  }
}
