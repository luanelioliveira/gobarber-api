package com.luanelioliveira.gobarber.core.domain.account;

import com.luanelioliveira.gobarber.core.domain.common.Email;
import com.luanelioliveira.gobarber.core.domain.common.exceptions.BusinessException;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@Builder
public class Account {

  private UUID id;
  private String name;
  private Email email;
  private LocalDateTime createdAt;
  private LocalDateTime updatedAt;

  public static Account newAccount(String name, String email) {
    if (Objects.isNull(name) || name.trim().isEmpty())
      throw new BusinessException("Name cannot be empty");

    if (Objects.isNull(email) || email.trim().isEmpty())
      throw new BusinessException("Email cannot be empty");

    var now = LocalDateTime.now();

    return Account.builder()
        .id(UUID.randomUUID())
        .name(name)
        .email(new Email(email))
        .createdAt(now)
        .updatedAt(now)
        .build();
  }
}
