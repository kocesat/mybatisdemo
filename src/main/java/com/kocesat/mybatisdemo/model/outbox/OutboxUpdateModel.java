package com.kocesat.mybatisdemo.model.outbox;

import java.time.LocalDateTime;

public class OutboxUpdateModel {

  private Integer id;
  private LocalDateTime insertTimeStart;
  private Short serviceId;
  private Short status;
  private Short newStatus;
  private Short newServiceId;

  public OutboxUpdateModel() {
  }

  public Integer getId() {
    return id;
  }

  public LocalDateTime getInsertTimeStart() {
    return insertTimeStart;
  }

  public Short getServiceId() {
    return serviceId;
  }

  public Short getStatus() {
    return status;
  }

  public Short getNewStatus() {
    return newStatus;
  }

  public Short getNewServiceId() {
    return newServiceId;
  }

  public OutboxUpdateModel andIqEquals(Integer id) {
    this.id = id;
    return this;
  }

  public OutboxUpdateModel andInsertTimeGreaterThan(LocalDateTime insertTimeStart) {
    this.insertTimeStart = insertTimeStart;
    return this;
  }

  public OutboxUpdateModel andServiceIdEquals(Short serviceId) {
    this.serviceId = serviceId;
    return this;
  }

  public OutboxUpdateModel andStatusEquals(Short status) {
    this.status = status;
    return this;
  }

  public void setNewStatus(Short newStatus) {
    this.newStatus = newStatus;
  }

  public void setNewServiceId(Short newServiceId) {
    this.newServiceId = newServiceId;
  }
}
