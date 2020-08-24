package com.luanelioliveira.gobarber.customers.ui.rest.customer.request;

import lombok.Getter;

@Getter
public class CreateCustomerPayload {
  private String name;
  private String email;
}
