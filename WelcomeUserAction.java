package com.contactApp.action;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.contactApp.beans.loadMessageBean;
import com.contactApp.beans.provideUserService;
import com.opensymphony.xwork2.ActionContext;

public class WelcomeUserAction {

	private String username;
	private String password;
	private provideUserService usrService;
	private List<UserInfoData> userdata;
	
	public void setUsrService(provideUserService usrService) {
		this.usrService = usrService;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<UserInfoData> getUserdata() {
		return userdata;
	}

	public void setUserdata(List<UserInfoData> userdata) {
		this.userdata = userdata;
	}

	public String execute() {
		//System.out.println("inside execute method");
		boolean authUser = false;
		
		WebApplicationContext context = WebApplicationContextUtils.getRequiredWebApplicationContext(ServletActionContext.getServletContext());
		
		provideUserService UsrService = (provideUserService)context.getBean("provideUserService");
		authUser = UsrService.getAuthUsers(getUsername(), getPassword(), ServletActionContext.getRequest());
		
		if(authUser) {
			if(UsrService.getUserListPresent(ServletActionContext.getRequest())) {
				HttpSession session = ServletActionContext.getRequest().getSession();
				HashMap<Integer, UserInfoData> mapEx = (HashMap<Integer, UserInfoData>)session.getAttribute("mapUsr");
				Collection<UserInfoData> collUsr = (Collection<UserInfoData>) mapEx.values();
				List<UserInfoData> list = new ArrayList<>(collUsr);
				setUserdata(list);
				return "showuserlist";
			}				
			else
				return "showadduser";
		}
		else
			return "failure";
		
	}
}
