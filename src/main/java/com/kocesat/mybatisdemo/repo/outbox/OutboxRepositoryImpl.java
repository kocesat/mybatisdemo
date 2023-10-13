package com.kocesat.mybatisdemo.repo.outbox;

import com.kocesat.mybatisdemo.mapper.outbox.OutboxMapper;
import com.kocesat.mybatisdemo.model.outbox.Outbox;
import com.kocesat.mybatisdemo.model.outbox.OutboxUpdateModel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class OutboxRepositoryImpl implements OutboxRepository {

  private final OutboxMapper mapper;

  @Override
  public Outbox insert(Outbox outbox) {
    mapper.insert(outbox);
    return outbox;
  }

  @Override
  public int updatePreProcess(OutboxUpdateModel input) {
    return mapper.updatePreProcess(input);
  }

  @Override
  public int updateById(OutboxUpdateModel input) {
    return mapper.updateById(input);
  }

  @Override
  public List<Outbox> getProcessList(Short status, Short serviceId, LocalDateTime insertTimeStart) {
    return mapper.getProcessList(status, serviceId, insertTimeStart);
  }
}
