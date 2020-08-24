package com.luanelioliveira.gobarber.application.usecases;

import com.luanelioliveira.gobarber.domain.models.Customer;
import com.luanelioliveira.gobarber.domain.models.CustomerRepository;
import com.luanelioliveira.gobarber.domain.usecases.GetCustomerByEmail;
import com.luanelioliveira.gobarber.domain.usecases.requests.GetCustomerByEmailRequest;
import com.luanelioliveira.gobarber.domain.usecases.responses.GetCustomerByEmailResponse;
import com.luanelioliveira.gobarber.domain.valueobjects.exceptions.CustomerNotExistsException;
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
