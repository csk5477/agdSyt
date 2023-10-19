package com.agdsyt;

import brave.sampler.Sampler;
import cn.hutool.core.util.NetUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

/**
 * EurekaClient 启动类
 *
 */
//EurekaClient 本身就是个 Springboot 微服务, 所以它有 @SpringBootApplication 注解。
@SpringBootApplication
//表示这是个 EurekaClient 提供者
@EnableEurekaClient
public class ProductDataServiceApplication
{
    @Value("${server.port}")
    public static int port;

    public static void main( String[] args )
    {
        if(!NetUtil.isUsableLocalPort(port)) {
            System.err.printf("端口%d被占用了，无法启动%n", port );
            System.exit(1);
        }
        new SpringApplicationBuilder(ProductDataServiceApplication.class).properties("server.port=" + port).run(args);
    }
    //在启动类里配置 Sampler 抽样策略： ALWAYS_SAMPLE 表示持续抽样
    @Bean
    public Sampler defaultSampler() {
        return Sampler.ALWAYS_SAMPLE;
    }
}
