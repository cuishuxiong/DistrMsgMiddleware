package com.cn.nacos.consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * @Author csx
 * @Date 2/7/21 2:09 PM
 * @Description TODO
 */
@SpringBootApplication
@EnableDiscoveryClient
public class ConsumerApplication {

  public static void main(String[] args) {
      SpringApplication.run(ConsumerApplication.class,args);
  }

    @Bean
    @LoadBalanced
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }


}
