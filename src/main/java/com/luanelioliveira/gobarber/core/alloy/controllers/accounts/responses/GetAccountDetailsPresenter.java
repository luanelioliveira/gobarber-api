package com.luanelioliveira.gobarber.core.alloy.controllers.accounts.responses;

import com.luanelioliveira.gobarber.core.domain.account.queries.GetAccountDetailsResult;
import java.util.function.Consumer;
import lombok.Getter;

@Getter
public class GetAccountDetailsPresenter implements Consumer<GetAccountDetailsResult> {

  private GetAccountDetailsJsonResponse jsonResponse;

  @Override
  public void accept(GetAccountDetailsResult response) {
    jsonResponse = new GetAccountDetailsJsonResponse(response);
  }
}
