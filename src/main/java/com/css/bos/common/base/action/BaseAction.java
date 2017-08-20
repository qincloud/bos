package com.css.bos.common.base.action;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

import org.springframework.stereotype.Component;

import com.css.bos.common.base.domain.BaseDomain;
import com.css.bos.utils.GenericsUtils;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

/**
 * 
 * @author lzq
 *
 * @param <T>
 */
public class BaseAction<T extends BaseDomain> extends ActionSupport implements ModelDriven<T> {
	protected T model;

	public T getModel() {
		return model;
	}

	public BaseAction() {
		ParameterizedType genericSuperclass = null;

		if (this.getClass().getGenericSuperclass() instanceof ParameterizedType) {
			genericSuperclass = (ParameterizedType) this.getClass().getGenericSuperclass();
		} else {// 当前为Action创建了代理
			genericSuperclass = (ParameterizedType) this.getClass().getSuperclass().getGenericSuperclass();
		}

		Type[] actualTypeArguments = genericSuperclass.getActualTypeArguments();
		// 获得实体类型
		Class<T> entityClass = (Class<T>) actualTypeArguments[0];
//		Class<T> entityClass = GenericsUtils.getSuperClassGenricType(BaseAction.class, 0);
		try {
			// 通过反射创建对象
			model = entityClass.newInstance();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
	}
}
