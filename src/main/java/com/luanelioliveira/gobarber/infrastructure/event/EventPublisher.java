package com.luanelioliveira.gobarber.infrastructure.event;

import com.luanelioliveira.gobarber.domain.event.Event;

public abstract class EventPublisher {
  public abstract void publish(Event event);
}
