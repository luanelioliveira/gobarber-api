package com.luanelioliveira.gobarber.ui.rest.customer.request;

import lombok.Getter;

@Getter
public class CreateCustomerPayload {
  private String name;
  private String email;
}
