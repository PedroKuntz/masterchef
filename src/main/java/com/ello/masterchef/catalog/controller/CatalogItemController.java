package com.ello.masterchef.catalog.controller;

import com.ello.masterchef.catalog.service.CatalogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/catalog")
public class CatalogItemController {

  @Autowired
  private CatalogService catalogService;

  @GetMapping
  public ResponseEntity<?> getAllCatalogItem() {
    return new ResponseEntity(catalogService.findAllCatalogItem(),HttpStatus.OK);
  }

  @GetMapping(value = "/firstLevel")
  public ResponseEntity<?> getAllFirstLevel() {
    return new ResponseEntity(catalogService.findAllCatalogItemFirstLevel(),HttpStatus.OK);
  }

}
