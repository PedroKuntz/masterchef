package com.ello.masterchef.catalog.dao;

import com.ello.masterchef.catalog.model.CatalogItem;
import com.ello.masterchef.catalog.model.mapper.CompactCatalogItemRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CatalogItemDao {

  private JdbcTemplate jdbcTemplate;

  @Autowired
  public CatalogItemDao(JdbcTemplate jdbcTemplate) {
    this.jdbcTemplate = jdbcTemplate;
  }

  public List<CatalogItem> findAll() {
    return jdbcTemplate.query("SELECT catalog_item_id, item_id, name_item, description, catalog_item_type FROM chef.catalog_item", new CompactCatalogItemRowMapper());
  }

  public List<CatalogItem> findAllFirstLevel() {
    return jdbcTemplate.query("SELECT catalog_item_id, item_id, name_item, description, catalog_item_type FROM chef.catalog_item WHERE catalog_item_type IN ('UNIT','UNIT_PARENT')", new CompactCatalogItemRowMapper());
  }

}

