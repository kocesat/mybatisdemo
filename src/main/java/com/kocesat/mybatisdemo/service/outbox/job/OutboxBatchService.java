package com.kocesat.mybatisdemo.service.outbox.job;

import com.kocesat.mybatisdemo.model.outbox.Outbox;
import com.kocesat.mybatisdemo.model.outbox.enums.OutboxProcessor;
import com.kocesat.mybatisdemo.model.outbox.enums.OutboxStatus;
import com.kocesat.mybatisdemo.service.outbox.OutboxService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class OutboxBatchService {

  private final OutboxService outboxService;

  public void executeOutboxJob(OutboxProcessor processor, OutboxStatus status) {
    try {
      LocalDateTime queryTimeStart = LocalDateTime.now().minusDays(1);
      outboxService.updateAsProcessingInNewTx(status, processor, queryTimeStart);
      List<Outbox> processList = outboxService.getProcessList(OutboxStatus.PROCESSING, processor, queryTimeStart);
      if (processList.isEmpty()) {
        log.info(String.format("No outbox with status %s found to process!", status.name()));
        return;
      }
      for (Outbox outbox : processList) {
        processOutbox(processor, outbox);
      }
    } catch (Exception e) {
      log.error("Error while processing outboxes", e);
    }
  }

  private void processOutbox(OutboxProcessor processor, Outbox outbox) {
    try {
      simulateProcess(outbox);
      outboxService.updateByIdInNewTx(outbox.getId(),
        outbox.getStatus(),
        OutboxStatus.COMPLETE,
        processor);
    } catch (Exception e) {
      outboxService.updateByIdInNewTx(outbox.getId(),
        outbox.getStatus(),
        OutboxStatus.ERROR,
        OutboxProcessor.ERROR_1);
    }
  }

  private void simulateProcess(Outbox outbox) throws InterruptedException {
    log.info(String.format("Outbox(id=%d) is being processed...", outbox.getId()));
    Thread.sleep(200L);
  }
}
