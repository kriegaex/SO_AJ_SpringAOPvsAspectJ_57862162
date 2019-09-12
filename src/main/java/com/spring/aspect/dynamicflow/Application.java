package com.spring.aspect.dynamicflow;

import com.spring.aspect.dynamicflow.entity.JobContext;
import com.spring.aspect.dynamicflow.process.JobProcess;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class Application {
  public static void main(String[] args) {
    ConfigurableApplicationContext context = SpringApplication.run(Application.class, args);
    JobProcess jobProcess = context.getBean(JobProcess.class);
    System.out.println("jobProcess = " + jobProcess);
    jobProcess.process(new JobContext());
  }
}
