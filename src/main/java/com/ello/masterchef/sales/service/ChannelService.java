package com.ello.masterchef.sales.service;

import com.ello.masterchef.sales.dao.ChannelDao;
import com.ello.masterchef.sales.model.SalesChannel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static com.ello.masterchef.sales.model.ChannelUtils.CHANNEL_CARD;
import static com.ello.masterchef.sales.model.ChannelUtils.CHANNEL_TABLE;

@Service
public class ChannelService {

  private final ChannelDao channelDao;

  @Autowired
  public ChannelService(ChannelDao channelDao) {
    this.channelDao = channelDao;
  }

  public void create(SalesChannel salesChannel) {
    switch (salesChannel.getChannel().getValue()) {
      case "TABLE" :
        this.channelDao.create(CHANNEL_TABLE, salesChannel);
      case "CARD" :
        this.channelDao.create(CHANNEL_CARD, salesChannel);
    }
  }

  public List<SalesChannel> findAllTables() {
    return this.channelDao.findAll(CHANNEL_TABLE);
  }

  public List<SalesChannel> findAllCards() {
    return this.channelDao.findAll(CHANNEL_CARD);
  }

  public void selectCard(String tableId, SalesChannel salesChannel) {
    Optional<SalesChannel> table = this.findAllCards().stream().filter(c -> c.getIdentifier().equalsIgnoreCase(tableId)).findAny();
    table.ifPresent(t -> t.setPurchaseOrderId(salesChannel.getPurchaseOrderId()));
  }

  public void selectTable(String tableId, SalesChannel salesChannel) {
    Optional<SalesChannel> table = this.findAllTables().stream().filter(c -> c.getIdentifier().equalsIgnoreCase(tableId)).findAny();
    table.ifPresent(t -> t.setPurchaseOrderId(salesChannel.getPurchaseOrderId()));
  }

  public void clearTable(String tableId, SalesChannel salesChannel) {
    Optional<SalesChannel> table = this.findAllTables().stream().filter(c -> c.getIdentifier().equalsIgnoreCase(tableId)).findAny();
    table.ifPresent(t -> t.setCleared(true));
  }

}
