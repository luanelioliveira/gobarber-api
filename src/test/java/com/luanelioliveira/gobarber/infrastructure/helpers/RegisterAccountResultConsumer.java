package com.luanelioliveira.gobarber.infrastructure.helpers;

import com.luanelioliveira.gobarber.domain.account.commands.RegisterAccountResult;
import java.util.function.Consumer;
import lombok.Getter;

@Getter
public class RegisterAccountResultConsumer implements Consumer<RegisterAccountResult> {

  private RegisterAccountResult result;

  @Override
  public void accept(RegisterAccountResult result) {
    this.result = result;
  }
}
