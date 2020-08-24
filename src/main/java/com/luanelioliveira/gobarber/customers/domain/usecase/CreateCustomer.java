package com.luanelioliveira.gobarber.customers.domain.usecase;

import com.luanelioliveira.gobarber.customers.domain.usecase.request.CreateCustomerRequest;
import com.luanelioliveira.gobarber.customers.domain.usecase.response.CreateCustomerResponse;

public interface CreateCustomer extends UseCase<CreateCustomerRequest, CreateCustomerResponse> {}
