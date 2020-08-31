package com.luanelioliveira.gobarber.infrastructure.db;

import com.luanelioliveira.gobarber.domain.account.Account;
import com.luanelioliveira.gobarber.domain.account.AccountRepository;
import com.luanelioliveira.gobarber.domain.common.Email;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import javax.inject.Named;

@Named
public class InMemoryAccountRepository implements AccountRepository {

  private Map<UUID, Account> ACCOUNTS = new ConcurrentHashMap<>();

  @Override
  public Account add(Account account) {
    var key = account.getId();
    deleteById(key);
    ACCOUNTS.put(key, account);
    return account;
  }

  @Override
  public Optional<Account> withEmail(Email email) {
    return ACCOUNTS
        .values()
        .stream()
        .filter(account -> email.equals(account.getEmail()))
        .findFirst();
  }

  @Override
  public Optional<Account> withId(UUID id) {
    var account = ACCOUNTS.get(id);
    return Optional.ofNullable(account);
  }

  @Override
  public List<Account> find(AccountFilter filter) {
    // TODO: add filtering
    return new ArrayList<>(ACCOUNTS.values());
  }

  @Override
  public List<Account> all() {
    return new ArrayList<>(ACCOUNTS.values());
  }

  @Override
  public void deleteById(UUID id) {
    ACCOUNTS.remove(id);
  }
}
