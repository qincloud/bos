package com.css.bos.common.sys.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.css.bos.common.sys.dao.MenuDao;
import com.css.bos.common.sys.domain.Menu;
import com.css.bos.common.sys.service.MenuService;
import com.css.bos.utils.PageBean;

@Service
public class MenuServiceImpl implements MenuService {
	@Autowired
	private MenuDao menuDao;

	public void pageQuery(PageBean pageBean) {
		menuDao.pageQuery(pageBean);
	}

	public void save(Menu menu) {
		menuDao.save(menu);
	}

	public void delete(Menu menu) {
		menuDao.delete(menu);
	}

	public List<Menu> findAll() {
		return menuDao.findAll();
	}

	public Menu findById(String id) {
		return menuDao.findByPrimary(id);
	}

	public List<Menu> findByUserOfMenu(String userid) {
		return menuDao.findByUserOfMenu(userid);
	}
}
