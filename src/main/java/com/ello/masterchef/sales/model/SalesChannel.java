package com.ello.masterchef.sales.model;

import com.ello.masterchef.commons.model.Entity;

public class SalesChannel implements Entity {

  private String identifier;
  private Channel channel;
  private boolean isCleared;
  private boolean isEmpty;
  private boolean isBlocked;
  private String description;

  public SalesChannel() {}

  public String getIdentifier() {
    return identifier;
  }

  public SalesChannel setIdentifier(String identifier) {
    this.identifier = identifier;
    return this;
  }

  public Channel getChannel() {
    return channel;
  }

  public SalesChannel setChannel(Channel channel) {
    this.channel = channel;
    return this;
  }

  public boolean isCleared() {
    return isCleared;
  }

  public SalesChannel setCleared(boolean cleared) {
    isCleared = cleared;
    return this;
  }

  public boolean isEmpty() {
    return isEmpty;
  }

  public SalesChannel setEmpty(boolean empty) {
    isEmpty = empty;
    return this;
  }

  public boolean isBlocked() {
    return isBlocked;
  }

  public SalesChannel setBlocked(boolean blocked) {
    isBlocked = blocked;
    return this;
  }

  public String getDescription() {
    return description;
  }

  public SalesChannel setDescription(String description) {
    this.description = description;
    return this;
  }
}
