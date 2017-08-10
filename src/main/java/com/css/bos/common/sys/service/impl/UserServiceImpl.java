package com.css.bos.common.sys.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.css.bos.common.sys.dao.UserDao;
import com.css.bos.common.sys.domain.User;
import com.css.bos.common.sys.service.UserService;

@Service
public class UserServiceImpl implements UserService{
	@Autowired
	private UserDao userDao;

	public User findByLoginnameAndPassword(User u) {
		User user = userDao.findByLoginnameAndPassword(u.getLoginname(), u.getPassword());
		return user;
	}

}
