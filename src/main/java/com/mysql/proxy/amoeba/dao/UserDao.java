package com.mysql.proxy.amoeba.dao;

import java.util.List;

import com.mysql.proxy.amoeba.bean.User;

public interface UserDao {

	void save(User user);

	List<User> query();
}
