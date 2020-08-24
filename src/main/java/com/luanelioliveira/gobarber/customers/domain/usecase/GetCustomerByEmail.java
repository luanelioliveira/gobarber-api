package com.luanelioliveira.gobarber.customers.domain.usecase;

import com.luanelioliveira.gobarber.customers.domain.usecase.request.GetCustomerByEmailRequest;
import com.luanelioliveira.gobarber.customers.domain.usecase.response.GetCustomerByEmailResponse;

public interface GetCustomerByEmail
    extends UseCase<GetCustomerByEmailRequest, GetCustomerByEmailResponse> {}
