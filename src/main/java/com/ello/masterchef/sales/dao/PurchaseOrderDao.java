package com.ello.masterchef.sales.dao;

import com.ello.masterchef.sales.model.PurchaseOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public class PurchaseOrderDao {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public PurchaseOrderDao purchaseOrderDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void save(PurchaseOrder purchaseOrder) {

    }

    public PurchaseOrder findById(UUID purchaseOrderId) {
        return jdbcTemplate.query("SELECT purchase_order_id FROM purchase_order WHERE purchase_order_id = ?");
    }
}
