package com.luanelioliveira.gobarber.customers.application.usecase;

import com.luanelioliveira.gobarber.customers.application.exception.CustomerNotExistsException;
import com.luanelioliveira.gobarber.customers.domain.entity.Customer;
import com.luanelioliveira.gobarber.customers.domain.entity.CustomerRepository;
import com.luanelioliveira.gobarber.customers.domain.usecase.GetCustomerByEmail;
import com.luanelioliveira.gobarber.customers.domain.usecase.request.GetCustomerByEmailRequest;
import com.luanelioliveira.gobarber.customers.domain.usecase.response.GetCustomerByEmailResponse;
import java.util.function.Consumer;
import javax.inject.Named;

@Named
public class GetCustomerByEmailHandler implements GetCustomerByEmail {

  private final CustomerRepository repository;

  public GetCustomerByEmailHandler(CustomerRepository repository) {
    this.repository = repository;
  }

  @Override
  public void execute(
      GetCustomerByEmailRequest request, Consumer<GetCustomerByEmailResponse> consumer) {

    var email = request.getEmail();
    final Customer customer =
        repository.findByEmail(email).orElseThrow(CustomerNotExistsException::new);

    consumer.accept(new GetCustomerByEmailResponse(customer));
  }
}
