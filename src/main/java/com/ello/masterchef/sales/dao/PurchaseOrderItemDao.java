package com.ello.masterchef.sales.dao;

import com.ello.masterchef.sales.model.PurchaseOrderItem;
import com.ello.masterchef.sales.model.mapper.PurchaseOrderItemRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

import static com.ello.masterchef.sales.dao.SalesQueryUtils.FIND_ALL_PURCHASE_ORDER_ITEM_BY_PURCHASE_ORDER_ID;

@Repository
public class PurchaseOrderItemDao {

  private final JdbcTemplate jdbcTemplate;

  @Autowired
  public PurchaseOrderItemDao(JdbcTemplate jdbcTemplate) {
    this.jdbcTemplate = jdbcTemplate;
  }

  @Transactional
  public void save(UUID purchaseOrderId, PurchaseOrderItem purchaseOrderItem) {
    jdbcTemplate.update("INSERT INTO purchase_order VALUES(?,?,?,?,?,?,?,?,?)",
      purchaseOrderItem.getPurchaseOrderItemId(),
      purchaseOrderItem.getCatalogItemId(),
      purchaseOrderId.toString(),
      purchaseOrderItem.getPurchaseOrderItemState().getValue(),
      purchaseOrderItem.getPurchaseOrderItemType(),
      purchaseOrderItem.getPurchaseOrderItemParentId().orElse(null),
      purchaseOrderItem.getPrice(),
      purchaseOrderItem.getAmount(),
      purchaseOrderItem.getKg());
  }

  public List<PurchaseOrderItem> findPurchaseOrderItemsByPurchaseOrderId(UUID purchaseOrderId) {
    return jdbcTemplate.query(FIND_ALL_PURCHASE_ORDER_ITEM_BY_PURCHASE_ORDER_ID, new UUID[]{purchaseOrderId}, new PurchaseOrderItemRowMapper());
  }
}
