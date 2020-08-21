package com.luanelioliveira.gobarber.application.customer.queries;

import java.util.UUID;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class GetCustomerByIdQuery {
  private UUID id;
}
