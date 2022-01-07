package com.demo.demoservice.rate;

/**
 * @Author mubi
 * @Date 2019/8/9 19:54
 */
public interface RateService {

    /**
     * 计数器限流
     * @return
     */
    String countRateLimiter();

    /**
     * 计数器限流，信号量
     *
     * 使用Semaphore信号量来控制并发执行的次数，如果超过域值信号量，则进入阻塞队列中排队等待获取信号量进行执行。
     * 如果阻塞队列中排队的请求过多超出系统处理能力，则可以在拒绝请求。
     * @return
     */
    String countRateLimiterSemaphore();


    /**
     * 令牌桶
     * 实际业务在每次响应请求之前都从桶中获取令牌，只有取到令牌的请求才会被成功响应，
     * 获取的方式有两种：阻塞等待令牌或者取不到立即返回失败
     * @return
     */
    String countRateLimiterGuaua();
}
