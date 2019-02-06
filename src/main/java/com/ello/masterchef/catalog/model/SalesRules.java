package com.ello.masterchef.catalog.model;

import com.ello.masterchef.commons.model.Entity;

import java.util.UUID;

public class SalesRules implements Entity {

  private UUID ruleId;
  private String dayValidation;
  private String description;

  public SalesRules() {}

  public UUID getRuleId() {
    return ruleId;
  }

  public SalesRules setRuleId(UUID ruleId) {
    this.ruleId = ruleId;
    return this;
  }

  public String getDateValidation() {
    return dayValidation;
  }

  public SalesRules setDateValidation(String dateValidation) {
    this.dayValidation = dayValidation;
    return this;
  }

  public String getDescription() {
    return description;
  }

  public SalesRules setDescription(String description) {
    this.description = description;
    return this;
  }
}
