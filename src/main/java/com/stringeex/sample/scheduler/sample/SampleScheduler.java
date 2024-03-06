package com.stringeex.sample.scheduler.sample;

import com.stringeex.sample.core.consts.JobParameterName;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.JobParametersInvalidException;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Date;

@Configuration
@EnableScheduling
@EnableAsync
public class SampleScheduler {
    protected final Log LOGGER = LogFactory.getLog(getClass());

    @Autowired
    private JobLauncher jobLauncher;

    @Autowired
    private Job sampleJob;

    @Async
    @Scheduled(fixedRate = 1000)
    public void consume() throws InterruptedException {
        // Get current java server date time
        Date currentDateTime = new Date();
        this.LOGGER.debug(String.format("SAMPLE SCHEDULER CONSUME: %d", currentDateTime.getTime()));

        // Create job parameters
        JobParameters jobParameters = new JobParametersBuilder()
                .addLong(JobParameterName.JOB_TIMESTAMP, currentDateTime.getTime())
                .toJobParameters();

        // Start running job
        try {
            jobLauncher.run(sampleJob, jobParameters);
        } catch (JobExecutionAlreadyRunningException
                 | JobRestartException
                 | JobInstanceAlreadyCompleteException
                 | JobParametersInvalidException ex) {
            LOGGER.error(ex.getMessage(), ex);
        }
    }
}
