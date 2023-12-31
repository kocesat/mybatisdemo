package com.kocesat.mybatisdemo.service.outbox.job;

import com.kocesat.mybatisdemo.model.outbox.enums.OutboxProcessor;
import com.kocesat.mybatisdemo.model.outbox.enums.OutboxStatus;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.quartz.DisallowConcurrentExecution;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
@DisallowConcurrentExecution
@RequiredArgsConstructor
@Slf4j
public class OutboxProcessJobForError1 extends QuartzJobBean {

  private final OutboxBatchService batchService;

  @Override
  protected void executeInternal(JobExecutionContext context) throws JobExecutionException {
//    log.info("OutboxProcessJobForError1 fired at: " + LocalDateTime.now());
    batchService.executeOutboxJob(OutboxProcessor.ERROR_1, OutboxStatus.ERROR);
//    log.info("OutboxProcessJobForError1 finished at: " + LocalDateTime.now());
  }
}
