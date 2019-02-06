package com.ello.masterchef.sales.model.mapper;

import com.ello.masterchef.sales.model.PurchaseOrderItem;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;
import java.util.UUID;

import static com.ello.masterchef.sales.model.mapper.SalesStateMapper.purchaseOrderItemStateTo;

public class PurchaseOrderItemRowMapper implements RowMapper<PurchaseOrderItem> {

  @Override
  public PurchaseOrderItem mapRow(ResultSet row, int i) throws SQLException {
    PurchaseOrderItem purchaseOrderItem = new PurchaseOrderItem();
    purchaseOrderItem.setPurchaseOrderItemId(UUID.fromString(row.getString("purchase_order_item_id")));
    purchaseOrderItem.setCatalogItemId(UUID.fromString(row.getString("catalog_item_id")));
    purchaseOrderItem.setPurchaseOrderItemState(purchaseOrderItemStateTo(row.getString("purchase_order_item_state")));
    purchaseOrderItem.setPurchaseOrderItemParentId(Optional.ofNullable(UUID.fromString(row.getString("purchase_order_item_parent_id"))));
    purchaseOrderItem.setPrice(row.getDouble("price"));
    purchaseOrderItem.setAmount(row.getInt("amount"));
    purchaseOrderItem.setKg(row.getDouble("kg"));
    return purchaseOrderItem;
  }
}
