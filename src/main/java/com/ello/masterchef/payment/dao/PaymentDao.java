package com.ello.masterchef.payment.dao;

import com.ello.masterchef.payment.model.Payment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public class PaymentDao {

  private final JdbcTemplate jdbcTemplate;

  public PaymentDao(JdbcTemplate jdbcTemplate) {
    this.jdbcTemplate = jdbcTemplate;
  }

  public void save(UUID paymentOrderId, Payment payment) {
    jdbcTemplate.update("INSERT INTO payment (payment_id, payment_order_id, payment_method, value) VALUES (?,?,?,?)",
      payment.getPaymentId(),
      paymentOrderId,
      payment.getPaymentMethod(),
      payment.getValue());
  }

}
