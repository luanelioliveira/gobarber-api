package com.luanelioliveira.gobarber.ui.rest.customer.mapper;

import com.luanelioliveira.gobarber.domain.usecase.request.GetCustomerByEmailRequest;
import lombok.experimental.UtilityClass;

@UtilityClass
public class GetCustomerByEmailMapper {

  public static GetCustomerByEmailRequest toRequest(String email) {
    return GetCustomerByEmailRequest.builder().email(email).build();
  }
}
