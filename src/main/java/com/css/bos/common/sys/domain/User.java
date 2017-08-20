package com.css.bos.common.sys.domain;

import com.css.bos.common.base.domain.BaseDomain;

public class User extends BaseDomain implements java.io.Serializable {
	private static final long serialVersionUID = -9144274715213231907L;
	private String loginname;
	private String password;
	private String username;
	private String email;
	private String telphone;
	private String mobile;
	private String theme;
	
	public User(){
		
	}

	public User(String loginname, String password, String username, String email, String telphone, String mobile,
			String theme) {
		super();
		this.loginname = loginname;
		this.password = password;
		this.username = username;
		this.email = email;
		this.telphone = telphone;
		this.mobile = mobile;
		this.theme = theme;
	}

	public String getLoginname() {
		return loginname;
	}

	public void setLoginname(String loginname) {
		this.loginname = loginname;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelphone() {
		return telphone;
	}

	public void setTelphone(String telphone) {
		this.telphone = telphone;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getTheme() {
		return theme;
	}

	public void setTheme(String theme) {
		this.theme = theme;
	}

	@Override
	public String toString() {
		return "User [loginname=" + loginname + ", password=" + password + ", username=" + username + ", email=" + email
				+ ", telphone=" + telphone + ", mobile=" + mobile + ", theme=" + theme + "]";
	}

}
