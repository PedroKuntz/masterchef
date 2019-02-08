package com.ello.masterchef.integration.configuration;

import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class HazelcastConfigurationBean {

  @Bean
  @Qualifier(value = "shoppingCart")
  public HazelcastInstance hazelcastInstance() {
     return Hazelcast.newHazelcastInstance();
  }

  @Bean
  @Qualifier(value = "channelControl")
  public HazelcastInstance channelControl() {
    return Hazelcast.newHazelcastInstance();
  }

}
