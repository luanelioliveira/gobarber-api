package com.luanelioliveira.gobarber.ui.rest.customer.requests;

import lombok.Getter;

@Getter
public class CreateCustomerPayload {
  private String name;
  private String email;
}
