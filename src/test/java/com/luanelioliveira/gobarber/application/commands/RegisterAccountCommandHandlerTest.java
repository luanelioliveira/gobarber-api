package com.luanelioliveira.gobarber.application.commands;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.luanelioliveira.gobarber.alloy.controllers.accounts.responses.RegisterAccountPresenter;
import com.luanelioliveira.gobarber.domain.account.Account;
import com.luanelioliveira.gobarber.domain.account.AccountRepository;
import com.luanelioliveira.gobarber.domain.account.commands.RegisterAccountCommand;
import com.luanelioliveira.gobarber.domain.common.exceptions.BusinessException;
import com.luanelioliveira.gobarber.infrastructure.config.TemplateTestHelper;
import java.util.Optional;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class RegisterAccountCommandHandlerTest {

  private static final Account ACCOUNT_EXISTING = TemplateTestHelper.getAccount();
  private static final String ACCOUNT_NAME = "Isabel Heloisa Marlene Teixeira";
  private static final String ACCOUNT_EMAIL = "isabelheloisa@test.com.br";

  @Mock private AccountRepository accountRepository;
  @Captor private ArgumentCaptor<Account> accountCaptor;

  @InjectMocks private RegisterAccountCommandHandler registerAccountCommand;

  @Test
  public void shouldReturnAccountWhenRegisterAccount() {
    var command = RegisterAccountCommand.of(ACCOUNT_NAME, ACCOUNT_EMAIL);
    var result = new RegisterAccountPresenter();

    registerAccountCommand.handle(command, result);

    verify(accountRepository).add(accountCaptor.capture());
    var captor = accountCaptor.getValue();
    assertThat(captor.getId()).isNotNull();
    assertThat(captor.getName()).isEqualTo(ACCOUNT_NAME);
    assertThat(captor.getEmail().getValue()).isEqualTo(ACCOUNT_EMAIL);
    assertThat(result.getJsonResponse().getId()).isEqualTo(accountCaptor.getValue().getId());
    assertThat(result.getJsonResponse().getName()).isEqualTo(ACCOUNT_NAME);
    assertThat(result.getJsonResponse().getEmail()).isEqualTo(ACCOUNT_EMAIL);
  }

  @Test(expected = BusinessException.class)
  public void shouldThrowExceptionWhenRegisterAccountWithEmailAlreadyExisting() {
    when(accountRepository.withEmail(ACCOUNT_EMAIL)).thenReturn(Optional.of(ACCOUNT_EXISTING));
    var command = RegisterAccountCommand.of(ACCOUNT_NAME, ACCOUNT_EMAIL);
    var result = new RegisterAccountPresenter();

    registerAccountCommand.handle(command, result);
  }

  @Test(expected = IllegalArgumentException.class)
  public void shouldThrowExceptionWhenRegisterAccountWithEmptyEmail() {
    var command = RegisterAccountCommand.of(ACCOUNT_NAME, "");
    var result = new RegisterAccountPresenter();

    registerAccountCommand.handle(command, result);
  }

  @Test(expected = IllegalArgumentException.class)
  public void shouldThrowExceptionWhenRegisterAccountWithNullEmail() {
    var command = RegisterAccountCommand.of(ACCOUNT_NAME, null);
    var result = new RegisterAccountPresenter();

    registerAccountCommand.handle(command, result);
  }
}
