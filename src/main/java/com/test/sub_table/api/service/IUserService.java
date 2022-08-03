package com.test.sub_table.api.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.test.sub_table.api.entity.User;

public interface IUserService extends IService<User> {

    Integer insertInitialization();
}
