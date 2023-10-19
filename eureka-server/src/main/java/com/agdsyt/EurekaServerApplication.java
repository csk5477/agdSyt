package com.agdsyt;

import cn.hutool.core.util.NetUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * EurekaServer 启动类
 *这是一个 EurekaServer ，它扮演的角色是注册中心，用于注册各种微服务，以便于其他微服务找到和访问。 所以 Eureka 这个单词是 “找到啦” 的意思。
 */
//EurekaServer 本身就是个 Springboot 微服务, 所以它有 @SpringBootApplication 注解。
@SpringBootApplication
//表示这是个 EurekaServer
@EnableEurekaServer
public class EurekaServerApplication
{
    @Value("${server.port}")
    public static int port;

    public static void main( String[] args )
    {
        if(!NetUtil.isUsableLocalPort(port)) {
            System.err.printf("端口%d被占用了，无法启动%n", port );
            System.exit(1);
        }
        new SpringApplicationBuilder(EurekaServerApplication.class).properties("server.port=" + port).run(args);
    }
}
