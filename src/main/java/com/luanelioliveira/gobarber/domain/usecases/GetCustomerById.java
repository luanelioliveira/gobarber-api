package com.luanelioliveira.gobarber.domain.usecases;

import com.luanelioliveira.gobarber.domain.usecases.requests.GetCustomerByIdRequest;
import com.luanelioliveira.gobarber.domain.usecases.responses.GetCustomerByIdResponse;

public interface GetCustomerById extends UseCase<GetCustomerByIdRequest, GetCustomerByIdResponse> {}
