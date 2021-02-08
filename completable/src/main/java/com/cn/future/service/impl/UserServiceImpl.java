package com.cn.future.service.impl;

import com.cn.future.config.DataSource;
import com.cn.future.constant.DataSourceType;
import com.cn.future.entity.User;
import com.cn.future.repository.UserRepository;
import com.cn.future.service.UserService;
import com.cn.future.utils.JsonVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author csx
 * @Date 2/8/21 11:06 AM
 * @Description TODO
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository repository;


    @Override
    @DataSource(value = DataSourceType.SLAVE1)
    public JsonVo<List<User>> findByUserName(User user) {
        JsonVo<List<User>> jsonVo = new JsonVo<>();
        jsonVo.setFlag("1");
        jsonVo.setObj(repository.findByUserName(user.getUserName()));
        return jsonVo;
    }

    @Override
    @DataSource(value = DataSourceType.SLAVE2)
    public JsonVo<List<User>> findBySid(User user) {
        JsonVo<List<User>> jsonVo = new JsonVo<>();
        jsonVo.setFlag("1");
        jsonVo.setObj(repository.findBySid(user.getSid()));
        return jsonVo;
    }

    @Override
    @DataSource(value = DataSourceType.MASTER)
    public JsonVo<String> save(User user) {
        JsonVo<String> jsonVo = new JsonVo<>();
        jsonVo.setFlag("1");
        repository.save(user);
        jsonVo.setMsg("保存成功~");
        return jsonVo;
    }

    @Override
    @DataSource(value = DataSourceType.SLAVE1)
    public Page<User> findAll(User user) {
        Sort sort =  Sort.by(Sort.Direction.DESC,"sid");
        Pageable pageable = PageRequest.of(0, 10, sort);
        return repository.findAll(pageable);
    }

    @Override
    @DataSource(value = DataSourceType.SLAVE2)
    public Page<User> findAllByCondition(User user) {
        Sort sort =  Sort.by(Sort.Direction.DESC,"sid");
        Pageable pageable = PageRequest.of(0, 10, sort);
        return repository.findAll((root, query, cb) ->{
            List<Predicate> predicates = new ArrayList();
            if (!StringUtils.isEmpty(user.getSid())){
                predicates.add(cb.equal(root.get("sid"),user.getSid()));
            }
            if (!StringUtils.isEmpty(user.getUserName())){
                predicates.add(cb.like(root.get("userName"),"%"+user.getUserName()+"%"));
            }
            Predicate[] arrayPredicates = new Predicate[predicates.size()];
            return cb.and(predicates.toArray(arrayPredicates));
        },pageable);
    }


}
