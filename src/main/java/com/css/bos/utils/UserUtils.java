

package com.css.bos.utils;

import org.apache.struts2.ServletActionContext;

import com.css.bos.common.sys.domain.User;

public class UserUtils {

	/**
	 * ��ȡ�û�
	 */
	public static User getUser() {
		User user = (User) ServletActionContext.getRequest().getSession().getAttribute("user");
		return user;
	}

	/**
	 * ����û���
	 */
	public static String getUsername() {
		User user = (User) ServletActionContext.getRequest().getSession().getAttribute("user");
		return user.getUsername();

	}

	/**
	 * ��ȡ�û�Ƥ��
	 */
	public static String getTheme() {
		User user = (User) ServletActionContext.getRequest().getSession().getAttribute("user");
		return user.getTheme();
	}

	/**
	 * 
	 * 
	 * �����û�Ƥ��
	 * 
	 * @param theme:Ƥ������
	 */
	public void setTheme(String theme) {
		User user = (User) ServletActionContext.getRequest().getSession().getAttribute("user");
		user.setTheme(theme);
	}
}
