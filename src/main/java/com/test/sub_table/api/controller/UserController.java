package com.test.sub_table.api.controller;

import com.test.sub_table.api.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@RequestMapping("/user")
@Controller
public class UserController {

    @Autowired
    private IUserService userService;

    /**
     * 授权昵称,头像
     * @return
     */
    @RequestMapping(value = "/insertInitialization",produces = "application/json",method = RequestMethod.POST)
    @ResponseBody
    public Integer insertInitialization(){
        return userService.insertInitialization();
    }


}
