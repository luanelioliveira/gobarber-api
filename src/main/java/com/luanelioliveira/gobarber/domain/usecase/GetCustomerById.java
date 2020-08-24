package com.luanelioliveira.gobarber.domain.usecase;

import com.luanelioliveira.gobarber.domain.usecase.request.GetCustomerByIdRequest;
import com.luanelioliveira.gobarber.domain.usecase.response.GetCustomerByIdResponse;

public interface GetCustomerById extends UseCase<GetCustomerByIdRequest, GetCustomerByIdResponse> {}
