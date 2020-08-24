package com.luanelioliveira.gobarber.domain.usecase.request;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class GetCustomerByEmailRequest {
  private String email;
}
