package com.luanelioliveira.gobarber.customers.application.usecase;

import com.luanelioliveira.gobarber.customers.application.event.publish.CustomerCreatedEventPublisher;
import com.luanelioliveira.gobarber.customers.application.exception.CustomerAlreadyExistsException;
import com.luanelioliveira.gobarber.customers.application.exception.EmailEmptyException;
import com.luanelioliveira.gobarber.customers.application.exception.NameEmptyException;
import com.luanelioliveira.gobarber.customers.domain.entity.Customer;
import com.luanelioliveira.gobarber.customers.domain.entity.CustomerRepository;
import com.luanelioliveira.gobarber.customers.domain.usecase.CreateCustomer;
import com.luanelioliveira.gobarber.customers.domain.usecase.request.CreateCustomerRequest;
import com.luanelioliveira.gobarber.customers.domain.usecase.response.CreateCustomerResponse;
import java.util.function.Consumer;
import javax.inject.Named;
import lombok.RequiredArgsConstructor;

@Named
@RequiredArgsConstructor
public class CreateCustomerHandler implements CreateCustomer {

  private final CustomerRepository repository;
  private final CustomerCreatedEventPublisher event;

  @Override
  public void execute(CreateCustomerRequest request, Consumer<CreateCustomerResponse> consumer) {

    validate(request);

    var newCustomer = Customer.newCustomer(request.getName(), request.getEmail());

    var savedCustomer = repository.save(newCustomer);
    event.publish(savedCustomer);

    consumer.accept(new CreateCustomerResponse(savedCustomer));
  }

  private void validate(CreateCustomerRequest request) {
    if (request.getName() == null || request.getName().trim().isEmpty())
      throw new NameEmptyException();

    if (request.getEmail() == null || request.getEmail().trim().isEmpty())
      throw new EmailEmptyException();

    if (repository.findByEmail(request.getEmail()).isPresent())
      throw new CustomerAlreadyExistsException();
  }
}
