package com.luanelioliveira.gobarber.application.usecases.events.consumers;

import com.luanelioliveira.gobarber.domain.events.CustomerCreatedEvent;
import javax.inject.Named;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;

@Slf4j
@Named
public class CustomerCreatedEventListener {

  @EventListener
  public void listen(CustomerCreatedEvent event) {
    log.info("Event received: {}", event);
  }
}
