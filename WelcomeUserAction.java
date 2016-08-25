package com.contactApp.action;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.struts2.ServletActionContext;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.contactApp.beans.provideUserService;

public class WelcomeUserAction {
	private static Logger log;
	static {
		log = LogManager.getLogger(WelcomeUserAction.class.getName());
	}
		
	private String username;
	private String password;
	private String newUser;
	private int listSize;
	

	public int getListSize() {
		return listSize;
	}

	public void setListSize(int listSize) {
		this.listSize = listSize;
	}

	public String getNewUser() {
		return newUser;
	}

	public void setNewUser(String newUser) {
		this.newUser = newUser;
	}

	private provideUserService usrService;
	private List<UserInfoData> userdata;
	private UserInfoData updateduserdata;
	
	public UserInfoData getUpdateduserdata() {
		return updateduserdata;
	}

	public void setUpdateduserdata(UserInfoData updateduserdata) {
		this.updateduserdata = updateduserdata;
	}

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
		log.debug("inside WelcomeUserAction execute method");
		WebApplicationContext context = WebApplicationContextUtils.getRequiredWebApplicationContext(ServletActionContext.getServletContext());
		
		provideUserService UsrService = (provideUserService)context.getBean("provideUserService");
		authUser = UsrService.getSessionInfo(getUsername(), getPassword(), ServletActionContext.getRequest());
		
		if(authUser) {
			if(getNewUser() != null && getNewUser().equalsIgnoreCase("yes")){
				//if got a new user adding request 
				log.debug("got a new user adding request here");
				return "showadduser";
			}
			else {
			
					//Here we come when this is not a new User adding or updating existing user requests........
					log.debug("Here we come when this is not a new User adding or updating existing user requests");
					if(UsrService.getUserListPresent(ServletActionContext.getRequest())) {
						log.debug("we have existing users list in session ");
						try {
							HttpSession session = ServletActionContext.getRequest().getSession();
							HashMap<Integer, UserInfoData> mapEx = (HashMap<Integer, UserInfoData>)session.getAttribute("mapUsr");
							Collection<UserInfoData> collUsr = (Collection<UserInfoData>) mapEx.values();
							List<UserInfoData> list = new ArrayList<>(collUsr);
							System.out.println(list.size());
							setUserdata(list);
							setListSize(list.size());
						}
						catch(Exception ex) {
							log.error("error while providing the existing users list "+ex);
							return "failure";
						}
						return "showuserlist";
					}				
					else
						log.debug("we do NOT have existing users in session, so sending a new user request ");
						return "showadduser";
				}
			
			
		}
		else {
			log.error("Looks like user is not authenticated here, so need to return Login page again!! ");
			return "input";
		}
		
	}
	
	
}
