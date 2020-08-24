package com.luanelioliveira.gobarber.ui.rest.customer.adapters;

import com.luanelioliveira.gobarber.domain.usecases.requests.GetCustomerByEmailRequest;

public class GetCustomerByEmailAdapter {

  public static GetCustomerByEmailRequest toQuery(String email) {
    return GetCustomerByEmailRequest.builder().email(email).build();
  }
}
