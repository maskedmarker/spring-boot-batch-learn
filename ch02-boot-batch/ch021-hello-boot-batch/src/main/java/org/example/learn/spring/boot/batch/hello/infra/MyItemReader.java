package org.example.learn.spring.boot.batch.hello.infra;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemReader;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class MyItemReader implements ItemReader<String> {

    private static final Logger logger = LoggerFactory.getLogger(MyItemReader.class);

    private Iterator<String> iterator;

    public MyItemReader() {
        List<String> data = Arrays.asList("Item1", "Item2", "Item3", "Item4");
        this.iterator = data.iterator();
    }

    @Override
    public String read() throws Exception {
        logger.info("{} is reading.", MyItemReader.class.getSimpleName());
        return iterator.hasNext() ? iterator.next() : null;
    }
}
