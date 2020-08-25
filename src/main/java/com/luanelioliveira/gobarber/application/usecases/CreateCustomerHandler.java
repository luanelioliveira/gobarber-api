package com.luanelioliveira.gobarber.application.usecases;

import com.luanelioliveira.gobarber.domain.events.CustomerCreatedEvent;
import com.luanelioliveira.gobarber.domain.models.Customer;
import com.luanelioliveira.gobarber.domain.models.CustomerRepository;
import com.luanelioliveira.gobarber.domain.usecases.CreateCustomer;
import com.luanelioliveira.gobarber.domain.usecases.requests.CreateCustomerRequest;
import com.luanelioliveira.gobarber.domain.usecases.responses.CreateCustomerResponse;
import com.luanelioliveira.gobarber.domain.valueobjects.exceptions.CustomerAlreadyExistsException;
import com.luanelioliveira.gobarber.infrastructure.events.EventPublisher;
import java.util.function.Consumer;
import javax.inject.Named;
import lombok.RequiredArgsConstructor;

@Named
@RequiredArgsConstructor
public class CreateCustomerHandler implements CreateCustomer {

  private final CustomerRepository repository;
  private final EventPublisher eventPublisher;

  @Override
  public void execute(CreateCustomerRequest request, Consumer<CreateCustomerResponse> consumer) {

    validate(request);

    var newCustomer = Customer.newCustomer(request.getName(), request.getEmail());

    var savedCustomer = repository.save(newCustomer);
    eventPublisher.publish(new CustomerCreatedEvent(savedCustomer));

    consumer.accept(new CreateCustomerResponse(savedCustomer));
  }

  private void validate(CreateCustomerRequest request) {
    if (repository.findByEmail(request.getEmail()).isPresent())
      throw new CustomerAlreadyExistsException();
  }
}
