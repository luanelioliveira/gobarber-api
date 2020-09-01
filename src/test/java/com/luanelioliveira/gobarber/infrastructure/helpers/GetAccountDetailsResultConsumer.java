package com.luanelioliveira.gobarber.infrastructure.helpers;

import com.luanelioliveira.gobarber.domain.account.queries.GetAccountDetailsResult;
import java.util.function.Consumer;
import lombok.Getter;

@Getter
public class GetAccountDetailsResultConsumer implements Consumer<GetAccountDetailsResult> {

  private GetAccountDetailsResult result;

  @Override
  public void accept(GetAccountDetailsResult result) {
    this.result = result;
  }
}
