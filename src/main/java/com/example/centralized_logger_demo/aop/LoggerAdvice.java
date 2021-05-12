/**
 * @author anthonydonx
 */
package com.example.centralized_logger_demo.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.condition.ConditionalOnExpression;
import org.springframework.stereotype.Component;

@Aspect
@Component
@ConditionalOnExpression("${logger.track.enabled:true}")// enabled by default
public class LoggerAdvice {
    Logger logger = LoggerFactory.getLogger(LoggerAdvice.class);

    @Around("@annotation(com.example.centralized_logger_demo.aop.EnableTracking)")
    public Object track(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        long stratedTime = System.currentTimeMillis();
        Object obj = proceedingJoinPoint.proceed();
        long endedTime = System.currentTimeMillis();
        logger.info("Executing method name" + proceedingJoinPoint.getSignature() + " :::  & executing time is : " + (endedTime - stratedTime));
        return obj;
    }
}
