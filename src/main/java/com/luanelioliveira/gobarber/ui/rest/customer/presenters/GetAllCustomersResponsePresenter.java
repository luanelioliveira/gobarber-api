package com.luanelioliveira.gobarber.ui.rest.customer.presenters;

import com.luanelioliveira.gobarber.domain.usecases.responses.GetCustomerResponse;
import com.luanelioliveira.gobarber.ui.rest.customer.responses.GetCustomerJsonResponse;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import lombok.Getter;

@Getter
public class GetAllCustomersResponsePresenter implements Consumer<List<GetCustomerResponse>> {

  private List<GetCustomerJsonResponse> jsonResponse;

  @Override
  public void accept(List<GetCustomerResponse> response) {
    jsonResponse = response.stream().map(GetCustomerJsonResponse::new).collect(Collectors.toList());
  }
}
