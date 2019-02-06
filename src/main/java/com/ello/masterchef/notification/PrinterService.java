package com.ello.masterchef.notification;

import com.ello.masterchef.catalog.model.CatalogItem;
import com.ello.masterchef.catalog.service.CatalogService;
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
  private final CatalogService catalogService;

  @Autowired
  public PrinterService(@Qualifier("shoppingCart") HazelcastInstance cartInstance,
                        CatalogService catalogService) {
    this.cartInstance = cartInstance;
    this.catalogService = catalogService;
  }

  public void notifyToPrepare(PurchaseOrder purchaseOrder) {
    Optional<CatalogItem> catalogItem = purchaseOrder.getPurchaseOrderItems()
      .stream()
      .map(PurchaseOrderItem::getCatalogItemId)
      .map(catalogItemId -> catalogService.findById(catalogItemId))
      .findAny();
    catalogItem.ifPresent(item -> addQueue(item));
  }

  private IQueue addQueue(CatalogItem catalogItem) {
    IQueue<CatalogItem> printQueue = cartInstance.getQueue("print");
    printQueue.add(catalogItem);

  }

  private void persistQueue() {

  }

}
