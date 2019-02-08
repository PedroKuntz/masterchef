package com.ello.masterchef.sales.service;

import com.ello.masterchef.integration.service.IntegrationService;
import com.ello.masterchef.sales.model.PurchaseOrder;
import com.ello.masterchef.sales.model.PurchaseOrderItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

import static com.ello.masterchef.integration.model.StateConstants.RECEIVED_ORDER_ITEM_STATE;

@Service
public class TableChannelStrategy implements ChannelStrategy {

  private final IntegrationService integrationService;

  @Autowired
  public TableChannelStrategy(IntegrationService integrationService) {
    this.integrationService = integrationService;
  }

  @Override
  public void preClose(PurchaseOrder purchaseOrder) {
    Optional<PurchaseOrderItem> purchaseOrderItemsNotReceived = purchaseOrder.getPurchaseOrderItems().stream().filter(item -> !item.getPurchaseOrderItemState().equals(RECEIVED_ORDER_ITEM_STATE)).findAny();
    if (purchaseOrderItemsNotReceived.isPresent()) {
      throw new IllegalArgumentException("O Item " + purchaseOrderItemsNotReceived.get().getPurchaseOrderItemId() + " não está entregue! Favor, providenciar a entrega do item para que possa fazer o pré-fechamento!");
    }
    integrationService.createPaymentOrder(purchaseOrder);
  }

  @Override
  public void close(PurchaseOrder purchaseOrder) {
    purchaseOrder.nextState();
    integrationService.savePurchaseOrder(purchaseOrder);
  }

}
