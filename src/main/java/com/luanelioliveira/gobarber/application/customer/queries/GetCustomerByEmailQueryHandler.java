package com.luanelioliveira.gobarber.application.customer.queries;

import com.luanelioliveira.gobarber.domain.entities.Customer;
import com.luanelioliveira.gobarber.domain.entities.CustomerRepository;
import com.luanelioliveira.gobarber.domain.valueobjects.exceptions.CustomerNotFoundException;
import javax.inject.Named;

@Named
public class GetCustomerByEmailQueryHandler {

  private final CustomerRepository repository;

  public GetCustomerByEmailQueryHandler(CustomerRepository repository) {
    this.repository = repository;
  }

  public Customer execute(GetCustomerByEmailQuery query) {

    var email = query.getEmail();
    Customer customer =
        repository
            .findByEmail(email)
            .orElseThrow(
                () -> new CustomerNotFoundException("Customer not found for email " + email));

    return customer;
  }
}
