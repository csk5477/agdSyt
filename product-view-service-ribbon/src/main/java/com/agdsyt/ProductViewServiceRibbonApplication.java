package com.agdsyt;

import cn.hutool.core.util.NetUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * Ribbon 是使用 restTemplate 进行调用，并进行客户端负载均衡。
 * 什么是客户端负载均衡呢？ 在前面 注册数据微服务 里，注册了8001和8002两个微服务， Ribbon 会从注册中心获知这个信息，然后由 Ribbon 这个客户端自己决定是调用哪个，这个就叫做客户端负载均衡。
 *
 * 启动类
 *注解多了个 @EnableDiscoveryClient， 表示用于发现eureka 注册中心的微服务。
 * 还多了个 RestTemplate，就表示用 restTemplate 这个工具来做负载均衡
 */
@SpringBootApplication
@EnableEurekaClient
@EnableDiscoveryClient
public class ProductViewServiceRibbonApplication
{
    @Value("${server.port}")
    public static int port;
    @Bean
    @LoadBalanced
    RestTemplate restTemplate() {
        return new RestTemplate();
    }

    public static void main( String[] args )
    {
        if(!NetUtil.isUsableLocalPort(port)) {
            System.err.printf("端口%d被占用了，无法启动%n", port );
            System.exit(1);
        }
        new SpringApplicationBuilder(ProductViewServiceRibbonApplication.class).properties("server.port=" + port).run(args);
    }
}
