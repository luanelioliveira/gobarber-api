package com.luanelioliveira.gobarber.customers.domain.usecase;

import java.util.function.Consumer;

@FunctionalInterface
public interface UseCase<T, P> {
  void execute(final T request, Consumer<P> consumer);
}
