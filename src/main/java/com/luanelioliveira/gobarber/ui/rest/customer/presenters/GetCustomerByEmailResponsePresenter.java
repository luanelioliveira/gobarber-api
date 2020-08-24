package com.luanelioliveira.gobarber.ui.rest.customer.presenters;

import com.luanelioliveira.gobarber.domain.usecases.responses.GetCustomerByEmailResponse;
import com.luanelioliveira.gobarber.ui.rest.customer.response.GetCustomerByEmailJsonResponse;
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
