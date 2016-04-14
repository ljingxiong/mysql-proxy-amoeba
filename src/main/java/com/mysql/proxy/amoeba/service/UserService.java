package com.mysql.proxy.amoeba.service;

import java.util.List;

import com.mysql.proxy.amoeba.bean.User;

public interface UserService {

	void save(User user);

	List<User> query();
}
