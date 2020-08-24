package com.luanelioliveira.gobarber.ui.rest.customer.adapters;

import com.luanelioliveira.gobarber.domain.usecases.requests.GetCustomerByIdRequest;
import java.util.UUID;

public class GetCustomerByIdAdapter {

  public static GetCustomerByIdRequest toQuery(UUID id) {
    return GetCustomerByIdRequest.builder().id(id).build();
  }
}
