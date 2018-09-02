package com.ipubu.boot.skills.base.framework;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * @ClassName BeanContainer
 * @Description		Spring 容器
 * @Author jzy
 */
@Component
public class BeanContainer implements ApplicationContextAware {

    private static final Logger LOGGER = LoggerFactory.getLogger(BeanContainer.class);

    private static ApplicationContext applicationContext;

    public synchronized void setApplicationContext(ApplicationContext applicationContext)
            throws BeansException {
        BeanContainer.applicationContext = applicationContext;
        LOGGER.info(
                "ApplicationContext配置成功,在普通类可以通过调用BeanContainer.getAppContext()获取applicationContext对象.");
    }

    /**
     * 获取applicationContext
     * 
     * @return
     */
    public static synchronized ApplicationContext getApplicationContext() {
        return applicationContext;
    }

    // 通过name获取 Bean.
    public static Object getBean(String name) {
        return getApplicationContext().getBean(name);
    }


}
