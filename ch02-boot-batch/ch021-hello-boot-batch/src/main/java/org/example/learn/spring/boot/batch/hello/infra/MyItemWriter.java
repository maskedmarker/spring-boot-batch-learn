package org.example.learn.spring.boot.batch.hello.infra;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemWriter;

import java.util.List;

public class MyItemWriter implements ItemWriter<String> {

    private static final Logger logger = LoggerFactory.getLogger(MyItemWriter.class);

    @Override
    public void write(List<? extends String> items) throws Exception {
        items.forEach(i -> {
            logger.info("{} is writing {}", MyItemWriter.class.getSimpleName(), i);
        });
    }
}
