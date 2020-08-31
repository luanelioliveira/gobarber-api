package com.luanelioliveira.gobarber.core.domain.base;

import java.util.function.Consumer;

public interface CommandHandler<C extends Command<R>, R> {
  void handle(final C command, Consumer<R> result);
}
