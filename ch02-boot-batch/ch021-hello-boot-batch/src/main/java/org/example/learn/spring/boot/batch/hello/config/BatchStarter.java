package org.example.learn.spring.boot.batch.hello.config;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * 可用通过编程方式启动job,也可以通过配置项spring.batch.job.names来完成
 */
//@Component
public class BatchStarter implements CommandLineRunner {

    @Autowired
    private JobLauncher jobLauncher;

    @Autowired
    private Job job;

    @Override
    public void run(String... args) throws Exception {
        // Launch the batch job
        jobLauncher.run(job, new JobParameters());
    }

}
