package com.ipubu.boot.skills;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.ApplicationContext;

import com.ipubu.boot.skills.base.framework.BeanContainer;
import com.ipubu.boot.skills.enjoymore.constant.Version;
import com.ipubu.boot.skills.enjoymore.smarthome.SmartHomeFactory;

/**
 * @ClassName BootApplication
 * @Description
 * @Author jzy
 */
@ServletComponentScan
@SpringBootApplication
@EnableCaching
public class BootApplication {

    private static final Logger LOGGER = LoggerFactory.getLogger(BootApplication.class);

    public static void main(String[] args) {

        BeanContainer beanContainer = new BeanContainer();

        // 设置容器上下文
        ApplicationContext app = SpringApplication.run(BootApplication.class, args);
        beanContainer.setApplicationContext(app);

        SmartHomeFactory.me();

        LOGGER.info("current version:{}", Version.VER);
    }

}
