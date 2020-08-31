package com.luanelioliveira.gobarber.core.domain.account;

import com.luanelioliveira.gobarber.core.domain.common.Email;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import lombok.Builder;
import lombok.Getter;

public interface AccountRepository {
  Account add(Account account);

  Optional<Account> withEmail(Email email);

  Optional<Account> withId(UUID id);

  List<Account> find(AccountFilter filter);

  List<Account> all();

  void deleteById(UUID id);

  @Getter
  @Builder
  class AccountFilter {
    private String email;
  }
}
