package com.luanelioliveira.gobarber.domain.account.commands;

import com.luanelioliveira.gobarber.domain.base.Command;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class RegisterAccountCommand implements Command<RegisterAccountResult> {
  private String name;
  private String email;
}
