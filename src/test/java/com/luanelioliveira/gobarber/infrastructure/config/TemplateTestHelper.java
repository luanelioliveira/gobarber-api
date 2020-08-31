package com.luanelioliveira.gobarber.infrastructure.config;

import com.luanelioliveira.gobarber.domain.account.Account;
import com.luanelioliveira.gobarber.domain.common.Email;
import java.time.LocalDateTime;
import java.util.UUID;

public class TemplateTestHelper {

  public static Account getAccount() {
    return getAccountBuilder().build();
  }

  public static Account.AccountBuilder getAccountBuilder() {
    return Account.builder()
        .id(UUID.fromString("8b5fdd33-bc0a-412d-b932-ce6533bf2590"))
        .name("Isabel Heloisa Marlene Teixeira")
        .email(new Email("isabelheloisa@test.com.br"))
        .createdAt(LocalDateTime.of(2020, 8, 1, 10, 0, 0 ))
        .updatedAt(LocalDateTime.of(2020, 8, 1, 10, 0, 0 ));
  }
}