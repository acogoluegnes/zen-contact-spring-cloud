package com.zenika;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

/**
 * Created by acogoluegnes on 02/09/15.
 */
@SpringBootApplication
@EnableCircuitBreaker
@EnableEurekaClient
@EnableHystrixDashboard
public class FrontApplication {

    public static void main(String[] args) {
        SpringApplication.run(FrontApplication.class,args);
    }

}
