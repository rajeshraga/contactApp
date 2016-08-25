package com.contactApp.action;

import java.util.HashMap;

import javax.servlet.http.HttpSession;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.struts2.ServletActionContext;

import com.contactApp.beans.provideUserService;

public class UpdateUserAction {
	private static Logger log;
	static {
		log = LogManager.getLogger(UpdateUserAction.class.getName());
	}
	
	private String uid;
	private UserInfoData updateduserdata;

	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	public String execute() {
		
		int ikey = -1;
		if(getUid() != null) {
			try {
				ikey = Integer.parseInt(getUid());
			}
			catch(Exception ex) {
				log.error("exception while parsing user id " + ex);
			}
		}
		
		log.debug(getUid());
		if(ikey > 0) {
			HttpSession session = ServletActionContext.getRequest().getSession();
			HashMap<Integer, UserInfoData> mapEx = (HashMap<Integer, UserInfoData>)session.getAttribute("mapUsr");
			try {
				UserInfoData data = (UserInfoData)mapEx.get(ikey);
				setUpdateduserdata(data);
			}
			catch(Exception ex) {
				log.error("exception in execute for update user data " +ex);
				return "failure";
			}
		}
		return "success";
	}
	public UserInfoData getUpdateduserdata() {
		return updateduserdata;
	}
	public void setUpdateduserdata(UserInfoData updateduserdata) {
		this.updateduserdata = updateduserdata;
	}
	

}
