package com.ello.masterchef.sales.dao;

import com.ello.masterchef.catalog.model.CatalogItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class PrinterDao {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public PrinterDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void save(CatalogItem catalogItem) {
        jdbcTemplate.update("INSERT INTO items_queue VALUES (?,?,?,?,?,?)",
                catalogItem.getItemId(),
                catalogItem.getNameItem(),
                catalogItem.getDescription(),
                catalogItem.getAmount(),
                catalogItem.getKg(),
                catalogItem.getCatalogItemType());
    }

    public void delete(CatalogItem catalogItem) {
        jdbcTemplate.update("DELETE FROM items_queue WHERE item_id = ?", catalogItem.getItemId());
    }

}
