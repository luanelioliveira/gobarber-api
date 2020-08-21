package com.luanelioliveira.gobarber.application.customer.commands;

import com.luanelioliveira.gobarber.application.Command;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class CreateCustomerCommand extends Command {
  private String name;
  private String email;
}
