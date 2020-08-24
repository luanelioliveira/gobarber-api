package com.luanelioliveira.gobarber.application.usecases;

import com.luanelioliveira.gobarber.domain.models.Customer;
import com.luanelioliveira.gobarber.domain.models.CustomerRepository;
import com.luanelioliveira.gobarber.domain.usecases.GetCustomerById;
import com.luanelioliveira.gobarber.domain.usecases.requests.GetCustomerByIdRequest;
import com.luanelioliveira.gobarber.domain.usecases.responses.GetCustomerByIdResponse;
import com.luanelioliveira.gobarber.domain.valueobjects.exceptions.CustomerNotExistsException;
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
