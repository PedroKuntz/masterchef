package com.ello.masterchef.sales.service;

import com.ello.masterchef.sales.model.PurchaseOrder;

public interface ChannelStrategy {

  void preClose(PurchaseOrder purchaseOrder);
  void close(PurchaseOrder purchaseOrder);

}
