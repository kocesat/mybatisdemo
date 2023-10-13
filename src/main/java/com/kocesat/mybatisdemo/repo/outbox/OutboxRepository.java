package com.kocesat.mybatisdemo.repo.outbox;

import com.kocesat.mybatisdemo.model.outbox.Outbox;
import com.kocesat.mybatisdemo.model.outbox.OutboxUpdateModel;

import java.time.LocalDateTime;
import java.util.List;


public interface OutboxRepository {

  Outbox insert(Outbox outbox);
  int updatePreProcess(OutboxUpdateModel input);
  int updateById(OutboxUpdateModel input);
  List<Outbox> getProcessList(Short status, Short serviceId, LocalDateTime insertTimeStart);
}
