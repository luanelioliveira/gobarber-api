package com.luanelioliveira.gobarber.domain.models;

import com.luanelioliveira.gobarber.domain.valueobjects.exceptions.EmailEmptyException;
import com.luanelioliveira.gobarber.domain.valueobjects.exceptions.NameEmptyException;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@Builder
public class Customer {

  private UUID id;
  private String name;
  private String email;
  private LocalDateTime createdAt;
  private LocalDateTime updatedAt;

  private Customer() {}

  public static Customer newCustomer(String name, String email) {
    if (Objects.isNull(name) || name.trim().isEmpty())
      throw new NameEmptyException();

    if (Objects.isNull(email) || email.trim().isEmpty())
      throw new EmailEmptyException();

    return Customer.builder()
        .id(UUID.randomUUID())
        .name(name)
        .email(email)
        .createdAt(LocalDateTime.now())
        .updatedAt(LocalDateTime.now())
        .build();
  }
}
