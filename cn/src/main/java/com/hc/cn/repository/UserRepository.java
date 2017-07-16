package com.hc.cn.repository;

/**
 * Created by Charlie on 2017-07-17.
 */
import java.util.List;

import com.hc.cn.entity.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {

    List<User> findByLastName(String lastName);
    List<User> findByLoginName(String loginName);

}