package com.luanelioliveira.gobarber.infrastructure.persistence;

import com.luanelioliveira.gobarber.domain.models.Customer;
import com.luanelioliveira.gobarber.domain.models.CustomerRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import javax.inject.Named;

@Named
public class CustomerRepositoryInMemory implements CustomerRepository {

  private List<Customer> customers = new ArrayList<>();

  @Override
  public Customer save(Customer customer) {
    customers.add(customer);
    return customer;
  }

  @Override
  public Optional<Customer> findByEmail(String email) {
    return customers.stream().filter(customer -> email.equals(customer.getEmail())).findFirst();
  }

  @Override
  public Optional<Customer> findById(UUID id) {
    return customers.stream().filter(customer -> id.equals(customer.getId())).findFirst();
  }

  @Override
  public List<Customer> findAll() {
    return customers;
  }

  @Override
  public void deleteById(UUID id) {
    customers.removeIf(customer -> id.equals(customer.getId()));
  }
}
