package com.luanelioliveira.gobarber.core.alloy.controllers.accounts.responses;

import com.luanelioliveira.gobarber.core.domain.account.commands.RegisterAccountResult;
import java.util.function.Consumer;
import lombok.Getter;

@Getter
public class RegisterAccountPresenter implements Consumer<RegisterAccountResult> {

  private RegisterAccountJsonResponse jsonResponse;

  @Override
  public void accept(RegisterAccountResult response) {
    jsonResponse = new RegisterAccountJsonResponse(response);
  }
}
