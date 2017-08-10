package com.css.bos.common.sys.action;

import java.io.IOException;

import org.apache.struts2.ServletActionContext;
import org.hibernate.criterion.DetachedCriteria;
import org.springframework.beans.factory.annotation.Autowired;

import com.css.bos.common.base.action.BaseAction;
import com.css.bos.common.sys.domain.Menu;
import com.css.bos.common.sys.service.MenuService;
import com.css.bos.utils.PageBean;

import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;

@SuppressWarnings("serial")
public class MenuAction extends BaseAction<Menu> {

	@Autowired
	private MenuService menuService;

	private int page;// 页码
	private int rows;// 每页显示的记录数

	public void setRows(int rows) {
		this.rows = rows;
	}

	public void setPage(int page) {
		this.page = page;
	}

	/**
	 * 保存方法
	 * */
	public String save(){
		menuService.save(model);
		return "list";
	}
	
	
	/**
	 * 分页查询方法
	 * 
	 * @throws IOException
	 */
	public String pageQuery() throws IOException {
		PageBean pageBean = new PageBean();
		pageBean.setCurrentPage(page);
		pageBean.setPageSize(rows);
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(Menu.class);
		pageBean.setDetachedCriteria(detachedCriteria);
		// staffService.pageQuery(pageBean);
		// 将PageBean对象转为json返回
		JsonConfig jsonConfig = new JsonConfig();
		jsonConfig.setExcludes(new String[] { "currentPage", "detachedCriteria", "pageSize" });
		JSONObject jsonObject = JSONObject.fromObject(pageBean, jsonConfig);
		String json = jsonObject.toString();
		ServletActionContext.getResponse().setContentType("text/json;charset=UTF-8");
		ServletActionContext.getResponse().getWriter().print(json);
		return NONE;
	}
	
	

}
