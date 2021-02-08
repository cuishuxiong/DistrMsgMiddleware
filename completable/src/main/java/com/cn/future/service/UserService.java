package com.cn.future.service;

import com.cn.future.entity.User;
import com.cn.future.utils.JsonVo;
import org.springframework.data.domain.Page;

import java.util.List;

/**
 * @Author csx
 * @Date 2/8/21 10:51 AM
 * @Description TODO
 */
public interface UserService {

    JsonVo<List<User>> findByUserName(User user);

    JsonVo<List<User>> findBySid(User user);

    JsonVo<String> save(User user);

    Page<User> findAll(User user);

    Page<User> findAllByCondition(User user);
}
