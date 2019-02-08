package com.ello.masterchef.sales.dao;

import com.ello.masterchef.sales.model.SalesChannel;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.core.IMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

@Repository
public class ChannelDao {

  private final HazelcastInstance channelControl;

  @Autowired
  public ChannelDao(@Qualifier("channelControl") HazelcastInstance channelControl) {
    this.channelControl = channelControl;
  }

  public void create(String channelMap, SalesChannel salesChannel) {
    IMap<String, SalesChannel> channelIMap = channelControl.getMap(channelMap);
    channelIMap.put(salesChannel.getIdentifier(), salesChannel);
  }

  public SalesChannel findAll(String channelMap) {
    IMap<String, SalesChannel> channelIMap = channelControl.getMap(channelMap);
    return channelIMap.get(channelMap);
  }

}
