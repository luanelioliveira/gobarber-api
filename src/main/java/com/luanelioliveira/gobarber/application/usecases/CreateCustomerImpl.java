package com.luanelioliveira.gobarber.application.usecases;

import com.luanelioliveira.gobarber.application.events.CustomerCreatedEvent;
import com.luanelioliveira.gobarber.domain.entities.Customer;
import com.luanelioliveira.gobarber.domain.entities.CustomerRepository;
import com.luanelioliveira.gobarber.domain.usecases.CreateCustomer;
import com.luanelioliveira.gobarber.domain.usecases.requests.CreateCustomerRequest;
import com.luanelioliveira.gobarber.domain.usecases.responses.CreateCustomerResponse;
import com.luanelioliveira.gobarber.application.exceptions.CustomerAlreadyExistsException;
import java.util.function.Consumer;
import javax.inject.Named;

@Named
public class CreateCustomerImpl implements CreateCustomer {

  private final CustomerRepository repository;

  public CreateCustomerImpl(CustomerRepository repository) {
    this.repository = repository;
  }

  @Override
  public void execute(CreateCustomerRequest request, Consumer<CreateCustomerResponse> consumer) {
    var newCustomer = Customer.newCustomer(request.getName(), request.getEmail());

    validate(newCustomer);

    newCustomer = repository.save(newCustomer);

    var event = new CustomerCreatedEvent(newCustomer);

    consumer.accept(
        CreateCustomerResponse.builder()
            .id(newCustomer.getId())
            .name(newCustomer.getName())
            .email(newCustomer.getEmail())
            .build());
  }

  private void validate(Customer customer) {
    var email = customer.getEmail();

    repository
        .findByEmail(email)
        .map(Customer::getEmail)
        .ifPresent(
            existingEmail -> {
              throw new CustomerAlreadyExistsException(existingEmail);
            });
  }
}
