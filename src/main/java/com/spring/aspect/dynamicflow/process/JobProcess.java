package com.spring.aspect.dynamicflow.process;

import com.spring.aspect.dynamicflow.entity.JobContext;

public interface JobProcess {
  Object process(JobContext jobContext);
}
