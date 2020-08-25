package com.luanelioliveira.gobarber.domain.usecases.requests;

import java.util.UUID;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class DeleteCustomerRequest {
  private UUID id;
}
