package com.spring.aspect.dynamicflow.activity;

import com.spring.aspect.dynamicflow.entity.JobContext;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public abstract class Task {
  private static final Logger log = LoggerFactory.getLogger(Task.class);

  @Around(
    "execution(public java.lang.Object com.spring.aspect.dynamicflow.process.JobProcessImpl.process(..)) && " +
    "args(context)"
  )
  public Object task(ProceedingJoinPoint proceedingJoinPoint, JobContext context) throws Throwable {
    log.info("This is the base task and needs to overridden by the derived task for the job id: {} ", context.getJobId());
    return proceedingJoinPoint.proceed();
  }
}
