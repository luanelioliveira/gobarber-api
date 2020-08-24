package com.luanelioliveira.gobarber.domain.usecases;

import com.luanelioliveira.gobarber.domain.usecases.requests.GetCustomerByEmailRequest;
import com.luanelioliveira.gobarber.domain.usecases.responses.GetCustomerByEmailResponse;

public interface GetCustomerByEmail
    extends UseCase<GetCustomerByEmailRequest, GetCustomerByEmailResponse> {}
