package com.ipubu.boot.skills.base.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.convert.DbRefResolver;
import org.springframework.data.mongodb.core.convert.DefaultDbRefResolver;
import org.springframework.data.mongodb.core.convert.DefaultMongoTypeMapper;
import org.springframework.data.mongodb.core.convert.MappingMongoConverter;
import org.springframework.data.mongodb.core.convert.MongoCustomConversions;
import org.springframework.data.mongodb.core.mapping.MongoMappingContext;

/**
 * @ClassName MongoConfig
 * @Description
 * @Author jzy
 * SpringBoot的MongoTemplate会默认向mongoDB的collection中添加一个 _class的键值对来方便继承
 * 如果不需要，你可以把DefaultMongoTypeMapper的构造函数的参数设为null即可。
 */
@Configuration
public class MongoConfig {

    protected static final Logger LOGGER = LoggerFactory.getLogger(MongoConfig.class);

    @Bean
    public MappingMongoConverter mappingMongoConverter(MongoDbFactory factory,
            MongoMappingContext context, BeanFactory beanFactory) {

        DbRefResolver dbRefResolver = new DefaultDbRefResolver(factory);
        MappingMongoConverter mappingConverter = new MappingMongoConverter(dbRefResolver, context);
        try {
            mappingConverter
                    .setCustomConversions(beanFactory.getBean(MongoCustomConversions.class));
        } catch (NoSuchBeanDefinitionException ignore) {
            LOGGER.error("MongoDB config exception...", ignore);
        }

        // 不往mongo中保存_class
        mappingConverter.setTypeMapper(new DefaultMongoTypeMapper(null));

        return mappingConverter;
    }
}
