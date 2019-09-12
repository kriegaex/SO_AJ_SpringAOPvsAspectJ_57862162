package com.spring.aspect.dynamicflow.process;

import com.spring.aspect.dynamicflow.entity.JobContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class JobProcessImpl implements JobProcess {
  private static final Logger logger = LoggerFactory.getLogger(JobProcessImpl.class);

  @Override
  public Object process(JobContext jobContext) {
    logger.info("Processing the job with jobid {}", jobContext.getJobId());
    return null;
  }
}
