package com.kocesat.mybatisdemo.model.outbox.enums;

public enum OutboxStatus {
  INITIAL((short)0),
  PROCESSING((short)1),
  ERROR((short)2),
  COMPLETE((short)3);

  private final short code;

  OutboxStatus(short code) {
    this.code = code;
  }

  public short getCode() {
    return code;
  }
}
