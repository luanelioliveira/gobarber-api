package com.luanelioliveira.gobarber.domain.usecases;

import com.luanelioliveira.gobarber.domain.usecases.requests.GetAllCustomersRequest;
import com.luanelioliveira.gobarber.domain.usecases.responses.GetCustomerResponse;
import java.util.List;

public interface GetAllCustomers
    extends UseCase<GetAllCustomersRequest, List<GetCustomerResponse>> {}
