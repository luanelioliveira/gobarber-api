package com.luanelioliveira.gobarber.customers.ui.rest.customer.mapper;

import com.luanelioliveira.gobarber.customers.domain.usecase.request.GetCustomerByEmailRequest;
import lombok.experimental.UtilityClass;

@UtilityClass
public class GetCustomerByEmailMapper {

  public static GetCustomerByEmailRequest toRequest(String email) {
    return GetCustomerByEmailRequest.builder().email(email).build();
  }
}
