package com.luanelioliveira.gobarber.application.customer.queries;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class GetCustomerByEmailQuery {
  private String email;
}
