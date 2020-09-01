package com.luanelioliveira.gobarber.alloy.controllers.accounts.responses;

import com.luanelioliveira.gobarber.domain.account.queries.GetAccountDetailsResult;
import java.util.function.Consumer;
import lombok.Getter;

@Getter
public class GetAccountDetailsPresenter implements Consumer<GetAccountDetailsResult> {

  private GetAccountDetailsJsonResponse jsonResponse;

  @Override
  public void accept(GetAccountDetailsResult result) {
    jsonResponse = new GetAccountDetailsJsonResponse(result);
  }
}
