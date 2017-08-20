package com.css.bos.common.sys.intercepter;

import org.apache.struts2.ServletActionContext;

import com.css.bos.common.sys.domain.User;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;

@SuppressWarnings("serial")
public class CSSLoginIntercepter extends MethodFilterInterceptor {

	@Override
	protected String doIntercept(ActionInvocation arg0) throws Exception {
		User user = (User) ServletActionContext.getRequest().getSession().getAttribute("user");
		if (user == null) {
			return "login";
		}
		return arg0.invoke();
	}

}
