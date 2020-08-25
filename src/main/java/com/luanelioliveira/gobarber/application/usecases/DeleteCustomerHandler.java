package com.luanelioliveira.gobarber.application.usecases;

import com.luanelioliveira.gobarber.application.usecases.events.produces.CustomerDeletedEventPublisher;
import com.luanelioliveira.gobarber.domain.models.Customer;
import com.luanelioliveira.gobarber.domain.models.CustomerRepository;
import com.luanelioliveira.gobarber.domain.usecases.DeleteCustomer;
import com.luanelioliveira.gobarber.domain.usecases.requests.DeleteCustomerRequest;
import com.luanelioliveira.gobarber.domain.valueobjects.exceptions.CustomerNotExistsException;
import java.util.function.Consumer;
import javax.inject.Named;
import lombok.RequiredArgsConstructor;

@Named
@RequiredArgsConstructor
public class DeleteCustomerHandler implements DeleteCustomer {

  private final CustomerRepository repository;
  private final CustomerDeletedEventPublisher event;

  @Override
  public void execute(DeleteCustomerRequest request, Consumer<Void> consumer) {

    var id = request.getId();
    final Customer customer = repository.findById(id).orElseThrow(CustomerNotExistsException::new);

    repository.deleteById(customer.getId());
    event.publish(customer);
  }
}
