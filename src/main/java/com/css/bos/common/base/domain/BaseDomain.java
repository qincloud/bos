package com.css.bos.common.base.domain;

import java.util.Date;

public class BaseDomain implements java.io.Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -5890046352576267101L;
	protected String id;
	protected String delFlag;
	protected Date createTime;
	protected String cjr;
	protected Date updateTime;
	protected String xgr;
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDelFlag() {
		return delFlag;
	}

	public void setDelFlag(String delFlag) {
		this.delFlag = delFlag;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getCjr() {
		return cjr;
	}

	public void setCjr(String cjr) {
		this.cjr = cjr;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public String getXgr() {
		return xgr;
	}

	public void setXgr(String xgr) {
		this.xgr = xgr;
	}

}
