package com.luanelioliveira.gobarber.ui.rest.customer.requests;

import lombok.Getter;

@Getter
public class CreateCustomerRequest {
  private String name;
  private String email;
}
