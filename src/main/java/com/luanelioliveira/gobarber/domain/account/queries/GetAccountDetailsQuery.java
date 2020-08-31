package com.luanelioliveira.gobarber.domain.account.queries;

import com.luanelioliveira.gobarber.domain.base.Query;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor(staticName = "of")
public class GetAccountDetailsQuery implements Query<GetAccountDetailsResult> {
  private final UUID id;
}
