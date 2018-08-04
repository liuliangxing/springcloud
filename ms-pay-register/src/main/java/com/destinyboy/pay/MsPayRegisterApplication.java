package com.destinyboy.pay;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class MsPayRegisterApplication {

    public static void main(String[] args) {
        SpringApplication.run(MsPayRegisterApplication.class);
    }
}
