package com.luanelioliveira.gobarber.domain.usecase.response;

import java.util.UUID;
import lombok.Builder;
import lombok.Value;

@Builder(toBuilder = true)
@Value
public class GetCustomerByEmailResponse {
  private final UUID id;
  private final String name;
  private final String email;
}
