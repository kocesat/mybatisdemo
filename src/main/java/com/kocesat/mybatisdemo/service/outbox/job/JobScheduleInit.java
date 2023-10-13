package com.kocesat.mybatisdemo.service.outbox.job;

import com.kocesat.mybatisdemo.constant.AppConstant;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.quartz.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.TimeZone;

@Component
@Slf4j
@RequiredArgsConstructor
public class JobScheduleInit implements CommandLineRunner {

  private final Scheduler quartzScheduler;

  @Override
  public void run(String... args) throws Exception {
    scheduleOutboxJob("Initial1", "0/5 * * * * ?", OutboxProcessJobForInitial1.class);
    scheduleOutboxJob("Initial2", "2/5 * * * * ?", OutboxProcessJobForInitial2.class);
    scheduleOutboxJob("Error1", "3/10 * * * * ?", OutboxProcessJobForError1.class);
  }

  private void scheduleOutboxJob(String jobName, String cronExpr, Class jobClass) {
    try {
      final JobKey jobKey = JobKey.jobKey("JobFor" + jobName, AppConstant.OUTBOX_PROCESS_JOB_GROUP);
      if (quartzScheduler.checkExists(jobKey)) {
        quartzScheduler.deleteJob(jobKey);
      }

      final JobDetail jobDetail = JobBuilder.newJob(jobClass)
        .withIdentity(jobKey.getName(), jobKey.getGroup())
        .withDescription(jobName)
        .storeDurably()
        .build();

      final TriggerKey triggerKey = TriggerKey.triggerKey("TriggerFor" + jobName, AppConstant.OUTBOX_PROCESS_JOB_GROUP);
      final CronTrigger cronTrigger = TriggerBuilder.newTrigger()
        .forJob(jobDetail)
        .withIdentity(triggerKey)
        .withSchedule(
          CronScheduleBuilder
            .cronSchedule(cronExpr)
            .withMisfireHandlingInstructionFireAndProceed()
            .inTimeZone(TimeZone.getTimeZone(AppConstant.TR_ZONE))
        )
        .build();

      quartzScheduler.scheduleJob(jobDetail, cronTrigger);
    } catch (Exception e) {
      log.error(String.format("%s could not be scheduled!", jobName), e);
    }
  }

}
