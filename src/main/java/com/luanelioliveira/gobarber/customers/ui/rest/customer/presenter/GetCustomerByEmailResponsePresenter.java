package com.luanelioliveira.gobarber.customers.ui.rest.customer.presenter;

import com.luanelioliveira.gobarber.customers.domain.usecase.response.GetCustomerByEmailResponse;
import com.luanelioliveira.gobarber.customers.ui.rest.customer.response.GetCustomerByEmailJsonResponse;
import java.util.function.Consumer;
import lombok.Getter;

@Getter
public class GetCustomerByEmailResponsePresenter implements Consumer<GetCustomerByEmailResponse> {

  private GetCustomerByEmailJsonResponse jsonResponse;

  @Override
  public void accept(GetCustomerByEmailResponse response) {
    jsonResponse = new GetCustomerByEmailJsonResponse(response);
  }
}
