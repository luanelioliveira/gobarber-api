package com.luanelioliveira.gobarber.ui.rest.customer.presenters;

import com.luanelioliveira.gobarber.domain.usecases.responses.CreateCustomerResponse;
import com.luanelioliveira.gobarber.ui.rest.customer.responses.CreateCustomerJsonResponse;
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
