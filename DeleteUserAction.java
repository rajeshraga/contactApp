package com.contactApp.action;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.contactApp.beans.provideUserService;

public class DeleteUserAction {
	
	private String uid;
	private List<String> delUserList;	
	
	public List<String> getDelUserList() {
		return delUserList;
	}

	public void setDelUserList(List<String> delUserList) {
		this.delUserList = delUserList;
	}

	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public String execute() {
		System.out.println("here we have delete request");		
		
		WebApplicationContext context = WebApplicationContextUtils.getRequiredWebApplicationContext(ServletActionContext.getServletContext());
		
		provideUserService UsrService = (provideUserService)context.getBean("provideUserService");
		int i = Integer.parseInt(uid);
		UsrService.deleteUsersFromList(ServletActionContext.getRequest(), i);
		
	
		return "success";
	}

}
