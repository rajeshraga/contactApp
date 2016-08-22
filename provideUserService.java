package com.contactApp.beans;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.security.Principal;
import java.util.Collection;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Properties;

import javax.servlet.AsyncContext;
import javax.servlet.DispatcherType;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpRequest;

import com.contactApp.action.UserInfoData;

public class provideUserService extends loadMessageBean {
	
	@Autowired HttpSession session;
	
	public provideUserService() {
		
	}
	public boolean getAuthUsers(String userid, String password, HttpServletRequest request) {
		
		HttpSession session= request.getSession();
		if(session.isNew()) {
			//this is a new session 
			if(userid == null || password == null ) return false;
			System.out.println("new session " +session.getId());
			//session.setAttribute(arg0, arg1);
			HashMap<Integer, UserInfoData> mapUser = new HashMap<>();
			session.setAttribute("mapUsr", mapUser);
			
		}
		else {
			//existing session for this user
			System.out.println("existing session " +session.getId());
			HashMap<Integer, UserInfoData> mapEx = (HashMap<Integer, UserInfoData>)session.getAttribute("mapUsr");
		
			if(mapEx == null) {
				System.out.println("session map attribute is empty");
				HashMap<Integer, UserInfoData> mapUser = new HashMap<>();	
				session.setAttribute("mapUsr", mapUser);
				
			}
			return true;
		}
		HashMap<String, String> authmap = getAuthUserInfo();
		if(authmap != null) {
			if((authmap.get("u1").equalsIgnoreCase(userid.trim()) || authmap.get("u2").equalsIgnoreCase(userid.trim())) &&
				(authmap.get("p1").equalsIgnoreCase(password.trim()) || authmap.get("p2").equalsIgnoreCase(password.trim())))
				return true;
			
		}
		
		return false;
	}
	
	public HashMap<String, String> getAuthUserInfo() {
		Properties prop = new Properties();
		InputStream input = null;
		input = loadMessageBean.class.getClassLoader().getResourceAsStream("authconfig.properties");
		if(input == null) {
			System.out.println("unable to find file authconfig.properties");
			return null;
		}
		
		try {
			prop.load(input);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//System.out.println(prop.getProperty("dbuser1"));
		HashMap<String, String> authuser = new HashMap<String,String>();
		authuser.put("u1", prop.getProperty("dbuser1"));
		authuser.put("u2", prop.getProperty("dbuser2"));
		authuser.put("p1", prop.getProperty("dbpassword1"));
		authuser.put("p2", prop.getProperty("dbpassword2"));
		
	/*	System.out.println( prop.getProperty("dbuser1"));
		System.out.println( prop.getProperty("dbuser2"));
		System.out.println( prop.getProperty("dbpassword1"));
		System.out.println( prop.getProperty("dbpassword2"));*/
		
		return authuser;
		
	}
	
	public void addUserInfo(UserInfoData data, HttpServletRequest request) throws Exception {
		
		HttpSession session= request.getSession();
		HashMap<Integer, UserInfoData> mapEx = (HashMap<Integer, UserInfoData>)session.getAttribute("mapUsr");
		int iCount = 0;
		if(mapEx == null){
			System.out.println("this should not be the case");
		}
		else {
			iCount = mapEx.size();
			System.out.println("Session Map count here " +iCount);
			mapEx.put(Integer.parseInt(data.getUid()), data);
			
			session.setAttribute("mapUsr", mapEx);
		}
		
	}
	
	public boolean getUserListPresent(HttpServletRequest request) {
		
		HttpSession session = request.getSession(false);
		if(session != null) {
			HashMap<Integer, UserInfoData> mapEx = (HashMap<Integer, UserInfoData>)session.getAttribute("mapUsr");
			if(mapEx.size() > 0) {
				//there are currently users in the list, so return true
				return true;
			}
			else
				return false;
		}
		else 
			return false; //since for a new user session, the user list would be empty
			
		
	}
	
	public void deleteUsersFromList(HttpServletRequest request, int delList) {
		HttpSession session= request.getSession();
		HashMap<Integer, UserInfoData> mapEx = (HashMap<Integer, UserInfoData>)session.getAttribute("mapUsr");
		
		mapEx.remove(delList);
		
		//Now update the session object
		session.setAttribute("mapUsr", mapEx);
		
		
	}

}
