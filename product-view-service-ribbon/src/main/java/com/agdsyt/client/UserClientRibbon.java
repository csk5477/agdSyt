package com.agdsyt.client;

import com.agdsyt.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * Ribbon 客户端
 */
@Component
public class UserClientRibbon {

    @Autowired
    private RestTemplate restTemplate;

    public List<User> findAll(){
        return  restTemplate.getForObject("http://PRODUCT-DATA-SERVICE/user/findAll",List.class);
    }
}
