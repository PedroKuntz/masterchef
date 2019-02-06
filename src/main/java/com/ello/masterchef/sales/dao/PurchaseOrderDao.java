package com.ello.masterchef.sales.dao;

import com.ello.masterchef.sales.model.PurchaseOrder;
import com.ello.masterchef.sales.model.mapper.PurchaseOrderRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

import static com.ello.masterchef.sales.dao.SalesQueryLanguage.FIND_ALL_PURCHASE_ORDER;
import static com.ello.masterchef.sales.dao.SalesQueryLanguage.FIND_PURCHASE_ORDER_BY_ID;

@Repository
public class PurchaseOrderDao {

  private JdbcTemplate jdbcTemplate;

  @Autowired
  public PurchaseOrderDao(JdbcTemplate jdbcTemplate) {
    this.jdbcTemplate = jdbcTemplate;
  }

  @Transactional
  public void save(PurchaseOrder purchaseOrder) {
    jdbcTemplate.update("INSERT INTO purchase_order VALUES(?,?,?,?,?,?)",
      purchaseOrder.getPurchaseId(),
      purchaseOrder.getEmployee(),
      purchaseOrder.getPurchaseOrderType(),
      purchaseOrder.getChannel(),
      purchaseOrder.getPurchaseOrderState().getValue(),
      purchaseOrder.getTotalPrice());
  }

  public List<PurchaseOrder> findAll() {
    return jdbcTemplate.query(FIND_ALL_PURCHASE_ORDER, new PurchaseOrderRowMapper());
  }

  public PurchaseOrder findById(UUID purchaseOrderId) {
    return jdbcTemplate.queryForObject(FIND_PURCHASE_ORDER_BY_ID, new UUID[]{purchaseOrderId}, new PurchaseOrderRowMapper());
  }

}
