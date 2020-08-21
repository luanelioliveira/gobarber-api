package com.luanelioliveira.gobarber.ui.rest.customer;

import com.luanelioliveira.gobarber.application.customer.commands.CreateCustomerCommandHandler;
import com.luanelioliveira.gobarber.application.customer.queries.GetCustomerQueryHandler;
import com.luanelioliveira.gobarber.domain.entities.Customer;
import com.luanelioliveira.gobarber.ui.rest.customer.adapters.CreateCustomerAdapter;
import com.luanelioliveira.gobarber.ui.rest.customer.adapters.GetCustomerByEmailAdapter;
import com.luanelioliveira.gobarber.ui.rest.customer.adapters.GetCustomerByIdAdapter;
import com.luanelioliveira.gobarber.ui.rest.customer.requests.CreateCustomerRequest;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("customers")
@RequiredArgsConstructor
public class CustomerResource {

  private final CreateCustomerCommandHandler createHandler;
  private final GetCustomerQueryHandler queryHandler;

  @GetMapping("{id}")
  public Customer getCustomerById(@PathVariable UUID id) {
    return queryHandler.query(GetCustomerByIdAdapter.toQuery(id));
  }

  @GetMapping
  public Customer getCustomerByEmail(@RequestParam String email) {
    return queryHandler.query(GetCustomerByEmailAdapter.toQuery(email));
  }

  @PostMapping
  public Customer createNewCustomer(@RequestBody CreateCustomerRequest request) {
    return createHandler.execute(CreateCustomerAdapter.toCommand(request));
  }
}
