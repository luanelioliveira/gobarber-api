package com.luanelioliveira.gobarber.ui.rest.customer.adapters;

import com.luanelioliveira.gobarber.application.customer.commands.CreateCustomerCommand;
import com.luanelioliveira.gobarber.ui.rest.customer.requests.CreateCustomerRequest;

public class CreateCustomerAdapter {

  public static CreateCustomerCommand toCommand(CreateCustomerRequest request) {
    return CreateCustomerCommand.builder()
        .name(request.getName())
        .email(request.getEmail())
        .build();
  }
}
