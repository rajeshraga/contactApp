<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script src="https://code.jquery.com/jquery-1.10.2.js"></script>

</head>
<body>
	
	
	
<s:form action="adduser" validate="true" >

  <s:hidden id="flag" key="flag"></s:hidden>
  <h1>Hello ${username}</h1>
			<table id="userInfo">
				<tr>
					<td><s:textfield label="UserID" id="uid" key="uid"/><br /></td>
				</tr>
				<tr>
					<td><s:textfield label="First Name" id="fname" key="fname"/><br /></td>
				</tr>
				<tr>
					<td><s:textfield label="Last Name" id="lname" key="lname"/><br /></td>
				</tr>
				<tr>
					<td><s:textfield label="Date of Birth" id="dob" key="dob"/><br /></td>
				</tr>
				<tr>
					<td><s:textfield label="SSN" id="ssn" key="ssn"/><br /></td>
				</tr>
				<tr>
					<td><s:textfield label="Street Name" id="street" key="street"/><br /></td>
				</tr>
				<tr>
					<td><s:textfield label="City Name" id="city" key="city"/><br /></td>
				</tr>
				<tr>
					<td><s:textfield label="State" id="state" key="state"/><br /></td>
				</tr>
				<tr>
					<td><s:textfield label="Zip" id="zip" key="zip"/><br /></td>
				</tr>
				
				<s:submit id="submit"/>
			
			</table>
		

</s:form>

<span></span>


<script type="text/javascript">
$(document).ready(function(){
	
	
	$("form").submit(function(){
		if(!validateform())
			$("#flag").attr("value",'false');
		else
			$("#flag").attr("value",'true');
		
	});
	
	function validateform() {
		var nameReg = /^[A-Za-z]+$/;
	    var numberReg =  /^[0-9]+$/;
	    var uid = $('#uid').val();
		var fname = $('#fname').val();
		var lname = $('#lname').val();
		var dob = $('#dob').val();
		var ssn = $('#ssn').val();
		var street = $('#street').val();
		var city = $('#city').val();
		var state = $('#state').val();
		var zip = $('#zip').val();
		var flag = true;
			
		if(uid == "") {
			   $('#uid').after('<span class="error"> Please enter your User ID ' + '</span>');
			   flag = false;
	 	} 
	 	else if(!numberReg.test(uid)){
	  	   $('#uid').after('<span class="error"> Numbers only</span>');
	  	  flag = false;
	 	}
		
		if(fname == "") {
			   $('#fname').after('<span class="error"> Please enter your First Name '+' </span>');
			   flag = false;
    	} 
    	else if(!nameReg.test(fname)){
     	   $('#fname').after('<span class="error"> Letters only</span>');
     	  flag = false;
    	}
     	   
     	if(lname == "") {
			   $('#lname').after('<span class="error"> Please enter your Last Name ' + '</span>');
			   flag = false;
   		} 
   		else if(!nameReg.test(lname)){
    	   $('#lname').after('<span class="error"> Letters only</span>');
    	   flag = false;
   		}
    	   
    	if(ssn == "") {
			   $('#ssn').after('<span class="error"> Please enter your SSN ' + '</span>');
			   flag = false;
    	} 
    	else if(!numberReg.test(ssn)){
     	   $('#ssn').after('<span class="error"> Numbers only</span>');
     	  flag = false;
    	}
    	
    	if(dob == "") {
			   $('#dob').after('<span class="error"> Please enter your dob ' + '</span>');
			   flag = false;
	 	} 
	 	    	
    	if(street == "") {
			   $('#street').after('<span class="error"> Please enter your street ' + '</span>');
			   flag = false;
	 	} 
	 	
    	if(city == "") {
			   $('#city').after('<span class="error"> Please enter your city ' + '</span>');
			   flag = false;
	 	} 
	 
    	
    	if(state == "") {
			   $('#state').after('<span class="error"> Please enter your State ' + '</span>');
			   flag = false;
	 	} 
	 	
    	
    	if(zip == "") {
			   $('#zip').after('<span class="error"> Please enter your zip ' + '</span>');
			   flag = false;
	 	} 
	 	
		console.log(flag);
    	return flag;
   	}
     	
     	function PostUserData() {
     		alert("postuserdata called");
     		var fname = $('#fname').val();
    		var lname = $('#lname').val();
    		var dob = $('#dob').val();
    		var ssn = $('#ssn').val();
    		var street = $('#street').val();
    		var city = $('#city').val();
    		var state = $('#state').val();
    		var zip = $('#zip').val();
    		
    	/* 	var dataObj = {
    			    "data": [{
    			        "fname": "raj",
    			        "lname": "iyer",
    			        "dob": "abc",
    			        "ssn": "a",
    			        "street": "Chris",
    			        "city" : "dallas",
    			        "state" : "tx",
    			        "zip" : "aa"
    			    }]
    		}; */
	
    		var jsondata = JSON.stringify(dataObj);
    	//	console.log(jsondata);
    		
    		/*  $.ajax({
                 url:"adduser",
                 data: jsondata,
                 dataType: "json",
                 contentType: 'application/json',
                 type: 'POST',
                 async:true,
                 success: function(data){
                     console.log("success");
                         
                         }                     
             }); */


     	}
	
});

 </script>
	
</body>
</html>