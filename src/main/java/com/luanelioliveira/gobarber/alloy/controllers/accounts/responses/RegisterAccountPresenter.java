package com.luanelioliveira.gobarber.alloy.controllers.accounts.responses;

import com.luanelioliveira.gobarber.domain.account.commands.RegisterAccountResult;
import java.util.function.Consumer;
import lombok.Getter;

@Getter
public class RegisterAccountPresenter implements Consumer<RegisterAccountResult> {

  private RegisterAccountJsonResponse jsonResponse;

  @Override
  public void accept(RegisterAccountResult result) {
    jsonResponse = new RegisterAccountJsonResponse(result);
  }
}
