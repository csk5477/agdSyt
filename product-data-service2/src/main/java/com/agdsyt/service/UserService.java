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
        userList.add(new User(1l,"1","4"));
        userList.add(new User(2l,"2","5"));
        userList.add(new User(3l,"3","6"));
        return  userList;
    }
}
