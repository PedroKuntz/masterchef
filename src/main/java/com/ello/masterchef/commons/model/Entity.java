package com.ello.masterchef.commons.model;

import java.io.Serializable;
import java.time.LocalDateTime;

public interface Entity extends Serializable {

  default LocalDateTime createdAt() {
    return LocalDateTime.now();
  }

  default LocalDateTime updatedAt() {
    return LocalDateTime.now();
  }
}
