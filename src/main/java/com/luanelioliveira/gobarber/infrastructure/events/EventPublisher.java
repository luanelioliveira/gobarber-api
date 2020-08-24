package com.luanelioliveira.gobarber.infrastructure.events;

import com.luanelioliveira.gobarber.domain.events.Event;

public abstract class EventPublisher {
  public abstract void publish(Event event);
}
