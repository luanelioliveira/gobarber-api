package com.luanelioliveira.gobarber.ui.rest.customer.mappers;

import com.luanelioliveira.gobarber.domain.usecases.requests.GetCustomerByIdRequest;
import java.util.UUID;
import lombok.experimental.UtilityClass;

@UtilityClass
public class GetCustomerByIdMapper {

  public static GetCustomerByIdRequest toRequest(UUID id) {
    return GetCustomerByIdRequest.builder().id(id).build();
  }
}
