package com.eureka.main;

import java.io.IOException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.web.client.RestClientException;

@SpringBootApplication
@EnableEurekaServer
public class SpringBootHelloWorldApplication {

 

    public static void main(String[] args) throws RestClientException, IOException {
         SpringApplication.run(
                SpringBootHelloWorldApplication.class, args);
        
    }
}



