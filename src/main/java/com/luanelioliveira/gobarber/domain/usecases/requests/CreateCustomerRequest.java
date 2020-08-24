package com.luanelioliveira.gobarber.domain.usecases.requests;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class CreateCustomerRequest {
  private String name;
  private String email;
}
