package com.css.bos.common.sys.domain;

import com.css.bos.common.base.domain.BaseDomain;

public class Menu extends BaseDomain implements java.io.Serializable {
	
	private static final long serialVersionUID = -5124447097700204358L;
	private String parentid;
	private String name;
	private String target;
	private String href;
	private String sort;
	private String permission;

	public Menu(String parentid, String name, String target, String href, String sort, String permission) {
		super();
		this.parentid = parentid;
		this.name = name;
		this.target = target;
		this.href = href;
		this.sort = sort;
		this.permission = permission;
	}

	public String getParentid() {
		return parentid;
	}

	public void setParentid(String parentid) {
		this.parentid = parentid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTarget() {
		return target;
	}

	public void setTarget(String target) {
		this.target = target;
	}

	public String getHref() {
		return href;
	}

	public void setHref(String href) {
		this.href = href;
	}

	public String getSort() {
		return sort;
	}

	public void setSort(String sort) {
		this.sort = sort;
	}

	public String getPermission() {
		return permission;
	}

	public void setPermission(String permission) {
		this.permission = permission;
	}

}
