package com.ello.masterchef.sales.model.state;

import com.ello.masterchef.commons.model.State;
import com.ello.masterchef.sales.model.PurchaseOrder;

public class PreClosedOrderState implements State<PurchaseOrder> {
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
        return null;
    }
}
