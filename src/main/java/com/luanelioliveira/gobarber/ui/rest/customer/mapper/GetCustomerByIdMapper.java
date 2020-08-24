package com.luanelioliveira.gobarber.ui.rest.customer.mapper;

import com.luanelioliveira.gobarber.domain.usecase.request.GetCustomerByIdRequest;
import java.util.UUID;
import lombok.experimental.UtilityClass;

@UtilityClass
public class GetCustomerByIdMapper {

  public static GetCustomerByIdRequest toRequest(UUID id) {
    return GetCustomerByIdRequest.builder().id(id).build();
  }
}
