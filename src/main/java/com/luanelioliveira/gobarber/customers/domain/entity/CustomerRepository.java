package com.luanelioliveira.gobarber.customers.domain.entity;

import java.util.Optional;
import java.util.UUID;

public interface CustomerRepository {
  Customer save(Customer customer);

  Optional<Customer> findByEmail(String email);

  Optional<Customer> findById(UUID id);
}
