package com.luanelioliveira.gobarber.ui.rest.customer;

import com.luanelioliveira.gobarber.domain.usecase.CreateCustomer;
import com.luanelioliveira.gobarber.domain.usecase.GetCustomerByEmail;
import com.luanelioliveira.gobarber.domain.usecase.GetCustomerById;
import com.luanelioliveira.gobarber.domain.usecase.request.GetCustomerByEmailRequest;
import com.luanelioliveira.gobarber.domain.usecase.request.GetCustomerByIdRequest;
import com.luanelioliveira.gobarber.ui.rest.customer.mapper.CreateCustomerMapper;
import com.luanelioliveira.gobarber.ui.rest.customer.mapper.GetCustomerByEmailMapper;
import com.luanelioliveira.gobarber.ui.rest.customer.mapper.GetCustomerByIdMapper;
import com.luanelioliveira.gobarber.ui.rest.customer.presenter.CreateCustomerResponsePresenter;
import com.luanelioliveira.gobarber.ui.rest.customer.presenter.GetCustomerByEmailResponsePresenter;
import com.luanelioliveira.gobarber.ui.rest.customer.presenter.GetCustomerByIdResponsePresenter;
import com.luanelioliveira.gobarber.ui.rest.customer.request.CreateCustomerPayload;
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
    final var request = GetCustomerByIdMapper.toRequest(id);
    final var presenter = new GetCustomerByIdResponsePresenter();

    getCustomerById.execute(request, presenter);
    return presenter.getJsonResponse();
  }

  @GetMapping
  public GetCustomerByEmailJsonResponse getCustomerByEmail(@RequestParam String email) {
    final var request = GetCustomerByEmailMapper.toRequest(email);
    final var presenter = new GetCustomerByEmailResponsePresenter();

    getCustomerByEmail.execute(request, presenter);
    return presenter.getJsonResponse();
  }

  @PostMapping
  public CreateCustomerJsonResponse createNewCustomer(@RequestBody CreateCustomerPayload payload) {
    final var request = CreateCustomerMapper.toRequest(payload);
    final var presenter = new CreateCustomerResponsePresenter();

    createHandler.execute(request, presenter);
    return presenter.getJsonResponse();
  }
}
