package com.agdsyt.service;

import com.agdsyt.client.UserClientFeign;
import com.agdsyt.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

/**
 * 服务类，数据从 UserClientRibbon 中获取
 */
@Service
public class UserService {

    @Autowired
    private UserClientFeign userClientFeign;

    public List<User> findAll(){
        return  userClientFeign.findAll();
    }
}
