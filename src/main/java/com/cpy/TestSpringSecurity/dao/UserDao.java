package com.cpy.TestSpringSecurity.dao;

import com.cpy.TestSpringSecurity.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

//@Mapper//spring扫描到此注解为接口产生代理对象
@Repository
public interface UserDao {

    //根据用户名查询用户信息
    @Select("select * from user where username=#{username}")
    public User selectUserByUsername(String username);
}
