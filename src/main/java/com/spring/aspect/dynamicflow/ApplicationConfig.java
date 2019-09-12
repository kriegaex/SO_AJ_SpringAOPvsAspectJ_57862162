package com.spring.aspect.dynamicflow;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.EnableLoadTimeWeaving;

import static org.springframework.context.annotation.EnableLoadTimeWeaving.AspectJWeaving.ENABLED;

/**
 * Remarks about AspectJ load-time weaving(LTW) in Spring:
 *
 * According to the Spring manual it should be enough to put spring-instrument.jar is on the JVM command line
 * in combination with @EnableLoadTimeWeaving. Actually this does help Spring detect the AspectJ weaver,
 * I can see the aspects loaded. But obviously this happens too late after the application classes are
 * already loaded, so the aspects do not have any effect. I even added a static block
 * static { logger.info("JobProcessImpl class was loaded"); } to JobProcessImpl in order to check it an
 * the log output occurs right before the aspects are being activated, which of course is too late.
 *
 * LTW works if
 *
 * a) either I have both Java agents aspectjweaver.jar and spring-instrument.jar on JVM command line
 * in combination with @EnableLoadTimeWeaving (but then it tries to weave twice, I can see errors in the log)
 * or without @EnableLoadTimeWeaving (no errors in the log)
 *
 * b) or if I only use aspectjweaver.jar without @EnableLoadTimeWeaving.
 *
 * The latter is no surprise because AspectJ is independent of Spring and of course works even if Spring is
 * unaware of its presence. But if I want to advertise its presence via @EnableLoadTimeWeaving, I do not
 * understand why spring-instrument.jar is not enough, as described in the Spring manual.
 */
@Configuration
@EnableAspectJAutoProxy
@ComponentScan("com.spring.aspect.dynamicflow")
//@EnableLoadTimeWeaving(aspectjWeaving = ENABLED)
public class ApplicationConfig {}
