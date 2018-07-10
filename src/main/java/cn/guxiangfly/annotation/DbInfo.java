package cn.guxiangfly.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * DbInfo
 *
 * 注解信息默认是 (RetentionPolicy.class  在编译的时候存在 运行的时候不存在，
 * 要想让它在编译的时候存在，那么我需要将它指定为 RetentionPolicy.RUNTIME
 * RetentionPolicy.RUNTIME
 * @author guxiang
 * @date 2017/11/4
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface DbInfo {

    String driverClass();

    String username();

    String password();

    String url();
}