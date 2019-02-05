package com.ello.masterchef.integration;

import com.ello.masterchef.catalog.model.CatalogItem;

public class SubItemLimitRule implements Rule<CatalogItem, Integer> {

    @Override
    public Integer apply(CatalogItem catalogItem) {
        return null;
    }
}
