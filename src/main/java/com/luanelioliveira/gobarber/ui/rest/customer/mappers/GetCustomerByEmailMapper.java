package com.luanelioliveira.gobarber.ui.rest.customer.mappers;

import com.luanelioliveira.gobarber.domain.usecases.requests.GetCustomerByEmailRequest;
import lombok.experimental.UtilityClass;

@UtilityClass
public class GetCustomerByEmailMapper {

  public static GetCustomerByEmailRequest toRequest(String email) {
    return GetCustomerByEmailRequest.builder().email(email).build();
  }
}
