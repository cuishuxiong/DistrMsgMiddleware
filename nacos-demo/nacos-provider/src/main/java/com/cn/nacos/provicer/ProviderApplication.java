package com.cn.nacos.provicer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Author csx
 * @Date 2/7/21 1:48 PM
 * @Description TODO
 */
@SpringBootApplication
@EnableDiscoveryClient
public class ProviderApplication {

  public static void main(String[] args) {
      SpringApplication.run(ProviderApplication.class,args);
  }
}
