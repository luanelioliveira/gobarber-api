package com.luanelioliveira.gobarber.domain.events;

import java.time.LocalDateTime;
import java.util.UUID;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public abstract class Event {

  private UUID id;
  private LocalDateTime createdAt;

  public Event() {
    this.id = UUID.randomUUID();
    this.createdAt = LocalDateTime.now();
  }
}
