package com.cpy.TestSpringSecurity;

import com.cpy.TestSpringSecurity.dao.UserDao;
import com.cpy.TestSpringSecurity.pojo.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestSpringSecurityApplicationTests {

	@Autowired
	private UserDao userDao;

	@Test
	public void contextLoads() {
		User user = userDao.selectUserByUsername("张三");
		System.out.println(user.getUsername());
	}

}
