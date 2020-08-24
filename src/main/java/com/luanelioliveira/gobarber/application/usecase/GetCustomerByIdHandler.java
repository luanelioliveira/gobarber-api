package com.luanelioliveira.gobarber.application.usecase;

import com.luanelioliveira.gobarber.application.exception.CustomerNotExistsException;
import com.luanelioliveira.gobarber.domain.entity.Customer;
import com.luanelioliveira.gobarber.domain.entity.CustomerRepository;
import com.luanelioliveira.gobarber.domain.usecase.GetCustomerById;
import com.luanelioliveira.gobarber.domain.usecase.request.GetCustomerByIdRequest;
import com.luanelioliveira.gobarber.domain.usecase.response.GetCustomerByIdResponse;
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

    consumer.accept(
        GetCustomerByIdResponse.builder()
            .id(customer.getId())
            .name(customer.getName())
            .email(customer.getEmail())
            .build());
  }
}
