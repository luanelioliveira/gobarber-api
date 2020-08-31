package com.luanelioliveira.gobarber.core.alloy.controllers.accounts;

import static org.springframework.http.HttpStatus.CREATED;

import com.luanelioliveira.gobarber.core.alloy.controllers.accounts.requests.RegisterAccountPayload;
import com.luanelioliveira.gobarber.core.alloy.controllers.accounts.responses.GetAccountDetailsJsonResponse;
import com.luanelioliveira.gobarber.core.alloy.controllers.accounts.responses.GetAccountDetailsPresenter;
import com.luanelioliveira.gobarber.core.alloy.controllers.accounts.responses.RegisterAccountJsonResponse;
import com.luanelioliveira.gobarber.core.alloy.controllers.accounts.responses.RegisterAccountPresenter;
import com.luanelioliveira.gobarber.core.domain.account.commands.RegisterAccount;
import com.luanelioliveira.gobarber.core.domain.account.queries.GetAccountDetails;
import com.luanelioliveira.gobarber.core.domain.account.queries.GetAccountDetailsQuery;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/accounts")
@RequiredArgsConstructor
public class AccountController {

  private final RegisterAccount registerAccount;
  private final GetAccountDetails getAccountDetails;

  @GetMapping("{accountId}")
  public GetAccountDetailsJsonResponse getAccountDetails(@PathVariable UUID accountId) {
    final var presenter = new GetAccountDetailsPresenter();

    getAccountDetails.handle(new GetAccountDetailsQuery(accountId), presenter);
    return presenter.getJsonResponse();
  }

  @ResponseStatus(CREATED)
  @PostMapping
  public RegisterAccountJsonResponse registerNewAccount(
      @RequestBody RegisterAccountPayload payload) {
    final var presenter = new RegisterAccountPresenter();

    registerAccount.handle(payload.toCommand(), presenter);
    return presenter.getJsonResponse();
  }
}
