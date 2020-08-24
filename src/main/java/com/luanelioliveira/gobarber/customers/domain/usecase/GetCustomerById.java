package com.luanelioliveira.gobarber.customers.domain.usecase;

import com.luanelioliveira.gobarber.customers.domain.usecase.request.GetCustomerByIdRequest;
import com.luanelioliveira.gobarber.customers.domain.usecase.response.GetCustomerByIdResponse;

public interface GetCustomerById extends UseCase<GetCustomerByIdRequest, GetCustomerByIdResponse> {}
