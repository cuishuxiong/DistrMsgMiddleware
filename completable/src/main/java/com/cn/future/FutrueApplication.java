package com.cn.future;

import com.cn.future.config.DataSourceConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Import;

/**
 * @Author csx
 * @Date 2/8/21 10:38 AM
 * @Description TODO
 */
@Import(DataSourceConfig.class)
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class FutrueApplication {

  public static void main(String[] args) {
    SpringApplication.run(FutrueApplication.class,args);
  }
}
