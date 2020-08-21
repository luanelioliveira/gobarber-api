package com.luanelioliveira.gobarber.application;

public interface CommandHandler<C extends Command, E> {
  E execute(C command);
}
