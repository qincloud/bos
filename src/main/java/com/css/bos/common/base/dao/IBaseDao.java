package com.css.bos.common.base.dao;

import java.io.Serializable;
import java.util.List;

import com.css.bos.common.base.domain.BaseDomain;
import com.css.bos.utils.PageBean;

public interface IBaseDao<T extends BaseDomain> {
	public void save(T entity);
	public void delete(T entity);
	public void update(T entity);
	public T findById(Serializable id);
	public List<T> findAll();
	public T findByPrimary(String id);
	public void executeUpdate(String queryName,Object ...objects);
	public void pageQuery(PageBean pageBean);
}
