package com.css.bos.common.sys.action;

import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;

import com.css.bos.common.base.action.BaseAction;
import com.css.bos.common.sys.domain.User;
import com.css.bos.common.sys.service.UserService;

public class UserAction extends BaseAction<User> {

	@Autowired
	UserService userService;

	private String checkcode;

	public String getCheckcode() {
		return checkcode;
	}

	public void setCheckcode(String checkcode) {
		this.checkcode = checkcode;
	}

	public String login() {
		String key = (String) ServletActionContext.getRequest().getSession().getAttribute("key");
		if (StringUtils.isNotBlank(key) && checkcode.equals(key)) {
			User u = userService.findByLoginnameAndPassword(model);
			if (u != null) {
				ServletActionContext.getRequest().getSession().setAttribute("user", u);
				return "home";
			} else {
				addActionError(this.getText("usererror"));
				return "login";
			}
		} else {
			addActionError(this.getText("checkerror"));
			return "login";
		}
	}
}
