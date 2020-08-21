package com.luanelioliveira.gobarber.application.customer.queries;

import com.luanelioliveira.gobarber.domain.entities.Customer;
import com.luanelioliveira.gobarber.domain.entities.CustomerRepository;
import com.luanelioliveira.gobarber.domain.valueobjects.exceptions.CustomerNotFoundException;
import javax.inject.Named;

@Named
public class GetCustomerQueryHandler {

  private final CustomerRepository repository;

  public GetCustomerQueryHandler(CustomerRepository repository) {
    this.repository = repository;
  }

  public Customer query(GetCustomerByIdQuery query) {

    var id = query.getId();
    Customer customer =
        repository
            .findById(id)
            .orElseThrow(() -> new CustomerNotFoundException("Customer not found for id " + id));

    return customer;
  }

  public Customer query(GetCustomerByEmailQuery query) {

    var email = query.getEmail();
    Customer customer =
        repository
            .findByEmail(email)
            .orElseThrow(
                () -> new CustomerNotFoundException("Customer not found for email " + email));

    return customer;
  }
}
