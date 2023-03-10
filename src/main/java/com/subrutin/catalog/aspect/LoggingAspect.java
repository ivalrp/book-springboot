package com.subrutin.catalog.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

@Component
@Slf4j
@Aspect
public class LoggingAspect {
    //(..) bisa diganti dengan nama method seperti arg pointcut
    @Pointcut("execution(* com.subrutin.catalog.web.*.*(..))")
    private void restAPI(){
    }

    @Pointcut("within(com.subrutin.catalog.web.*)")
    private void withinPointcutExample(){

    }

    @Pointcut("args(com.subrutin.catalog.dto.PublisherCreateRequestDTO)")
    private void argPoincutExample(){

    }

    @Pointcut("@args(com.subrutin.catalog.annotation.LogThisArg)")
    private void argsPoincutExample(){

    }

    @Before("restAPI() && argsPoincutExample()")
    public void beforeExecutedLogging(){
        log.info("this is log from aspect before method executed");
    }

    @After("restAPI() && argsPoincutExample()")
    public void afterExecutedLogging(){
        log.info("this is log from aspect after method executed");
    }

    @AfterReturning("restAPI() && argsPoincutExample()")
    public void afterReturnExecutedLogging(){
        log.info("this is log from aspect after return method executed");
    }

    @AfterThrowing("restAPI() && argsPoincutExample()")
    public void afterThrowExecutedLogging(){
        log.info("this is log from aspect after throw method executed");
    }

    @Around("restAPI()")
    public Object processingTimeLogging(ProceedingJoinPoint joinPoint) throws Throwable {
        StopWatch stopWatch = new StopWatch();
        try {
            log.info("start {},{} ",joinPoint.getTarget().getClass().getName(), joinPoint.getSignature().getName());
            stopWatch.start();
            return joinPoint.proceed();

        } finally {
            stopWatch.stop();
            log.info("finish {},{} execution time = {}",joinPoint.getTarget().getClass().getName(),
                    joinPoint.getSignature().getName(),
                    stopWatch.getTotalTimeMillis());
        }
    }

}
