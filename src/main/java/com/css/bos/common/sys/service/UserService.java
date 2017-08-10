package com.css.bos.common.sys.service;

import com.css.bos.common.sys.domain.User;

public interface UserService {
	public User findByLoginnameAndPassword(User u);
}
