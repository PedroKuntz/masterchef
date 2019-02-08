package com.ello.masterchef.sales.service;

import com.ello.masterchef.integration.service.IntegrationService;
import com.ello.masterchef.sales.model.Cart;
import com.ello.masterchef.sales.model.PurchaseOrder;
import com.ello.masterchef.sales.model.PurchaseOrderItem;
import com.ello.masterchef.sales.model.exception.CloseOrderException;
import com.ello.masterchef.sales.model.exception.PreCloseOrderException;
import org.springframework.stereotype.Service;

import java.util.Optional;

import static com.ello.masterchef.integration.model.StateConstants.CLOSED_ORDER_STATE;
import static com.ello.masterchef.integration.model.StateConstants.RECEIVED_ORDER_ITEM_STATE;

@Service
public class GenericChannelStrategy implements ChannelStrategy {

  private final IntegrationService integrationService;

  public GenericChannelStrategy(IntegrationService integrationService) {
    this.integrationService = integrationService;
  }

  @Override
  public void preClose(PurchaseOrder purchaseOrder) {
    if (purchaseOrder.getPurchaseOrderState().getValue().equalsIgnoreCase(CLOSED_ORDER_STATE)) {
      throw new PreCloseOrderException("Pedido de Compra já está fechado!");
    }
    Optional<Cart> cart = integrationService.findCartById(purchaseOrder.getPurchaseId());
    cart.ifPresent(c -> integrationService.sendPurchaseOrderByCartId(c.getCartId()));
    integrationService.createPaymentOrder(purchaseOrder);
  }

  @Override
  public void close(PurchaseOrder purchaseOrder) {
    Optional<PurchaseOrderItem> purchaseOrderItemsNotReceived = purchaseOrder.getPurchaseOrderItems().stream().filter(item -> !item.getPurchaseOrderItemState().equals(RECEIVED_ORDER_ITEM_STATE)).findAny();
    if (purchaseOrderItemsNotReceived.isPresent()) {
      throw new CloseOrderException("O Item " + purchaseOrderItemsNotReceived.get().getPurchaseOrderItemId() + " não está entregue! Favor, providenciar a entrega do item para que possa fazer o pré-fechamento!");
    }


    purchaseOrder.nextState();
    integrationService.updatePurchaseOrderState(purchaseOrder);

  }
}
