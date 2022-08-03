package com.test.sub_table.api.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.test.sub_table.api.entity.User;
import com.test.sub_table.api.mapper.UserMapper;
import com.test.sub_table.api.service.IUserService;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Random;
import java.util.UUID;

@Service
public class UserServiceImpl  extends ServiceImpl<UserMapper, User> implements IUserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    @DS("sharding")
    public Integer insertInitialization() {
        int j = 0;
        Date d = new Date();
        for (int i = 0; i <10 ; i++) {
            User user = new User();

            user.setUserName(RandomStringUtils.random(10, "abcdefghijklmnopqrstuvwxyz0123456789"));
            user.setPassWord(RandomStringUtils.random(10, "abcdefghijklmnopqrstuvwxyz0123456789"));

            userMapper.insert(user);
            j++;
        }

        Date d2 = new Date();
        System.out.println(d2.getTime()-d.getTime());
        return j;
    }

}
