package com.luanelioliveira.gobarber.application.usecases;

import com.luanelioliveira.gobarber.domain.entities.Customer;
import com.luanelioliveira.gobarber.domain.entities.CustomerRepository;
import com.luanelioliveira.gobarber.domain.usecases.GetCustomerByEmail;
import com.luanelioliveira.gobarber.domain.usecases.requests.GetCustomerByEmailRequest;
import com.luanelioliveira.gobarber.domain.usecases.responses.GetCustomerByEmailResponse;
import com.luanelioliveira.gobarber.application.exceptions.CustomerNotFoundException;
import java.util.function.Consumer;
import javax.inject.Named;

@Named
public class GetCustomerByEmailImpl implements GetCustomerByEmail {

  private final CustomerRepository repository;

  public GetCustomerByEmailImpl(CustomerRepository repository) {
    this.repository = repository;
  }

  @Override
  public void execute(
      GetCustomerByEmailRequest request, Consumer<GetCustomerByEmailResponse> consumer) {

    var email = request.getEmail();
    Customer customer =
        repository
            .findByEmail(email)
            .orElseThrow(
                () -> new CustomerNotFoundException("Customer not found for email " + email));

    consumer.accept(
        GetCustomerByEmailResponse.builder()
            .id(customer.getId())
            .name(customer.getName())
            .email(customer.getEmail())
            .build());
  }
}
