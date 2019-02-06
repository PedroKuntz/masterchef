package com.ello.masterchef.catalog.service;

import com.ello.masterchef.catalog.dao.CatalogItemDao;
import com.ello.masterchef.catalog.model.CatalogItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class CatalogService {

  private CatalogItemDao catalogItemDao;

  @Autowired
  public CatalogService(CatalogItemDao catalogItemDao) {
    this.catalogItemDao = catalogItemDao;
  }

  public List<CatalogItem> findAllCatalogItem() {
    return catalogItemDao.findAll();
  }

  public List<CatalogItem> findAllCatalogItemFirstLevel() {
    return catalogItemDao.findAllFirstLevel();
  }

  public CatalogItem findById(UUID catalogItemId) {
    return catalogItemDao.findById(catalogItemId);
  }

}
