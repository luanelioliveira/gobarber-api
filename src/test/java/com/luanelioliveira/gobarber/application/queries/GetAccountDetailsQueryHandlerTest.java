package com.luanelioliveira.gobarber.application.queries;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import com.luanelioliveira.gobarber.domain.account.Account;
import com.luanelioliveira.gobarber.domain.account.AccountRepository;
import com.luanelioliveira.gobarber.domain.account.queries.GetAccountDetailsQuery;
import com.luanelioliveira.gobarber.domain.common.exceptions.EntityNotFoundException;
import com.luanelioliveira.gobarber.infrastructure.helpers.GetAccountDetailsResultConsumer;
import com.luanelioliveira.gobarber.infrastructure.helpers.TemplateTestHelper;
import java.util.Optional;
import java.util.UUID;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class GetAccountDetailsQueryHandlerTest {

  private static final UUID ACCOUNT_ID = UUID.fromString("8b5fdd33-bc0a-412d-b932-ce6533bf2590");
  private static final String ACCOUNT_NAME = "Isabel Heloisa Marlene Teixeira";
  private static final String ACCOUNT_EMAIL = "isabelheloisa@test.com.br";
  private static final Account ACCOUNT = TemplateTestHelper.getAccount(ACCOUNT_NAME, ACCOUNT_EMAIL);

  @Mock private AccountRepository accountRepository;

  @InjectMocks private GetAccountDetailsQueryHandler queryHandler;

  private GetAccountDetailsQuery query;
  private GetAccountDetailsResultConsumer result;

  @Test
  public void shouldReturnAccountWhenGetAccountDetails() {
    when(accountRepository.withId(ACCOUNT_ID)).thenReturn(Optional.of(ACCOUNT));
    query = GetAccountDetailsQuery.of(ACCOUNT_ID);
    result = new GetAccountDetailsResultConsumer();

    queryHandler.handle(query, result);

    assertThat(result.getResult().getId()).isEqualTo(ACCOUNT_ID);
    assertThat(result.getResult().getName()).isEqualTo(ACCOUNT_NAME);
    assertThat(result.getResult().getEmail()).isEqualTo(ACCOUNT_EMAIL);
  }

  @Test(expected = EntityNotFoundException.class)
  public void shouldThrowExceptionWhenGetAccountDetailsNotFound() {
    when(accountRepository.withId(ACCOUNT_ID)).thenReturn(Optional.empty());
    query = GetAccountDetailsQuery.of(ACCOUNT_ID);
    result = new GetAccountDetailsResultConsumer();

    queryHandler.handle(query, result);
  }
}
