package com.luanelioliveira.gobarber.application.usecase;

import com.luanelioliveira.gobarber.application.exception.CustomerNotExistsException;
import com.luanelioliveira.gobarber.domain.entity.Customer;
import com.luanelioliveira.gobarber.domain.entity.CustomerRepository;
import com.luanelioliveira.gobarber.domain.usecase.GetCustomerByEmail;
import com.luanelioliveira.gobarber.domain.usecase.request.GetCustomerByEmailRequest;
import com.luanelioliveira.gobarber.domain.usecase.response.GetCustomerByEmailResponse;
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

    consumer.accept(
        GetCustomerByEmailResponse.builder()
            .id(customer.getId())
            .name(customer.getName())
            .email(customer.getEmail())
            .build());
  }
}
