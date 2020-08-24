package com.luanelioliveira.gobarber.customers.ui.rest.customer.presenter;

import com.luanelioliveira.gobarber.customers.domain.usecase.response.GetCustomerByIdResponse;
import com.luanelioliveira.gobarber.customers.ui.rest.customer.response.GetCustomerByIdJsonResponse;
import java.util.function.Consumer;
import lombok.Getter;

@Getter
public class GetCustomerByIdResponsePresenter implements Consumer<GetCustomerByIdResponse> {

  private GetCustomerByIdJsonResponse jsonResponse;

  @Override
  public void accept(GetCustomerByIdResponse response) {
    jsonResponse = new GetCustomerByIdJsonResponse(response);
  }
}
