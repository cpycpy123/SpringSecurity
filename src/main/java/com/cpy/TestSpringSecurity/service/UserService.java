package com.cpy.TestSpringSecurity.service;

import com.cpy.TestSpringSecurity.pojo.User;

public interface UserService {
    //通过用户名查询用户
    public User selectUserByUsername(String username);
}
