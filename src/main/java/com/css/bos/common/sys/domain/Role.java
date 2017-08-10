package com.css.bos.common.sys.domain;

import com.css.bos.common.base.domain.BaseDomain;

public class Role extends BaseDomain implements java.io.Serializable {
	private static final long serialVersionUID = 1L;
	private String office_id;
	private String name;
	private String enname;

	public String getOffice_id() {
		return office_id;
	}

	public void setOffice_id(String office_id) {
		this.office_id = office_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEnname() {
		return enname;
	}

	public void setEnname(String enname) {
		this.enname = enname;
	}
}
