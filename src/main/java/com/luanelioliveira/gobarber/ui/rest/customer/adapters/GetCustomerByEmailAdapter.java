package com.luanelioliveira.gobarber.ui.rest.customer.adapters;

import com.luanelioliveira.gobarber.application.customer.queries.GetCustomerByEmailQuery;

public class GetCustomerByEmailAdapter {

  public static GetCustomerByEmailQuery toQuery(String email) {
    return GetCustomerByEmailQuery.builder().email(email).build();
  }
}
