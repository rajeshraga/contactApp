package com.contactApp.action;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.contactApp.beans.provideUserService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.util.ValueStack;

public class DeleteUserAction {
	
	private String uid;
	private Map<Integer,String> userchkList;
	private List<UserInfoData> userdata;
	public List<UserInfoData> getUserdata() {
		return userdata;
	}

	public void setUserdata(List<UserInfoData> userdata) {
		this.userdata = userdata;
	}

	public Map<Integer, String> getUserchkList() {
		return userchkList;
	}

	public String execute() {
		System.out.println("here we have delete request");
		
		WebApplicationContext context = WebApplicationContextUtils.getRequiredWebApplicationContext(ServletActionContext.getServletContext());		
		provideUserService UsrService = (provideUserService)context.getBean("provideUserService");
		
		HttpServletRequest request = ServletActionContext.getRequest();		
		String val = request.getParameter("allVals");
		List<String> delList = Arrays.asList(val.split(","));
		
		UsrService.deleteUsersFromList(ServletActionContext.getRequest(), delList);
		
	
		return "success";
	}

	public void setUserchkList(Map<Integer, String> userchkList) {
		this.userchkList = userchkList;
	}

	
	

}
