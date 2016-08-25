<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script src="https://code.jquery.com/jquery-1.10.2.js"></script>
<title>Insert title here</title>
</head>
<body>


<s:form action="adduser" validate="true">
	<s:hidden key="updateExistingUser"  value="yes"/>
	<s:hidden key="uid"  value="%{uid}"/>
  <s:push value="updateduserdata" >
  <h1>Hello ${username}</h1>
			<table id="userInfo">
				<tr>
					<td><s:textfield label="UserID" id="uid" disabled="true" key="uid"></s:textfield><br /></td>
				</tr>
				<tr>
					<td><s:textfield label="First Name" id="fname" key="fname" class="usr"></s:textfield><br /></td>
				</tr>
				<tr>
					<td><s:textfield label="Last Name" id="lname" key="lname" class="usr"></s:textfield><br /></td>
				</tr>
				<tr>
					<td><s:textfield label="Date of Birth" id="dob" key="dob" class="usr"></s:textfield><br /></td>
				</tr>
				<tr>
					<td><s:textfield key="ssn" id="ssn" label="SSN" class="usr"></s:textfield><br /></td>
				</tr>
				<tr>
					<td><s:textfield key="street" id="street" label="Street Name" class="usr"></s:textfield><br /></td>
				</tr>
				<tr>
					<td><s:textfield key="city" id="city" class="usr" label="City Name"></s:textfield><br /></td>
				</tr>
				<tr>
					<td><s:textfield key="state" id="state" label="State" class="usr"></s:textfield><br /></td>
				</tr>
				<tr>
					<td><s:textfield key="zip" class="usr" id="zip" label="Zip"></s:textfield><br /></td>
				</tr>
				
				<s:submit id="submit"/>
			
			</table>
	</s:push>	

</s:form>

<script type="text/javascript">
$(document).ready(function(){
	
	
	$("form").submit(function(event){
		if(!validateform()){
		
			$('#submit').attr('disabled',true);
			event.preventDefault();
			return false;
		}
		
	});
	
	$(".usr").change(function(){
		
		$('#submit').removeAttr('disabled');
		$(".error").remove();
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
	 	
		
    	return flag;
   	}
    
});     	
</script>

</body>
</html>