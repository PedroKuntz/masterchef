package com.ello.masterchef.sales.service;

import com.ello.masterchef.catalog.model.CatalogItem;
import com.ello.masterchef.catalog.service.CatalogService;
import com.ello.masterchef.integration.IntegrationService;
import com.ello.masterchef.sales.dao.PrinterDao;
import com.ello.masterchef.sales.model.PurchaseOrder;
import com.ello.masterchef.sales.model.PurchaseOrderItem;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.core.IQueue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PrinterService {

    private final HazelcastInstance cartInstance;
    private final PrinterDao printerDao;
    private final IntegrationService integrationService;

    @Autowired
    public PrinterService(@Qualifier("shoppingCart") HazelcastInstance cartInstance,
                          PrinterDao printerDao,
                          IntegrationService integrationService) {
        this.cartInstance = cartInstance;
        this.integrationService = integrationService;
        this.printerDao = printerDao;
    }

    public void notifyToPrepare(PurchaseOrder purchaseOrder) {
        Optional<CatalogItem> catalogItem = purchaseOrder.getPurchaseOrderItems()
                .stream()
                .map(PurchaseOrderItem::getCatalogItemId)
                .map(catalogItemId -> integrationService.findById(catalogItemId))
                .findAny();
        catalogItem.ifPresent(item -> {
            addQueue(item);
            persistQueue(item);
        });
    }

    public CatalogItem findQueue() {
        IQueue<CatalogItem> printQueue = cartInstance.getQueue("print");
        return printQueue.peek();
    }

    public void removeItemInQueue(CatalogItem catalogItem) {
        IQueue<CatalogItem> printQueue = cartInstance.getQueue("print");
        printQueue.remove(catalogItem);
        printerDao.delete(catalogItem);
    }

    private void addQueue(CatalogItem catalogItem) {
        IQueue<CatalogItem> printQueue = cartInstance.getQueue("print");
        printQueue.add(catalogItem);
    }

    private void persistQueue(CatalogItem catalogItem) {
        printerDao.save(catalogItem);
    }

}
