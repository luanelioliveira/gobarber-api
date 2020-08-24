package com.luanelioliveira.gobarber.domain.models;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface CustomerRepository {
  Customer save(Customer customer);

  Optional<Customer> findByEmail(String email);

  Optional<Customer> findById(UUID id);

  List<Customer> findAll();
}
