package com.luanelioliveira.gobarber.core.infrastructure.event;

import com.luanelioliveira.gobarber.customers.domain.event.Event;

public abstract class EventPublisher {
  public abstract void publish(Event event);
}
