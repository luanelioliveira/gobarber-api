package com.luanelioliveira.gobarber.domain.account.commands;

import com.luanelioliveira.gobarber.domain.base.Command;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor(staticName = "of")
public class RegisterAccountCommand implements Command<RegisterAccountResult> {
  private final String name;
  private final String email;
}
