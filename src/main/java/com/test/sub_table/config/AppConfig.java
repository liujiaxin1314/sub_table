package com.test.sub_table.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Primary;
import org.springframework.core.env.Environment;

@Configuration
@MapperScan(basePackages = {"com.test.sub_table.api.**.mapper"}) // 扫描
//@Import(InitConfig.class)
public class AppConfig {

    private static Environment env;

    public static boolean isPro() {
        return getProfile().equals("pro");
    }

    public static String getProfile() {
        return env.getActiveProfiles()[0];
    }
    @Autowired
    private void setBean(Environment bean) {
        env = bean;
    }
}