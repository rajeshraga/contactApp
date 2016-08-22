<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="/struts-tags" prefix="s" %>
    <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-1.10.2.js"></script>
</head>
<body>

<script type="text/javascript">
$(document).ready(function(){
	
	
	$("#userdel").click(function(){
		var cnf = confirm("are you sure you want to delete the user records?");
		
		if(cnf) {
			var checkb = document.getElementById('userchk').value;
		 	confirm(checkb);
	 		$.ajax({
				 type: 'POST',
		         url: 'delete.action?uid='+checkb,		                    
                 dataType: "text",
                 contentType: 'text/plain',
                 success: function(data){
                     console.log(data);
                         
                         }                     
             });  
		}
	
	});
});
</script>

<s:form action="welcome" id="usertable" label="User details">
	<table border="10"  cellspacing="10" cellpadding="10"  >
		<tr>		
					<td><b>Delete Option</b></td>
					<td><b>User ID</b></td>
                    <td><b>First Name</b></td>
                    <td><b>Last Name</b></td>
                    <td><b>Date of Birth</b></td>
                    <td><b>SSN</b></td>
                    <td><b>Street</b></td>
                    <td><b>City</b></td>
                    <td><b>State</b></td>
                    <td><b>Zip</b></td>
        </tr>
		
		<s:iterator value="userdata" var="user" status="rowstatus">
		<tr>
		 	<td> <s:checkbox id="userchk" theme="simple" name="delUserList" fieldValue="%{#user.uid}" value="%{#user.uid}"></s:checkbox></td>
		 	<td><s:property value="#user.uid"/></td>
			<td><s:property value="#user.fname"/></td>
			<td><s:property value="#user.lname"/></td>
			<td><s:property value="#user.dob"/></td>
			<td><s:property value="#user.ssn"/></td>
			<td><s:property value="#user.street"/></td>
			<td><s:property value="#user.city"/></td>
			<td><s:property value="#user.state"/></td>
			<td><s:property value="#user.zip"/></td>
			<td><s:a action="update" value="Update" href="Update" ><s:param name="uid" value="#user.uid"> </s:param></s:a> </td>
		 </tr>
		</s:iterator>
		<s:submit id="userdel" action="delete" ></s:submit>
	</table>
</s:form>
</body>
</html>