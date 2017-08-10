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

	private int page;// ҳ��
	private int rows;// ÿҳ��ʾ�ļ�¼��

	public void setRows(int rows) {
		this.rows = rows;
	}

	public void setPage(int page) {
		this.page = page;
	}

	/**
	 * ���淽��
	 * */
	public String save(){
		menuService.save(model);
		return "list";
	}
	
	
	/**
	 * ��ҳ��ѯ����
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
		// ��PageBean����תΪjson����
		JsonConfig jsonConfig = new JsonConfig();
		jsonConfig.setExcludes(new String[] { "currentPage", "detachedCriteria", "pageSize" });
		JSONObject jsonObject = JSONObject.fromObject(pageBean, jsonConfig);
		String json = jsonObject.toString();
		ServletActionContext.getResponse().setContentType("text/json;charset=UTF-8");
		ServletActionContext.getResponse().getWriter().print(json);
		return NONE;
	}
	
	

}
