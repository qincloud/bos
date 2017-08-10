package com.css.bos.common.base.dao.impl;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.css.bos.common.base.dao.IBaseDao;
import com.css.bos.common.base.domain.BaseDomain;
import com.css.bos.utils.PageBean;

public class BaseDaoImpl<T extends BaseDomain> extends HibernateDaoSupport implements IBaseDao<T> {

	private Class<T> entityClass;
	private SimpleDateFormat format = new SimpleDateFormat("yy-MM-dd HH:mm:ss");

	@Resource
	// @Autowired
	// @Qualifier(value="abc")
	public void setMySessionFactory(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}

	@SuppressWarnings("unchecked")
	public BaseDaoImpl() {
		ParameterizedType genericSuperclass = (ParameterizedType) this.getClass().getGenericSuperclass();
		Type[] actualTypeArguments = genericSuperclass.getActualTypeArguments();
		entityClass = (Class<T>) actualTypeArguments[0];
	}

	public void save(T entity) {
		entity.setDelFlag("0");
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DAY_OF_WEEK, 0);
		try {
			entity.setCreateTime(format.parse(format.format(cal.getTime())));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		this.getHibernateTemplate().save(entity);
	}

	public void delete(T entity) {
		entity.setDelFlag("1");
		this.getHibernateTemplate().update(entity);
	}

	public void update(T entity) {
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DAY_OF_WEEK, 0);
		try {
			entity.setUpdateTime(format.parse(format.format(cal.getTime())));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		this.getHibernateTemplate().update(entity);
	}

	public T findById(Serializable id) {
		return this.getHibernateTemplate().get(entityClass, id);
	}

	@SuppressWarnings("unchecked")
	public T findByPrimary(String id) {
		String hql = "FROM  " + entityClass.getSimpleName() + " WHERE delFlag = '0' and id=" + id;
		return (T) this.getHibernateTemplate().find(hql).get(0);
	}

	@SuppressWarnings("unchecked")
	public List<T> findAll() {
		String hql = "FROM  " + entityClass.getSimpleName() + " WHERE delFlag = '0'";
		return (List<T>) this.getHibernateTemplate().find(hql);
	}

	public void executeUpdate(String queryName, Object... objects) {
		@SuppressWarnings("deprecation")
		Session session = this.getSession();
		Query query = session.getNamedQuery(queryName);
		int i = 0;
		for (Object arg : objects) {
			query.setParameter(i++, arg);
		}
		query.executeUpdate();
	}

	@SuppressWarnings({ "unchecked" })
	public void pageQuery(PageBean pageBean) {
		int currentPage = pageBean.getCurrentPage();
		int pageSize = pageBean.getPageSize();
		DetachedCriteria detachedCriteria = pageBean.getDetachedCriteria();
		detachedCriteria.setProjection(Projections.rowCount());// select
																// count(*) from
																// bc_staff
		List<Long> list = (List<Long>) this.getHibernateTemplate().findByCriteria(detachedCriteria);
		Long total = list.get(0);
		pageBean.setTotal(total.intValue());
		detachedCriteria.setProjection(null);
		detachedCriteria.setResultTransformer(DetachedCriteria.ROOT_ENTITY);
		int firstResult = (currentPage - 1) * pageSize;
		int maxResults = pageSize;
		List<?> rows = this.getHibernateTemplate().findByCriteria(detachedCriteria, firstResult, maxResults);
		pageBean.setRows(rows);
	}
}
