package com.kocesat.mybatisdemo.model.outbox.enums;

public enum OutboxProcessor {
  INITAL_1((short)99),
  INITIAL_2((short)98),
  ERROR_1((short)90);

  private final short id;

  OutboxProcessor(short id) {
    this.id = id;
  }

  public short getId() {
    return id;
  }
}
