package com.css.bos.common.sys.service;

import java.util.List;

import com.css.bos.common.sys.domain.Menu;
import com.css.bos.utils.PageBean;

public interface MenuService {
	public void pageQuery(PageBean pageBean);

	public void save(Menu menu);

	public void delete(Menu menu);
	
	public List<Menu> findAll();
	
	public List<Menu> findByUserOfMenu(String userid);
}
