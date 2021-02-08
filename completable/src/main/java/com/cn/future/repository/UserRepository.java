package com.cn.future.repository;

import com.cn.future.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author csx
 * @Date 2/8/21 10:58 AM
 * @Description TODO
 */
@Repository
public interface UserRepository extends JpaRepository<User,Long>, JpaSpecificationExecutor<User> {


    List<User> findByUserName(String userName);


    List<User> findBySid(Long sid);

}
