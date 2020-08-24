package com.luanelioliveira.gobarber.infrastructure.event;

import com.luanelioliveira.gobarber.domain.event.Event;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class EventPublisherImpl extends EventPublisher {

  private final ApplicationEventPublisher publisher;

  @Override
  public void publish(Event event) {
    log.info("Event published: {}", event);
    publisher.publishEvent(event);
  }
}
