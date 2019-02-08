package com.ello.masterchef.sales.model.mapper;

import com.ello.masterchef.commons.model.State;
import com.ello.masterchef.sales.model.ClosedOrderState;
import com.ello.masterchef.sales.model.DeliveryOrderItemState;
import com.ello.masterchef.sales.model.InProgressOrderItemState;
import com.ello.masterchef.sales.model.OpenedOrderState;
import com.ello.masterchef.sales.model.PurchaseOrder;
import com.ello.masterchef.sales.model.PurchaseOrderItem;
import com.ello.masterchef.sales.model.ReceivedOrderItemState;

import static com.ello.masterchef.integration.model.StateConstants.DELIVERY_ORDER_ITEM_STATE;
import static com.ello.masterchef.integration.model.StateConstants.IN_PROGRESS_ORDER_ITEM_STATE;
import static com.ello.masterchef.integration.model.StateConstants.OPENED_ORDER_STATE;

public class SalesStateMapper {

  public static State<PurchaseOrder> purchaseOrderStateTo(String stateName) {
    if (OPENED_ORDER_STATE.equalsIgnoreCase(stateName)) {
      return new OpenedOrderState();
    } else {
      return new ClosedOrderState();
    }
  }

  public static State<PurchaseOrderItem> purchaseOrderItemStateTo(String stateName) {
    if (IN_PROGRESS_ORDER_ITEM_STATE.equalsIgnoreCase(stateName)) {
      return new InProgressOrderItemState();
    } else if (DELIVERY_ORDER_ITEM_STATE.equalsIgnoreCase(stateName)) {
      return new DeliveryOrderItemState();
    } else {
      return new ReceivedOrderItemState();
    }
  }

}
