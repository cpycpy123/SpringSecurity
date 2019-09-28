package com.cpy.TestSpringSecurity.service.impl;

import com.cpy.TestSpringSecurity.dao.UserDao;
import com.cpy.TestSpringSecurity.pojo.User;
import com.cpy.TestSpringSecurity.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public User selectUserByUsername(String username) {
        return userDao.selectUserByUsername(username);
    }
}
