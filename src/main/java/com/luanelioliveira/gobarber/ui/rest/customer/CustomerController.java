package com.luanelioliveira.gobarber.ui.rest.customer;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.NO_CONTENT;

import com.luanelioliveira.gobarber.domain.usecases.CreateCustomer;
import com.luanelioliveira.gobarber.domain.usecases.DeleteCustomer;
import com.luanelioliveira.gobarber.domain.usecases.GetAllCustomers;
import com.luanelioliveira.gobarber.domain.usecases.GetCustomerByEmail;
import com.luanelioliveira.gobarber.domain.usecases.GetCustomerById;
import com.luanelioliveira.gobarber.domain.usecases.requests.GetAllCustomersRequest;
import com.luanelioliveira.gobarber.ui.rest.customer.mappers.CreateCustomerMapper;
import com.luanelioliveira.gobarber.ui.rest.customer.mappers.DeleteCustomerMapper;
import com.luanelioliveira.gobarber.ui.rest.customer.mappers.GetCustomerByEmailMapper;
import com.luanelioliveira.gobarber.ui.rest.customer.mappers.GetCustomerByIdMapper;
import com.luanelioliveira.gobarber.ui.rest.customer.presenters.CreateCustomerResponsePresenter;
import com.luanelioliveira.gobarber.ui.rest.customer.presenters.GetAllCustomersResponsePresenter;
import com.luanelioliveira.gobarber.ui.rest.customer.presenters.GetCustomerByEmailResponsePresenter;
import com.luanelioliveira.gobarber.ui.rest.customer.presenters.GetCustomerByIdResponsePresenter;
import com.luanelioliveira.gobarber.ui.rest.customer.requests.CreateCustomerPayload;
import com.luanelioliveira.gobarber.ui.rest.customer.responses.CreateCustomerJsonResponse;
import com.luanelioliveira.gobarber.ui.rest.customer.responses.GetCustomerByEmailJsonResponse;
import com.luanelioliveira.gobarber.ui.rest.customer.responses.GetCustomerByIdJsonResponse;
import com.luanelioliveira.gobarber.ui.rest.customer.responses.GetCustomerJsonResponse;
import java.util.List;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("customers")
@RequiredArgsConstructor
public class CustomerController {

  private final CreateCustomer createCustomer;
  private final DeleteCustomer deleteCustomer;
  private final GetCustomerById getCustomerById;
  private final GetCustomerByEmail getCustomerByEmail;
  private final GetAllCustomers getAllCustomers;

  @GetMapping("{id}")
  public GetCustomerByIdJsonResponse getCustomerById(@PathVariable UUID id) {
    final var request = GetCustomerByIdMapper.toRequest(id);
    final var presenter = new GetCustomerByIdResponsePresenter();

    getCustomerById.execute(request, presenter);
    return presenter.getJsonResponse();
  }

  @GetMapping("search")
  public GetCustomerByEmailJsonResponse getCustomerByEmail(@RequestParam String email) {
    final var request = GetCustomerByEmailMapper.toRequest(email);
    final var presenter = new GetCustomerByEmailResponsePresenter();

    getCustomerByEmail.execute(request, presenter);
    return presenter.getJsonResponse();
  }

  @GetMapping
  public List<GetCustomerJsonResponse> getAllCustomers() {
    final var request = new GetAllCustomersRequest();
    final var presenter = new GetAllCustomersResponsePresenter();

    getAllCustomers.execute(request, presenter);
    return presenter.getJsonResponse();
  }

  @ResponseStatus(NO_CONTENT)
  @DeleteMapping("{id}")
  public void deleteCustomerById(@PathVariable UUID id) {
    final var request = DeleteCustomerMapper.toRequest(id);
    deleteCustomer.execute(request, null);
  }

  @ResponseStatus(CREATED)
  @PostMapping
  public CreateCustomerJsonResponse createNewCustomer(@RequestBody CreateCustomerPayload payload) {
    final var request = CreateCustomerMapper.toRequest(payload);
    final var presenter = new CreateCustomerResponsePresenter();

    createCustomer.execute(request, presenter);
    return presenter.getJsonResponse();
  }
}
