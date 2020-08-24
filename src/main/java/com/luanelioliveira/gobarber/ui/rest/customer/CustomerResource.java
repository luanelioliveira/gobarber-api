package com.luanelioliveira.gobarber.ui.rest.customer;

import com.luanelioliveira.gobarber.domain.usecases.CreateCustomer;
import com.luanelioliveira.gobarber.domain.usecases.GetCustomerByEmail;
import com.luanelioliveira.gobarber.domain.usecases.GetCustomerById;
import com.luanelioliveira.gobarber.ui.rest.customer.adapters.CreateCustomerAdapter;
import com.luanelioliveira.gobarber.ui.rest.customer.adapters.GetCustomerByEmailAdapter;
import com.luanelioliveira.gobarber.ui.rest.customer.adapters.GetCustomerByIdAdapter;
import com.luanelioliveira.gobarber.ui.rest.customer.presenters.CreateCustomerResponsePresenter;
import com.luanelioliveira.gobarber.ui.rest.customer.presenters.GetCustomerByEmailResponsePresenter;
import com.luanelioliveira.gobarber.ui.rest.customer.presenters.GetCustomerByIdResponsePresenter;
import com.luanelioliveira.gobarber.ui.rest.customer.requests.CreateCustomerPayload;
import com.luanelioliveira.gobarber.ui.rest.customer.response.CreateCustomerJsonResponse;
import com.luanelioliveira.gobarber.ui.rest.customer.response.GetCustomerByEmailJsonResponse;
import com.luanelioliveira.gobarber.ui.rest.customer.response.GetCustomerByIdJsonResponse;
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

  private final CreateCustomer createHandler;
  private final GetCustomerById getCustomerById;
  private final GetCustomerByEmail getCustomerByEmail;

  @GetMapping("{id}")
  public GetCustomerByIdJsonResponse getCustomerById(@PathVariable UUID id) {
    final GetCustomerByIdResponsePresenter presenter = new GetCustomerByIdResponsePresenter();
    getCustomerById.execute(GetCustomerByIdAdapter.toQuery(id), presenter);
    return presenter.getJsonResponse();
  }

  @GetMapping
  public GetCustomerByEmailJsonResponse getCustomerByEmail(@RequestParam String email) {
    final GetCustomerByEmailResponsePresenter presenter = new GetCustomerByEmailResponsePresenter();
    getCustomerByEmail.execute(GetCustomerByEmailAdapter.toQuery(email), presenter);
    return presenter.getJsonResponse();
  }

  @PostMapping
  public CreateCustomerJsonResponse createNewCustomer(@RequestBody CreateCustomerPayload payload) {
    final CreateCustomerResponsePresenter presenter = new CreateCustomerResponsePresenter();
    createHandler.execute(CreateCustomerAdapter.toRequest(payload), presenter);
    return presenter.getJsonResponse();
  }
}
