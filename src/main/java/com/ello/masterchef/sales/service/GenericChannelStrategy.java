package com.ello.masterchef.sales.service;

import com.ello.masterchef.integration.service.IntegrationService;
import com.ello.masterchef.sales.model.PurchaseOrder;
import org.springframework.stereotype.Service;

@Service
public class GenericChannelStrategy implements ChannelStrategy{

  private final IntegrationService integrationService;

  public GenericChannelStrategy(IntegrationService integrationService) {
    this.integrationService = integrationService;
  }

  @Override
  public void preClose(PurchaseOrder purchaseOrder) {

  }

  @Override
  public void close(PurchaseOrder purchaseOrder) {

  }
}
