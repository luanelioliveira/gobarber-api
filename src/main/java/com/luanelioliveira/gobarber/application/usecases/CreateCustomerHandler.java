package com.luanelioliveira.gobarber.application.usecases;

import com.luanelioliveira.gobarber.application.usecases.events.produces.CustomerCreatedEventPublisher;
import com.luanelioliveira.gobarber.domain.models.Customer;
import com.luanelioliveira.gobarber.domain.models.CustomerRepository;
import com.luanelioliveira.gobarber.domain.usecases.CreateCustomer;
import com.luanelioliveira.gobarber.domain.usecases.requests.CreateCustomerRequest;
import com.luanelioliveira.gobarber.domain.usecases.responses.CreateCustomerResponse;
import com.luanelioliveira.gobarber.domain.valueobjects.exceptions.CustomerAlreadyExistsException;
import com.luanelioliveira.gobarber.domain.valueobjects.exceptions.EmailEmptyException;
import com.luanelioliveira.gobarber.domain.valueobjects.exceptions.NameEmptyException;
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
