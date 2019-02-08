package com.ello.masterchef.sales.service;

import com.ello.masterchef.sales.dao.ChannelDao;
import com.ello.masterchef.sales.model.SalesChannel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

  public SalesChannel findAllTables() {
    return this.channelDao.findAll(CHANNEL_TABLE);
  }

  public SalesChannel findAllCards() {
    return this.channelDao.findAll(CHANNEL_CARD);
  }

}
