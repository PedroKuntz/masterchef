package com.ello.masterchef.payment.dao;

import com.ello.masterchef.payment.model.PaymentOrder;
import com.ello.masterchef.payment.model.mapper.PaymentOrderRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.UUID;

import static com.ello.masterchef.payment.dao.PaymentQueryUtils.FIND_BY_PURCHASE_ORDER_ID;

@Repository
public class PaymentOrderDao {

    private final JdbcTemplate jdbcTemplate;

    public PaymentOrderDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void save(PaymentOrder paymentOrder) {

    }

    public void update(PaymentOrder paymentOrder) {

    }

    public PaymentOrder findByPurchaseOrderId(UUID purchaseOrderId) {
        return jdbcTemplate.queryForObject(FIND_BY_PURCHASE_ORDER_ID, new UUID[]{purchaseOrderId}, new PaymentOrderRowMapper());
    }

}
