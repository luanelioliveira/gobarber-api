package com.luanelioliveira.gobarber.domain.usecase;

import java.util.function.Consumer;

@FunctionalInterface
public interface UseCase<T, P> {
  void execute(final T request, Consumer<P> consumer);
}
