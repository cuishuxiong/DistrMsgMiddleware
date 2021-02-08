package com.cn.future.controller;

import com.cn.future.entity.User;
import com.cn.future.service.UserService;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.CompletableFuture;

/**
 * @Author csx
 * @Date 2/8/21 10:51 AM
 * @Description TODO
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/findByUserName")
    public CompletableFuture<String> findByUserName(@RequestBody User user){
        return CompletableFuture.supplyAsync(()->{
            return new Gson().toJson(userService.findByUserName(user));
        });
    }

    @PostMapping("/findBySid")
    public CompletableFuture<String> findBySid(@RequestBody User user){
        return CompletableFuture.supplyAsync(()->{
           return  new Gson().toJson(userService.findBySid(user));
        });
    }

    @PostMapping("/save")
    public CompletableFuture<String> save(@RequestBody User user){
        return CompletableFuture.supplyAsync(()->{
            return new Gson().toJson(userService.save(user));
        });
    }

    @PostMapping("/findAll")
    public CompletableFuture<String> findAll(@RequestBody User user){
        return CompletableFuture.supplyAsync(()->{
            return new Gson().toJson(userService.findAll(user));
        });
    }

    @PostMapping("/findAllByCondition")
    public CompletableFuture<String> findAllByCondition(@RequestBody User user){
        return CompletableFuture.supplyAsync(()->{
            return new Gson().toJson(userService.findAllByCondition(user));
        });
    }


}
