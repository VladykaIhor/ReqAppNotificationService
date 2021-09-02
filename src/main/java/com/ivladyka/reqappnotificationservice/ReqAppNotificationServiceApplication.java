package com.ivladyka.reqappnotificationservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient

public class ReqAppNotificationServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(ReqAppNotificationServiceApplication.class, args);
    }

}
