package com.luanelioliveira.gobarber.ui.rest.customer.adapters;

import com.luanelioliveira.gobarber.application.customer.queries.GetCustomerByIdQuery;
import java.util.UUID;

public class GetCustomerByIdAdapter {

  public static GetCustomerByIdQuery toQuery(UUID id) {
    return GetCustomerByIdQuery.builder().id(id).build();
  }
}
