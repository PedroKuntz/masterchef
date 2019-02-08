package com.ello.masterchef.integration.model;

import com.ello.masterchef.catalog.model.CatalogItem;
import com.ello.masterchef.commons.model.Rule;

public class SubItemLimitRule implements Rule<CatalogItem, Integer> {

    @Override
    public Integer apply(CatalogItem catalogItem) {
        return null;
    }
}
