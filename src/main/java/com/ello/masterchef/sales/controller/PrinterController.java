package com.ello.masterchef.sales.controller;

import com.ello.masterchef.catalog.model.CatalogItem;
import com.ello.masterchef.sales.service.PrinterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController(value = "/print")
public class PrinterController {

    @Autowired
    private PrinterService printerService;

    @GetMapping
    public ResponseEntity<?> findQueue() {
        return new ResponseEntity(printerService.findQueue(), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<?> removeItemInQueue(@RequestBody CatalogItem catalogItem) {
        printerService.removeItemInQueue(catalogItem);
        return new ResponseEntity(HttpStatus.OK);
    }

}
