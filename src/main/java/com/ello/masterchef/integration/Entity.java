package com.ello.masterchef.integration;

import java.time.LocalDateTime;

public interface Entity {

  default LocalDateTime createdAt() {
    return LocalDateTime.now();
  }

  default LocalDateTime updatedAt() {
    return LocalDateTime.now();
  }
}
