package com.ipubu.boot.skills.enjoymore.config;

import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CachingConfigurer;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.ehcache.EhCacheCacheManager;
import org.springframework.cache.interceptor.CacheErrorHandler;
import org.springframework.cache.interceptor.CacheResolver;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.cache.interceptor.SimpleKeyGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import net.sf.ehcache.config.CacheConfiguration;

/**
 * @ClassName EhCacheConfiguration
 * @Description	  EhCache配置文件，可以替代ehcache.xml 文件
 * @Author jzy
 */

@Configuration
@EnableCaching		// springboot开启对缓存的支持
public class EhCacheConfiguration implements CachingConfigurer {

    @Bean(destroyMethod = "shutdown")
    public net.sf.ehcache.CacheManager ehCacheManager() {
        CacheConfiguration alinkedConfig = new CacheConfiguration();

        alinkedConfig.setName("linkedAccount");
        alinkedConfig.setMemoryStoreEvictionPolicy("LRU");
        alinkedConfig.setMaxEntriesLocalHeap(10000);

        CacheConfiguration accountDeviceConfig = new CacheConfiguration();
        accountDeviceConfig.setName("deviceAccount");
        accountDeviceConfig.setMemoryStoreEvictionPolicy("LRU");
        accountDeviceConfig.setMaxEntriesLocalHeap(10000);

        net.sf.ehcache.config.Configuration config = new net.sf.ehcache.config.Configuration();

        // 可以创建多个cacheConfiguration，都添加到Config中
        config.addCache(alinkedConfig);
        config.addCache(accountDeviceConfig);

        return net.sf.ehcache.CacheManager.newInstance(config);
    }

    @Bean
    @Override
    public CacheManager cacheManager() {
        return new EhCacheCacheManager(ehCacheManager());
    }

    @Bean
    @Override
    public KeyGenerator keyGenerator() {
        return new SimpleKeyGenerator();
    }

    @Override
    public CacheResolver cacheResolver() {
        return null;
    }

    @Override
    public CacheErrorHandler errorHandler() {
        return null;
    }

}
