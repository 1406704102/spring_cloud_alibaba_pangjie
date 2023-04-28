package org.pangjie;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication(scanBasePackages ={"org.pangjie","feign"})
@EnableFeignClients(basePackages = {"feign"}) //开启feign

@EnableDiscoveryClient
public class AuthApplication {
    public static void main(String[] args) {

        SpringApplication.run(AuthApplication.class);
    }
}