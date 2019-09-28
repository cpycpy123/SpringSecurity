package com.cpy.TestSpringSecurity.service;

import com.cpy.TestSpringSecurity.dao.UserDao;
import com.cpy.TestSpringSecurity.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

/**
 * 总结
 * spring security是一个基于spring专注于java应用程序提供身份验证和授权的框架，
 * 同时在web请求级和方法调用级处理身份确认和授权
 * 1.添加依赖
 * 2.创建配置类，继承WebSecurityConfigurerAdapter进行配置
 * 自定义用户认证：
 * 1.获取用户的信息校验(UserDetailService)
 * 2.处理用户的校验的业务逻辑处理(UserDetails)
 * 3.密码的加密（PasswordEndcoder)---BCryptPasswordEncoder();
 */
@Component
public class MyUserDetailService implements UserDetailsService {
    @Autowired
    private UserDao userDao;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        System.out.println("登录的用户名为："+username);
        //如果不是管理员登录系统需要从数据库中查询密码
        com.cpy.TestSpringSecurity.pojo.User user = userDao.selectUserByUsername(username);
        if(user==null){
            return null;
        }
        //调用数据库中用户名对应的用户信息，将密码获取到
        String password = passwordEncoder.encode(user.getPassword());//需要对密码进行加密，在用户注册时候，对密码进行加密
        System.out.println("验证的密码加密后的数据为："+password);
        //判断用户是否被冻结
        boolean flagnolocked=true;
       return (UserDetails) new User(username,password,true,true,true,flagnolocked, AuthorityUtils.commaSeparatedStringToAuthorityList("admin"));
//        return new User(username,"12345", AuthorityUtils.commaSeparatedStringToAuthorityList("admin"));
      // return (UserDetails) new User(username,password, AuthorityUtils.commaSeparatedStringToAuthorityList("admin"));
    }
}
