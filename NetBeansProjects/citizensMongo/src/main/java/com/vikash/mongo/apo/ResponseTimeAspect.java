package com.vikash.mongo.apo;

import jakarta.servlet.http.HttpServletResponse;
import lombok.CustomLog;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.util.Objects;


@Slf4j
@Aspect
@Component
public class ResponseTimeAspect {

    @Around("@annotation(captureResponseTime)")
    public Object measureResponseTime(ProceedingJoinPoint joinPoint,
                                      CaptureResponseTime captureResponseTime) throws Throwable {

        long startTime = System.currentTimeMillis();
        Object result = joinPoint.proceed();
        long endTime = System.currentTimeMillis();
        long responseTime = endTime - startTime;
      //  log.info(captureResponseTime.name()+" processing Time is: {} ms", responseTime);

        //Set Response Header
        if(captureResponseTime.addHeader())
        {
            HttpServletResponse response=((ServletRequestAttributes)
                    Objects.requireNonNull(RequestContextHolder.getRequestAttributes())).getResponse();
            assert response != null;
            response.addHeader("X-Response-Time", String.valueOf(responseTime));
        }
       return result;
    }
}
