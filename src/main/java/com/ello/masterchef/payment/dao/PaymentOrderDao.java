package com.ello.masterchef.payment.dao;

import com.ello.masterchef.payment.model.PaymentOrder;
import com.ello.masterchef.payment.model.mapper.PaymentOrderJoinPaymentRowMapper;
import com.ello.masterchef.payment.model.mapper.PaymentOrderRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.UUID;

import static com.ello.masterchef.payment.dao.PaymentQueryUtils.FIND_BY_PURCHASE_ORDER_ID;
import static com.ello.masterchef.payment.dao.PaymentQueryUtils.FIND_COMPLETE_BY_PURCHASE_ORDER_ID;

@Repository
public class PaymentOrderDao {

  private final JdbcTemplate jdbcTemplate;

  public PaymentOrderDao(JdbcTemplate jdbcTemplate) {
    this.jdbcTemplate = jdbcTemplate;
  }

  public void save(PaymentOrder paymentOrder) {
    jdbcTemplate.update("INSERT INTO payment_order VALUES (?,?,?,?,?,?,?)",
      paymentOrder.getPaymentOrderId(),
      paymentOrder.getPurchaseOrderId(),
      paymentOrder.getPaymentOrderState(),
      paymentOrder.getTotalValue(),
      paymentOrder.getReduceValue(),
      paymentOrder.getIncrementValue(),
      paymentOrder.getTax());
  }

  public void updateState(PaymentOrder paymentOrder) {
    jdbcTemplate.update("UPDATE payment_order SET payment_order_state = ? WHERE payment_order_id = ?",
      paymentOrder.getPaymentOrderState(),
      paymentOrder.getPaymentOrderId());
  }

  public PaymentOrder findByPurchaseOrderId(UUID purchaseOrderId) {
    return jdbcTemplate.queryForObject(FIND_BY_PURCHASE_ORDER_ID, new UUID[]{purchaseOrderId}, new PaymentOrderRowMapper());
  }

  public PaymentOrder findPaymentOrderCompleteByPurchaseOrderId(UUID purchaseOrderId) {
    return jdbcTemplate.queryForObject(FIND_COMPLETE_BY_PURCHASE_ORDER_ID, new UUID[]{purchaseOrderId}, new PaymentOrderJoinPaymentRowMapper());
  }

}
