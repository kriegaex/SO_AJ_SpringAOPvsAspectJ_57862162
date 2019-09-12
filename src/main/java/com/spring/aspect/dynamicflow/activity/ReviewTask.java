package com.spring.aspect.dynamicflow.activity;

import com.spring.aspect.dynamicflow.entity.JobContext;
import com.spring.aspect.dynamicflow.entity.TaskStatus;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Aspect
public class ReviewTask extends Task {
  private static final Logger log = LoggerFactory.getLogger(ReviewTask.class);

  @Override
  public Object task(ProceedingJoinPoint proceedingJoinPoint, JobContext context) throws Throwable {
    log.info("ReviewTask's task");
    /*
     * do some validation if annotation is completed or not
     */
    log.info("  Setting that the review is done.");
    context.setReviewTaskStatus(TaskStatus.IN_PROGRESS);
    return proceedingJoinPoint.proceed();
  }
}
