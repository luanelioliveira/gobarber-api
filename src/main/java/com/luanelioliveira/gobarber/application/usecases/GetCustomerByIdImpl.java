package com.luanelioliveira.gobarber.application.usecases;

import com.luanelioliveira.gobarber.domain.entities.Customer;
import com.luanelioliveira.gobarber.domain.entities.CustomerRepository;
import com.luanelioliveira.gobarber.domain.usecases.GetCustomerById;
import com.luanelioliveira.gobarber.domain.usecases.requests.GetCustomerByIdRequest;
import com.luanelioliveira.gobarber.domain.usecases.responses.GetCustomerByIdResponse;
import com.luanelioliveira.gobarber.application.exceptions.CustomerNotFoundException;
import java.util.function.Consumer;
import javax.inject.Named;

@Named
public class GetCustomerByIdImpl implements GetCustomerById {

  private final CustomerRepository repository;

  public GetCustomerByIdImpl(CustomerRepository repository) {
    this.repository = repository;
  }

  @Override
  public void execute(GetCustomerByIdRequest request, Consumer<GetCustomerByIdResponse> consumer) {

    var id = request.getId();
    Customer customer =
        repository
            .findById(id)
            .orElseThrow(() -> new CustomerNotFoundException("Customer not found for id " + id));

    consumer.accept(
        GetCustomerByIdResponse.builder()
            .id(customer.getId())
            .name(customer.getName())
            .email(customer.getEmail())
            .build());
  }
}
