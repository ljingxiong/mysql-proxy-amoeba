package com.mysql.proxy.amoeba.test;

import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

import com.alibaba.fastjson.JSON;
import com.mysql.proxy.amoeba.bean.User;
import com.mysql.proxy.amoeba.config.AppConfig;
import com.mysql.proxy.amoeba.service.UserService;

@ContextConfiguration(classes = AppConfig.class)
public class ProxyTest extends AbstractJUnit4SpringContextTests {

	@Autowired
	private UserService userService;

	@Test
	public void save() {
		User user = new User();
		user.setName("bbb");
		user.setAge(12);
		user.setCreateAt(new Date());
		userService.save(user);
	}

	@Test
	public void query() {
		List<User> users = userService.query();
		for (User user : users) {
			System.out.println(JSON.toJSONString(user));
		}
	}
}