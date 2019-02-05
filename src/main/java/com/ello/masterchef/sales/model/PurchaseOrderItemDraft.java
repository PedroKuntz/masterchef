package com.ello.masterchef.sales.model;

import com.ello.masterchef.catalog.model.CatalogItemType;
import com.ello.masterchef.integration.Entity;

import java.util.List;
import java.util.UUID;

public class PurchaseOrderItemDraft implements Entity {

    private UUID catalogItemId;
    private String nameItem;
    private String description;
    private Double price;
    private CatalogItemType catalogItemType;
    private List<UUID> subItemsId;

    public PurchaseOrderItemDraft() {}

    public UUID getCatalogItemId() {
        return catalogItemId;
    }

    public void setCatalogItemId(UUID catalogItemId) {
        this.catalogItemId = catalogItemId;
    }

    public CatalogItemType getCatalogItemType() {
        return catalogItemType;
    }

    public void setCatalogItemType(CatalogItemType catalogItemType) {
        this.catalogItemType = catalogItemType;
    }

    public List<UUID> getSubItemsId() {
        return subItemsId;
    }

    public void setSubItemsId(List<UUID> subItemsId) {
        this.subItemsId = subItemsId;
    }

    public String getNameItem() {
        return nameItem;
    }

    public void setNameItem(String nameItem) {
        this.nameItem = nameItem;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
