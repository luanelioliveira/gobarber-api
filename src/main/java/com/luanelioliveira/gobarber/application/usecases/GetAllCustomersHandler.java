package com.luanelioliveira.gobarber.application.usecases;

import com.luanelioliveira.gobarber.domain.models.Customer;
import com.luanelioliveira.gobarber.domain.models.CustomerRepository;
import com.luanelioliveira.gobarber.domain.usecases.GetAllCustomers;
import com.luanelioliveira.gobarber.domain.usecases.requests.GetAllCustomersRequest;
import com.luanelioliveira.gobarber.domain.usecases.responses.GetCustomerResponse;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import javax.inject.Named;

@Named
public class GetAllCustomersHandler implements GetAllCustomers {

  private final CustomerRepository repository;

  public GetAllCustomersHandler(CustomerRepository repository) {
    this.repository = repository;
  }

  @Override
  public void execute(
      GetAllCustomersRequest request, Consumer<List<GetCustomerResponse>> consumer) {

    final List<Customer> customers = repository.findAll();

    consumer.accept(customers.stream().map(GetCustomerResponse::new).collect(Collectors.toList()));
  }
}
