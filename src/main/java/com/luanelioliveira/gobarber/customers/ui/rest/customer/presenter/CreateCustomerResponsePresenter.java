package com.luanelioliveira.gobarber.customers.ui.rest.customer.presenter;

import com.luanelioliveira.gobarber.customers.domain.usecase.response.CreateCustomerResponse;
import com.luanelioliveira.gobarber.customers.ui.rest.customer.response.CreateCustomerJsonResponse;
import java.util.function.Consumer;
import lombok.Getter;

@Getter
public class CreateCustomerResponsePresenter implements Consumer<CreateCustomerResponse> {

  private CreateCustomerJsonResponse jsonResponse;

  @Override
  public void accept(CreateCustomerResponse response) {
    jsonResponse = new CreateCustomerJsonResponse(response);
  }
}
