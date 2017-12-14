package com.rest.projectexample;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.ConfigurableApplicationContext;

@EnableZuulProxy
@SpringBootApplication
public class ExampleMain {
    private static final Logger LOG = LoggerFactory.getLogger(ExampleMain.class);
    public static void main(String[] args) {
        LOG.info("ExampleMain Started");
        ConfigurableApplicationContext appContext = SpringApplication.run(ExampleMain.class, args);
       
    }
    
}
