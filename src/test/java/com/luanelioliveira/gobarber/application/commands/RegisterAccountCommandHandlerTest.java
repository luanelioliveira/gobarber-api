package com.luanelioliveira.gobarber.application.commands;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.luanelioliveira.gobarber.domain.account.Account;
import com.luanelioliveira.gobarber.domain.account.AccountRepository;
import com.luanelioliveira.gobarber.domain.account.commands.RegisterAccountCommand;
import com.luanelioliveira.gobarber.domain.common.exceptions.BusinessException;
import com.luanelioliveira.gobarber.infrastructure.helpers.RegisterAccountResultConsumer;
import com.luanelioliveira.gobarber.infrastructure.helpers.TemplateTestHelper;
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

  private static final String ACCOUNT_NAME = "Isabel Heloisa Marlene Teixeira";
  private static final String ACCOUNT_EMAIL = "isabelheloisa@test.com.br";
  private static final Account ACCOUNT = TemplateTestHelper.getAccount(ACCOUNT_NAME, ACCOUNT_EMAIL);

  @Mock private AccountRepository accountRepository;

  @InjectMocks private RegisterAccountCommandHandler commandHandler;

  @Captor private ArgumentCaptor<Account> accountCaptor;

  private RegisterAccountCommand command;
  private RegisterAccountResultConsumer result;

  @Test
  public void shouldReturnAccountWhenRegisterAccount() {
    command = RegisterAccountCommand.of(ACCOUNT_NAME, ACCOUNT_EMAIL);
    result = new RegisterAccountResultConsumer();

    commandHandler.handle(command, result);

    verify(accountRepository).add(accountCaptor.capture());
    var captor = accountCaptor.getValue();
    assertThat(captor.getId()).isNotNull();
    assertThat(captor.getName()).isEqualTo(ACCOUNT_NAME);
    assertThat(captor.getEmail().getValue()).isEqualTo(ACCOUNT_EMAIL);
    assertThat(result.getResult().getId()).isEqualTo(accountCaptor.getValue().getId());
    assertThat(result.getResult().getName()).isEqualTo(ACCOUNT_NAME);
    assertThat(result.getResult().getEmail()).isEqualTo(ACCOUNT_EMAIL);
  }

  @Test(expected = BusinessException.class)
  public void shouldThrowExceptionWhenRegisterAccountWithEmailAlreadyExisting() {
    when(accountRepository.withEmail(ACCOUNT_EMAIL)).thenReturn(Optional.of(ACCOUNT));
    command = RegisterAccountCommand.of(ACCOUNT_NAME, ACCOUNT_EMAIL);
    result = new RegisterAccountResultConsumer();

    commandHandler.handle(command, result);
  }

  @Test(expected = IllegalArgumentException.class)
  public void shouldThrowExceptionWhenRegisterAccountWithEmptyEmail() {
    command = RegisterAccountCommand.of(ACCOUNT_NAME, "");
    result = new RegisterAccountResultConsumer();

    commandHandler.handle(command, result);
  }

  @Test(expected = IllegalArgumentException.class)
  public void shouldThrowExceptionWhenRegisterAccountWithNullEmail() {
    command = RegisterAccountCommand.of(ACCOUNT_NAME, null);
    result = new RegisterAccountResultConsumer();

    commandHandler.handle(command, result);
  }
}
