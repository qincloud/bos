package com.css.bos.common.sys.dao;

import com.css.bos.common.base.dao.IBaseDao;
import com.css.bos.common.sys.domain.User;

public interface UserDao extends IBaseDao<User> {
	public User findByLoginnameAndPassword(String loginname,String password);

}
