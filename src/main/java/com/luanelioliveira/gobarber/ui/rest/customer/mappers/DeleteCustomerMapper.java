package com.luanelioliveira.gobarber.ui.rest.customer.mappers;

import com.luanelioliveira.gobarber.domain.usecases.requests.DeleteCustomerRequest;
import com.luanelioliveira.gobarber.domain.usecases.requests.GetCustomerByIdRequest;
import java.util.UUID;
import lombok.experimental.UtilityClass;

@UtilityClass
public class DeleteCustomerMapper {

  public static DeleteCustomerRequest toRequest(UUID id) {
    return DeleteCustomerRequest.builder().id(id).build();
  }
}
