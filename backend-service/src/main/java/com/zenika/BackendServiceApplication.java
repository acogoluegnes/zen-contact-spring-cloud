package com.zenika;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * Created by acogoluegnes on 02/09/15.
 */
@SpringBootApplication
@EnableEurekaClient
public class BackendServiceApplication {

    public static void main(String[] args) {
        //new SpringApplicationBuilder(BackendServiceApplication.class).profiles("instance1").run(args);
        new SpringApplicationBuilder(BackendServiceApplication.class).profiles("instance2").run(args);
    }

}
