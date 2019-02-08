package com.ello.masterchef.sales.dao;

import com.ello.masterchef.sales.model.SalesChannel;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.core.MultiMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ChannelDao {

  private final HazelcastInstance channelControl;

  @Autowired
  public ChannelDao(@Qualifier("channelControl") HazelcastInstance channelControl) {
    this.channelControl = channelControl;
  }

  public void create(String channelMap, SalesChannel salesChannel) {
    MultiMap<String, SalesChannel> multiMap = channelControl.getMultiMap(channelMap);
    multiMap.put(salesChannel.getIdentifier(), salesChannel);
  }

  public List<SalesChannel> findAll(String channelMap) {
    MultiMap<String, SalesChannel> multiMap = channelControl.getMultiMap(channelMap);
    return (List<SalesChannel>) multiMap.values();
  }

}
