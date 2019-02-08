package com.ello.masterchef.payment.model.mapper;

import com.ello.masterchef.payment.model.Payment;
import com.ello.masterchef.payment.model.PaymentMethod;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

public class PaymentRowMapper implements RowMapper<Payment> {
  @Override
  public Payment mapRow(ResultSet row, int i) throws SQLException {
    Payment payment = new Payment();
    payment.setPaymentId(UUID.fromString(row.getString("payment_id")));
    payment.setPaymentMethod(PaymentMethod.valueOf(row.getString("payment_method")));
    payment.setValue(row.getDouble("value"));
    return payment;
  }
}
