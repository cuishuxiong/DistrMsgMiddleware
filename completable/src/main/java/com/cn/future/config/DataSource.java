package com.cn.future.config;

import com.cn.future.constant.DataSourceType;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Author csx
 * @Date 2/8/21 11:22 AM
 * @Description TODO
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface DataSource {

    /**
     * 切换数据源
     */
    DataSourceType value() default DataSourceType.MASTER;

}
