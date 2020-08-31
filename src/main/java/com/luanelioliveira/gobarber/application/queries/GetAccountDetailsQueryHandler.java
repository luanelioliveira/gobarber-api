package com.luanelioliveira.gobarber.application.queries;

import com.luanelioliveira.gobarber.domain.account.Account;
import com.luanelioliveira.gobarber.domain.account.AccountRepository;
import com.luanelioliveira.gobarber.domain.account.queries.GetAccountDetails;
import com.luanelioliveira.gobarber.domain.account.queries.GetAccountDetailsQuery;
import com.luanelioliveira.gobarber.domain.account.queries.GetAccountDetailsResult;
import com.luanelioliveira.gobarber.domain.common.exceptions.EntityNotFoundException;
import java.util.function.Consumer;
import javax.inject.Named;
import lombok.RequiredArgsConstructor;

@Named
@RequiredArgsConstructor
public class GetAccountDetailsQueryHandler implements GetAccountDetails {

  private final AccountRepository repository;

  @Override
  public void handle(GetAccountDetailsQuery query, Consumer<GetAccountDetailsResult> result) {

    var id = query.getId();
    final Account account = repository.withId(id).orElseThrow(EntityNotFoundException::new);

    result.accept(new GetAccountDetailsResult(account));
  }
}
