package com.css.bos.common.sys.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.css.bos.common.base.dao.impl.BaseDaoImpl;
import com.css.bos.common.sys.dao.UserDao;
import com.css.bos.common.sys.domain.User;

@Repository
public class UserDaoImpl extends BaseDaoImpl<User> implements UserDao {

	public User findByLoginnameAndPassword(String loginname, String password) {
		String hql = "FROM User u WHERE u.loginname = ? and u.password = ?";
		List<User> list = (List<User>) this.getHibernateTemplate().find(hql, loginname, password);
		if (list != null && list.size() > 0) {
			return list.get(0);
		}
		return null;
	}

}
