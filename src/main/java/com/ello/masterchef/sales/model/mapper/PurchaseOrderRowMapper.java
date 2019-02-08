package com.ello.masterchef.sales.model.mapper;

import com.ello.masterchef.sales.model.Channel;
import com.ello.masterchef.sales.model.PurchaseOrder;
import com.ello.masterchef.sales.model.PurchaseOrderType;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

import static com.ello.masterchef.sales.model.mapper.SalesStateMapper.purchaseOrderStateTo;

public class PurchaseOrderRowMapper implements RowMapper<PurchaseOrder> {

  @Override
  public PurchaseOrder mapRow(ResultSet row, int i) throws SQLException {
    PurchaseOrder purchaseOrder = new PurchaseOrder();
    purchaseOrder.setPurchaseId(UUID.fromString(row.getString("purchase_order_id")));
    purchaseOrder.setEmployee(UUID.fromString(row.getString("employee_id")));
    purchaseOrder.setPurchaseOrderState(purchaseOrderStateTo(row.getString("purchase_order_state")));
    purchaseOrder.setPurchaseOrderType(PurchaseOrderType.valueOf(row.getString("purchase_order_type")));
    purchaseOrder.setChannel(Channel.valueOf(row.getString("channel")));
    purchaseOrder.setTotalPrice(row.getDouble("total_price"));
    return purchaseOrder;
  }
}
