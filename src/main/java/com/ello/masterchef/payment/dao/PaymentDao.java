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

    }

    public void update(Payment payment) {

    }

}
