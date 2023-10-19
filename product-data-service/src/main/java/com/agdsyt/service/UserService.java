package com.agdsyt.service;

import com.agdsyt.pojo.User;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * 用户服务类
 */
@Service
public class UserService {
    public List<User> findAll(){
        List<User> userList=new ArrayList<>();
        userList.add(new User(1l,"1","1"));
        userList.add(new User(2l,"2","2"));
        userList.add(new User(3l,"3","3"));
        return  userList;
    }
}
