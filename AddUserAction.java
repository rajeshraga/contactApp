package com.contactApp.action;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.contactApp.beans.provideUserService;

public class AddUserAction {
	
	private static String FALSE = "false";
	private static String TRUE = "true";
	
	private String uid;
	private String fname;
	private String lname;
	private String dob;
	private String ssn;
	private String street;
	private String city;
	private String state;
	private String zip;
	private String flag;
	private List<UserInfoData> userdata;
	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getSsn() {
		return ssn;
	}

	public void setSsn(String ssn) {
		this.ssn = ssn;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	private List<UserInfoData> data;
	
	
	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public String execute() {
			
			HttpServletRequest request = ServletActionContext.getRequest();
			HttpSession session = request.getSession(false);
			System.out.println(getFname() + ' ' + getFlag());
			HashMap<Integer, UserInfoData> mapEx  = null;
			if(session != null ) {
				mapEx = (HashMap<Integer, UserInfoData>)session.getAttribute("mapUsr");
				if(mapEx.isEmpty() && getFlag().equalsIgnoreCase(this.FALSE))
					return "error";
				
			}			
			UserInfoData usrData = getUserObj(getUid(),getFname(),getLname(),getDob(),getSsn(),getStreet(),getCity(),getState(),getZip());
			WebApplicationContext context = WebApplicationContextUtils.getRequiredWebApplicationContext(ServletActionContext.getServletContext());
			provideUserService UsrService = (provideUserService)context.getBean("provideUserService");
			
			try {
				UsrService.addUserInfo(usrData, request);
			}
			catch(Exception ex) {
				System.out.println("exception while adding the User Info " +ex);
				return "failure";
			}
			if(session != null)
				mapEx = (HashMap<Integer, UserInfoData>)session.getAttribute("mapUsr");
			
			if(mapEx == null) {
				System.out.println("After adding the User Info, map is null, this should never be the case");
			}
			else {
				Collection<UserInfoData> collUsr = (Collection<UserInfoData>) mapEx.values();
				List<UserInfoData> list = new ArrayList<>(collUsr);
				setUserdata(list);
				System.out.println("Checking the list size here " +userdata.size());
			}
			return "success";
	}	
	
	public String writeJSON() {
        try {
           // System.out.println(userdata.size());
	        if(data != null) {
	        	for (int i = 0; i < data.size(); i++) {
	                System.out.println("Data  " + data.get(i).getFname() );
	            }
	            System.out.println("Execute Method");
	        }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "success";
    }

	public List<UserInfoData> getUserdata() {
		return userdata;
	}

	public void setUserdata(List<UserInfoData> userdata) {
		this.userdata = userdata;
	}
	
	public UserInfoData getUserObj(String uid, String fname, String lname, String dob, String ssn, String street, String city,
			String state, String zip) {
		
		UserInfoData usrObj = new UserInfoData();
		usrObj.setUid(uid);
		usrObj.setFname(fname);
		usrObj.setLname(lname);
		usrObj.setDob(dob);
		usrObj.setSsn(ssn);
		usrObj.setStreet(street);
		usrObj.setCity(city);
		usrObj.setState(state);
		usrObj.setZip(zip);
		
		return usrObj;
	}

	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

}
