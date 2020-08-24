package com.luanelioliveira.gobarber.domain.usecase.request;

import java.util.UUID;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class GetCustomerByIdRequest {
  private UUID id;
}
