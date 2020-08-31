package com.luanelioliveira.gobarber.core.domain.base;

import java.util.function.Consumer;

public interface QueryHandler<C extends Query<R>, R> {
  void handle(final C query, Consumer<R> result);
}
