package org.example.learn.spring.boot.batch.hello.infra;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemProcessor;

public class MyItemProcessor implements ItemProcessor<String, String> {

    private static final Logger logger = LoggerFactory.getLogger(MyItemProcessor.class);

    @Override
    public String process(String item) throws Exception {
        logger.info("{} is processing.", MyItemProcessor.class.getSimpleName());
        // Simple transformation (e.g., convert item to uppercase)
        return item.toUpperCase();
    }
}
