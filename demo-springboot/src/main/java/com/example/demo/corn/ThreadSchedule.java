package com.example.demo.corn;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author mubi
 * @Date 2020/2/15 20:40
 */
@Service
public class ThreadSchedule {

    private static final Logger log = LoggerFactory.getLogger(ThreadSchedule.class);

//    @Scheduled(cron="*/10 * * * * ?")
    public void scheduled() {
        for(int i=0;i<3;i++) {
            executorService.submit(() -> testMethod());
            log.info("scheduled testMethod");
        }
    }

    public void testMethod() {
        try {
            long sums = 0;
            for(int i=0;i<1000_000_000;i+=2){
                sums += i;
            }
            log.info("testMethod call success {}", sums);
        }catch (Exception e) {
            log.info("testMethod call failed", e);
            throw e;
        }
    }

    static AtomicInteger atomicInteger = new AtomicInteger(0);

    ThreadFactory threadFactory = new ThreadFactory() {
        @Override
        public Thread newThread(Runnable r) {
            Thread thread = new Thread(r);
            thread.setName("TestName-" + atomicInteger.get());
            atomicInteger.incrementAndGet();
            return thread;
        }
    };

    ExecutorService executorService = new ThreadPoolExecutor(30,
            50,
            300,
            TimeUnit.MILLISECONDS,
            new LinkedBlockingQueue<>(10),
            threadFactory);
}
