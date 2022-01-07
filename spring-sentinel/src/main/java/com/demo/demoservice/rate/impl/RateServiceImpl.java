package com.demo.demoservice.rate.impl;

import com.demo.demoservice.rate.RateService;
import com.google.common.util.concurrent.RateLimiter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author mubi
 * @Date 2019/8/9 19:54
 */
@Service
@Slf4j
public class RateServiceImpl implements RateService {

    private static AtomicInteger count = new AtomicInteger(0);

    private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    @Override
    public String countRateLimiter() {
        int rate = 3;
        String rs;
        if (count.get() > rate) {
           rs = "请求用户过多，请稍后在试！" + sdf.format(System.currentTimeMillis());
        } else {
            count.incrementAndGet();
            try {
                //处理核心逻辑
                TimeUnit.SECONDS.sleep(1);
                rs = "ok！" + sdf.format(System.currentTimeMillis());
            } catch (Exception e) {
                log.error("count rate limit", e);
                rs = "error !" + sdf.format(System.currentTimeMillis());
            } finally {
                count.decrementAndGet();
            }
        }
        return rs;
    }


    /**
     * 则同一个时刻，只运行 2 个进程同时运行制定代码
     */
    private static Semaphore semphore = new Semaphore(2);

    @Override
    public String countRateLimiterSemaphore() {
        int queueSize = 4;
        String rs;
        if(semphore.getQueueLength() > queueSize){
            rs = String.format("当前等待排队的任务数大于:%d，请稍候再试...", queueSize);
        } else {
            try {
                semphore.acquire();
                // 处理核心逻辑
                TimeUnit.SECONDS.sleep(1);
                rs = "ok！" + sdf.format(System.currentTimeMillis());
            } catch (InterruptedException e) {
                log.error("count rate limit", e);
                rs = "error !" + sdf.format(System.currentTimeMillis());
            } finally {
                semphore.release();
            }
        }
        return rs;
    }

    public static final int REQUEST_COUNT = 3;
    private static final RateLimiter rateLimiter = RateLimiter.create(REQUEST_COUNT);
    @Override
    public String countRateLimiterGuaua() {
        String rs;
        // 尝试获取令牌
        if(rateLimiter.tryAcquire()){
            try {
                // 处理核心逻辑
                TimeUnit.SECONDS.sleep(1);
                rs = "ok！" + sdf.format(System.currentTimeMillis());
            }catch (Exception e){
                log.error("rate limit", e);
                rs = "error !" + sdf.format(System.currentTimeMillis());
            }
        }else{
            rs = "limit !" + sdf.format(System.currentTimeMillis());
        }
        return rs;
    }

}
