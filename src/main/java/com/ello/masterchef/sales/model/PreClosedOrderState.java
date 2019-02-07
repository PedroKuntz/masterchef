package com.ello.masterchef.sales.model;

import com.ello.masterchef.commons.model.State;

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
