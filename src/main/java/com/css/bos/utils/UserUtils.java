

package com.css.bos.utils;

import org.apache.struts2.ServletActionContext;

import com.css.bos.common.sys.domain.User;

public class UserUtils {

	/**
	 * 获取用户
	 */
	public static User getUser() {
		User user = (User) ServletActionContext.getRequest().getSession().getAttribute("user");
		return user;
	}

	/**
	 * 获得用户名
	 */
	public static String getUsername() {
		User user = (User) ServletActionContext.getRequest().getSession().getAttribute("user");
		return user.getUsername();

	}

	/**
	 * 获取用户皮肤
	 */
	public static String getTheme() {
		User user = (User) ServletActionContext.getRequest().getSession().getAttribute("user");
		return user.getTheme();
	}

	/**
	 * 
	 * 
	 * 设置用户皮肤
	 * 
	 * @param theme:皮肤名字
	 */
	public void setTheme(String theme) {
		User user = (User) ServletActionContext.getRequest().getSession().getAttribute("user");
		user.setTheme(theme);
	}
}
