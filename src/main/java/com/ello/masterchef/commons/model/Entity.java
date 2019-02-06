package com.ello.masterchef.commons.model;

import java.time.LocalDateTime;

public interface Entity {

  default LocalDateTime createdAt() {
    return LocalDateTime.now();
  }

  default LocalDateTime updatedAt() {
    return LocalDateTime.now();
  }
}
