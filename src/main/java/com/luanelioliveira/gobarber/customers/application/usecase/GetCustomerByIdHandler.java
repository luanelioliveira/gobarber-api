package com.luanelioliveira.gobarber.customers.application.usecase;

import com.luanelioliveira.gobarber.customers.application.exception.CustomerNotExistsException;
import com.luanelioliveira.gobarber.customers.domain.entity.Customer;
import com.luanelioliveira.gobarber.customers.domain.entity.CustomerRepository;
import com.luanelioliveira.gobarber.customers.domain.usecase.GetCustomerById;
import com.luanelioliveira.gobarber.customers.domain.usecase.request.GetCustomerByIdRequest;
import com.luanelioliveira.gobarber.customers.domain.usecase.response.GetCustomerByIdResponse;
import java.util.function.Consumer;
import javax.inject.Named;

@Named
public class GetCustomerByIdHandler implements GetCustomerById {

  private final CustomerRepository repository;

  public GetCustomerByIdHandler(CustomerRepository repository) {
    this.repository = repository;
  }

  @Override
  public void execute(GetCustomerByIdRequest request, Consumer<GetCustomerByIdResponse> consumer) {

    var id = request.getId();
    final Customer customer = repository.findById(id).orElseThrow(CustomerNotExistsException::new);

    consumer.accept(new GetCustomerByIdResponse(customer));
  }
}
