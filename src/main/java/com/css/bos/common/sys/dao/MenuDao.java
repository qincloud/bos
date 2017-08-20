package com.css.bos.common.sys.dao;

import java.util.List;

import com.css.bos.common.base.dao.IBaseDao;
import com.css.bos.common.sys.domain.Menu;

public interface MenuDao extends IBaseDao<Menu> {
	public List<Menu> findByUserOfMenu(String userid);
}
