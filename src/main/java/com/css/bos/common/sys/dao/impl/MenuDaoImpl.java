package com.css.bos.common.sys.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.css.bos.common.base.dao.impl.BaseDaoImpl;
import com.css.bos.common.sys.dao.MenuDao;
import com.css.bos.common.sys.domain.Menu;

@Repository
public class MenuDaoImpl extends BaseDaoImpl<Menu> implements MenuDao {

	public List<Menu> findByUserOfMenu(String userid) {
		@SuppressWarnings("unchecked")
		List<Menu> list = (List<Menu>) this.getHibernateTemplate().find("",userid);
		return list;
	}

}
