package com.cn.nacos.provicer.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/** @Author csx @Date 2/7/21 1:50 PM @Description TODO */
@RestController
public class ProviderController {

  @RequestMapping(value = "/echo/{string}", method = RequestMethod.GET)
  public String echo(@PathVariable String string) {
    return "Hello Nacos Discovery " + string;
  }
}
