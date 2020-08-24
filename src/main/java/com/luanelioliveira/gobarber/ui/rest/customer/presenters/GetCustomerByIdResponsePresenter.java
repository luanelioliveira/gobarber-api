package com.luanelioliveira.gobarber.ui.rest.customer.presenters;

import com.luanelioliveira.gobarber.domain.usecases.responses.GetCustomerByIdResponse;
import com.luanelioliveira.gobarber.ui.rest.customer.response.GetCustomerByIdJsonResponse;
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
