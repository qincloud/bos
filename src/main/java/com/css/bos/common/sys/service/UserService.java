package com.css.bos.common.sys.service;

import com.css.bos.common.sys.domain.User;

public interface UserService {
	public User findByLoginnameAndPassword(User u);
	public void update(User Theme);
	public void Update(User Theme);
	public void save(User user);
	public void delete(User user);
}
