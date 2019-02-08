package com.ello.masterchef.sales.service;

import com.ello.masterchef.payment.model.PaymentOrder;
import com.ello.masterchef.payment.service.PaymentService;
import com.ello.masterchef.sales.model.Cart;
import com.ello.masterchef.sales.model.PurchaseOrder;
import com.ello.masterchef.sales.model.PurchaseOrderItem;
import com.ello.masterchef.sales.model.exception.CloseOrderException;
import com.ello.masterchef.sales.model.exception.PreCloseOrderException;
import org.springframework.stereotype.Service;

import java.util.Optional;

import static com.ello.masterchef.integration.model.StateConstants.CLOSED_ORDER_STATE;
import static com.ello.masterchef.integration.model.StateConstants.OPENED_ORDER_STATE;
import static com.ello.masterchef.integration.model.StateConstants.RECEIVED_ORDER_ITEM_STATE;

@Service
public class GenericChannelStrategy implements ChannelStrategy {

  private final CartService cartService;
  private final PurchaseOrderService purchaseOrderService;
  private final PaymentService paymentService;

  public GenericChannelStrategy(CartService cartService, PurchaseOrderService purchaseOrderService, PaymentService paymentService) {
    this.cartService = cartService;
    this.purchaseOrderService = purchaseOrderService;
    this.paymentService = paymentService;
  }

  @Override
  public void preClose(PurchaseOrder purchaseOrder) {
    if (purchaseOrder.getPurchaseOrderState().getValue().equalsIgnoreCase(CLOSED_ORDER_STATE)) {
      throw new PreCloseOrderException("Pedido de Compra já está fechado!");
    }
    Optional<Cart> cart = cartService.findCartById(purchaseOrder.getPurchaseId());
    cart.ifPresent(c -> purchaseOrderService.sendPurchaseOrder(c.getCartId()));
    paymentService.createPaymentOrder(purchaseOrder);
  }

  @Override
  public void close(PurchaseOrder purchaseOrder) {
    Optional<PurchaseOrderItem> purchaseOrderItemsNotReceived = purchaseOrder.getPurchaseOrderItems().stream().filter(item -> !item.getPurchaseOrderItemState().equals(RECEIVED_ORDER_ITEM_STATE)).findAny();
    if (purchaseOrderItemsNotReceived.isPresent()) {
      throw new CloseOrderException("O Item " + purchaseOrderItemsNotReceived.get().getPurchaseOrderItemId() + " não está entregue! Favor, providenciar a entrega do item para que possa fazer o pré-fechamento!");
    }

    PaymentOrder paymentOrder = paymentService.findByPurchaseOrderId(purchaseOrder.getPurchaseId());
    if (paymentOrder.getPaymentOrderState().getValue().equalsIgnoreCase(OPENED_ORDER_STATE)) {
      throw new CloseOrderException("Ordem de pagamento ainda não está fechada!");
    }

    purchaseOrder.nextState();
    purchaseOrderService.updateState(purchaseOrder);

  }
}
