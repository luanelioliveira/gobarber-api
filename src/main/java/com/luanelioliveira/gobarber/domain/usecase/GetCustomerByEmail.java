package com.luanelioliveira.gobarber.domain.usecase;

import com.luanelioliveira.gobarber.domain.usecase.request.GetCustomerByEmailRequest;
import com.luanelioliveira.gobarber.domain.usecase.response.GetCustomerByEmailResponse;

public interface GetCustomerByEmail
    extends UseCase<GetCustomerByEmailRequest, GetCustomerByEmailResponse> {}
