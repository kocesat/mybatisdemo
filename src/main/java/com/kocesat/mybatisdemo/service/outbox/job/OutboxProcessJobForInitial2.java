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
public class OutboxProcessJobForInitial2 extends QuartzJobBean {

  private final OutboxBatchService batchService;

  @Override
  protected void executeInternal(JobExecutionContext context) throws JobExecutionException {
//    log.info("OutboxProcessJobForInitial2 fired at: " + LocalDateTime.now());
    batchService.executeOutboxJob(OutboxProcessor.INITIAL_2, OutboxStatus.INITIAL);
//    log.info("OutboxProcessJobForInitial2 finished at: " + LocalDateTime.now());
  }
}
