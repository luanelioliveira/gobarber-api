package com.luanelioliveira.gobarber.core.domain.account.commands;

import com.luanelioliveira.gobarber.core.domain.base.Command;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class RegisterAccountCommand implements Command<RegisterAccountResult> {
  private String name;
  private String email;
}
