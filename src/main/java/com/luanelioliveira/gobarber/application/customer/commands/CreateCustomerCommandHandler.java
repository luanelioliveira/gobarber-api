package com.luanelioliveira.gobarber.application.customer.commands;

import com.luanelioliveira.gobarber.application.CommandHandler;
import com.luanelioliveira.gobarber.application.customer.events.CustomerCreatedEvent;
import com.luanelioliveira.gobarber.domain.entities.Customer;
import com.luanelioliveira.gobarber.domain.entities.CustomerRepository;
import com.luanelioliveira.gobarber.domain.valueobjects.exceptions.CustomerAlreadyExistsException;
import javax.inject.Named;

@Named
public class CreateCustomerCommandHandler
    implements CommandHandler<CreateCustomerCommand, Customer> {

  private final CustomerRepository repository;

  public CreateCustomerCommandHandler(CustomerRepository repository) {
    this.repository = repository;
  }

  @Override
  public Customer execute(CreateCustomerCommand command) {
    var name = command.getName();
    var email = command.getEmail();
    var newCustomer = Customer.newCustomer(name, email);

    validate(newCustomer);

    newCustomer = repository.save(newCustomer);

    var event = new CustomerCreatedEvent(newCustomer);

    return newCustomer;
  }

  private void validate(Customer newCustomer) {
    var email = newCustomer.getEmail();

    repository
        .findByEmail(email)
        .map(Customer::getEmail)
        .ifPresent(
            existingEmail -> {
              throw new CustomerAlreadyExistsException(existingEmail);
            });
  }
}
