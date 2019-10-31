package com.my.cache.annotation;

import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;

import javax.validation.constraints.NotNull;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.concurrent.TimeUnit;

/**
 * @author: chenmingyu
 * @date: 2019/9/23 17:44
 * @description: 添加缓存注解
 */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface CacheProfiler {

    /**
     * 缓存 cacheName的前缀部分
     */
    String prefixKey() default "";;

    /**
     * 缓存 cacheName的后缀部分
     * 支持SpEL表达式
     */
    String key() default "";

    /**
     * 缓存 cacheName的后缀部分
     * 优先级小于key()
     * @return
     */
    boolean useParams() default true;

    /**
     * 过期时间
     */
    long expire() default -1;

    /**
     * 缓存时间单位，默认为秒
     *
     * @return TimeUnit
     */
    TimeUnit timeUnit() default TimeUnit.SECONDS;

    /**
     * condition为true时进行缓存
     * 使用SpEL表达式解析condition
     * @return
     */
    String condition() default "";

    /**
     * 是否启用本地缓存
     */
    boolean localCache() default false;

    /**
     * 本地缓存过期时间
     *
     * 如果不设置，30秒内无访问则进行删除
     */
    long localCacheExpire() default -1;

    /**
     * key生成类
     * @see CacheConfig#keyGenerator
     */
    String keyGenerator() default "";
}
