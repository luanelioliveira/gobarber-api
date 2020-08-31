package com.luanelioliveira.gobarber.core.domain.account.queries;

import com.luanelioliveira.gobarber.core.domain.base.Query;
import java.util.UUID;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class GetAccountDetailsQuery implements Query<GetAccountDetailsResult> {
  private final UUID id;
}
