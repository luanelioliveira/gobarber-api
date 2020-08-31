package com.luanelioliveira.gobarber.application.commands;

import com.luanelioliveira.gobarber.domain.account.Account;
import com.luanelioliveira.gobarber.domain.account.AccountRepository;
import com.luanelioliveira.gobarber.domain.account.commands.RegisterAccount;
import com.luanelioliveira.gobarber.domain.account.commands.RegisterAccountCommand;
import com.luanelioliveira.gobarber.domain.account.commands.RegisterAccountResult;
import com.luanelioliveira.gobarber.domain.common.Email;
import com.luanelioliveira.gobarber.domain.common.exceptions.BusinessException;
import java.util.function.Consumer;
import javax.inject.Named;
import lombok.RequiredArgsConstructor;

@Named
@RequiredArgsConstructor
public class RegisterAccountCommandHandler implements RegisterAccount {

  private final AccountRepository repository;

  @Override
  public void handle(RegisterAccountCommand command, Consumer<RegisterAccountResult> result) {

    validate(command);

    var newAccount = Account.newAccount(command.getName(), command.getEmail());
    repository.add(newAccount);

    result.accept(new RegisterAccountResult(newAccount));
  }

  private void validate(RegisterAccountCommand command) {
    var email = new Email(command.getEmail());

    if (repository.withEmail(email).isPresent())
      throw new BusinessException("Account already exists");
  }
}
