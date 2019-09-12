package com.spring.aspect.dynamicflow;

import com.spring.aspect.dynamicflow.entity.JobContext;
import com.spring.aspect.dynamicflow.process.JobProcess;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * Run this from your IDE with
 *
 * a) either just -javaagent:/path/to/aspectjweaver.jar and without @EnableLoadTimeWeaving
 *
 * b) or with both -javaagent:/path/to/aspectjweaver.jar -javaagent:/path/to/spring-instrument.jar,
 * either with or without @EnableLoadTimeWeaving. What benefit this has, I don't know.
 *
 * See also my extensive comment in Application class.
 */
@SpringBootApplication
public class Application {
  private static final Logger log = LoggerFactory.getLogger(Application.class);

  public static void main(String[] args) {
    ConfigurableApplicationContext context = SpringApplication.run(Application.class, args);
    JobProcess jobProcess = context.getBean(JobProcess.class);
    log.info("jobProcess = {}", jobProcess);
    jobProcess.process(new JobContext());
  }
}
