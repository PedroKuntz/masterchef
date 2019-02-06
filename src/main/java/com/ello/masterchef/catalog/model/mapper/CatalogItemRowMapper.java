package com.ello.masterchef.catalog.model.mapper;

import com.ello.masterchef.catalog.model.CatalogItem;
import com.ello.masterchef.catalog.model.CatalogItemType;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

public class CatalogItemRowMapper implements RowMapper<CatalogItem> {

  @Override
  public CatalogItem mapRow(ResultSet row, int i) throws SQLException {
    CatalogItem catalogItem = new CatalogItem();
    catalogItem.setCatalogItemId(UUID.fromString(row.getString("catalog_item_id")));
    catalogItem.setItemId(row.getLong("item_id"));
    catalogItem.setNameItem(row.getString("name_item"));
    catalogItem.setDescription(row.getString("description"));
    catalogItem.setCatalogItemType(CatalogItemType.valueOf(row.getString("catalog_item_type")));
    return catalogItem;
  }
}
