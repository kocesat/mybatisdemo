package com.kocesat.mybatisdemo.service.outbox;

import com.kocesat.mybatisdemo.model.outbox.Outbox;
import com.kocesat.mybatisdemo.model.outbox.OutboxUpdateModel;
import com.kocesat.mybatisdemo.model.outbox.enums.OutboxProcessor;
import com.kocesat.mybatisdemo.model.outbox.enums.OutboxStatus;
import com.kocesat.mybatisdemo.repo.outbox.OutboxRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
@Transactional(
  isolation = Isolation.READ_COMMITTED,
  propagation = Propagation.REQUIRED,
  rollbackFor = Throwable.class)
public class OutboxService {

  private final OutboxRepository repository;

  @Transactional(readOnly = true)
  public List<Outbox> getProcessList(OutboxStatus status,
                                     OutboxProcessor processor,
                                     LocalDateTime insertTimeStart) {
    return repository.getProcessList(status.getCode(), processor.getId(), insertTimeStart);
  }

  public Outbox create(Outbox outbox) {
    outbox.setId(null);
    outbox.setStatus(OutboxStatus.INITIAL.getCode());
    outbox.setServiceId(OutboxProcessor.INITAL_1.getId());
    return repository.insert(outbox);
  }

  @Transactional(propagation = Propagation.REQUIRES_NEW)
  public void updateAsProcessingInNewTx(OutboxStatus currentStatus,
                                        OutboxProcessor service,
                                        LocalDateTime insertTimeStart){
    OutboxUpdateModel model = new OutboxUpdateModel();
    model
      .andStatusEquals(currentStatus.getCode())
      .andInsertTimeGreaterThan(insertTimeStart);
    model.setNewStatus(OutboxStatus.PROCESSING.getCode());
    model.setNewServiceId(service.getId());
    repository.updatePreProcess(model);
  }

  @Transactional(propagation = Propagation.REQUIRES_NEW)
  public void updateByIdInNewTx(Integer id,
                                Short currentStatus,
                                OutboxStatus newStatus,
                                OutboxProcessor newProcessor){
    OutboxUpdateModel model = new OutboxUpdateModel();
    model
      .andStatusEquals(currentStatus)
      .andIqEquals(id);
    model.setNewServiceId(newProcessor.getId());
    model.setNewStatus(newStatus.getCode());
    repository.updateById(model);
  }
}
