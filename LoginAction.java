package com.contactApp.action;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.struts2.ServletActionContext;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.contactApp.beans.provideUserService;
import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static Logger log;
	static {
		log = LogManager.getLogger(LoginAction.class.getName());
	}
		
	private String username;
	private String password;
	
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
	
	@Override
	public void validate() {
	WebApplicationContext context = WebApplicationContextUtils.getRequiredWebApplicationContext(ServletActionContext.getServletContext());
		boolean authUser, authPassword = false;
		provideUserService UsrService = (provideUserService)context.getBean("provideUserService");
		authUser = UsrService.getAuthUserId(getUsername());
		authPassword = UsrService.getAuthPassword(getPassword());
		try {
			if(!authUser) {
				log.debug("userID is not authenticated");
				addFieldError("username", "User ID is not correct");
			}
			if(!authPassword) {
				log.debug("password is not authenticated");
				addFieldError("password", "Password is not correct");
				
			}

		}
		catch (Exception ex) {
			log.error("Exception in login action "+ex);
		}
		
    }
	
	public String execute() {
		
		log.debug("Already handled validation so just return success from Login Action execute method");
		return SUCCESS;
	
	}
}
