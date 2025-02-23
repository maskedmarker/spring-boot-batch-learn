package org.example.learn.spring.boot.batch.hello.config;

import org.example.learn.spring.boot.batch.hello.infra.MyItemProcessor;
import org.example.learn.spring.boot.batch.hello.infra.MyItemReader;
import org.example.learn.spring.boot.batch.hello.infra.MyItemWriter;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemWriter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableBatchProcessing
public class BatchConfig {

    @Bean
    public ItemReader<String> reader() {
        return new MyItemReader();
    }

    @Bean
    public ItemProcessor<String, String> processor() {
        return new MyItemProcessor();
    }

    @Bean
    public ItemWriter<String> writer() {
        return new MyItemWriter();
    }

    @Bean
    public Step step1(StepBuilderFactory stepBuilderFactory, ItemReader<String> reader,
                      ItemProcessor<String, String> processor, ItemWriter<String> writer) {
        return stepBuilderFactory.get("step1")
                .<String, String>chunk(2)  // Define chunk size
                .reader(reader)
                .processor(processor)
                .writer(writer)
                .build();
    }

    @Bean
    public Job job(JobBuilderFactory jobBuilderFactory, Step step1) {
        return jobBuilderFactory.get("job")
                .start(step1)
                .build();
    }
}