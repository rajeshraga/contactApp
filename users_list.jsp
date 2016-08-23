<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="/struts-tags" prefix="s"%>
    <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-1.10.2.js"></script>
</head>
<body>

<script type="text/javascript">

/*var getelements = function() {
	var array = new Array[row];
	var count = -1;
	for(i = 0; i < row; i++ ) {
		//check the options selected by the user
		console.log("iteration" + i);
		if(document.getElementById('userchk['+ i +']').checked) {
			console.log('inside checked');
			count++;
			var uid = document.getElementById('userchk['+ i +']').value;
			confirm(uid);
			array[count] = uid; 
		}
	}
	console.log(array);
}

			$("#select_all").change(function(){
           if(this.checked){
           $(":checkbox").each(function(){
               this.checked=true;
           });             
       }else{
           $(":checkbox").each(function(){
               this.checked=false;
           });              
       }
   });
 
 	$(":checkbox").click(function () {
        if (!$(this).is(":checked")){
            $("#select_all").prop("checked", false);
        }else{
            var flag = 0;
            $(":checkbox").each(function(){
                if(!this.checked)
                flag=1;
            });              
            if(flag == 0){ 
            	$("#select_all").prop("checked", true);
            }
        }
    	});	
	
	    //Validate if all checkbox is checked	
		var allChecked = $(':checkbox:checked').length == $(':checkbox').length - 1;
		if (allChecked) {
			$("#select_all").prop("checked", true);
		} else {
			$("#select_all").prop("checked", false);
		}
	}); */

$(document).ready(function() {
		
	 var allVals = [];	
	
	$("#usertable").submit(function(event){
	
			var cnf = confirm("are you sure you want to delete the user records?");
			if(cnf) {
		 		allVals = [];
		 		$("#usertable :checked").each(function(){
		 			allVals.push($(this).val());
			 			
		 		});
		 		
		 			$.ajax({
					 type: 'POST',
			         url: 'delete.action',	
			         data: "allVals=" + allVals,
	                 success: function(data){
	                    	 console.log(data);
	                     },
	                  error: function(data){
	                  		console.log(data);
	                  }                        
	             	});
			}
			
	
		
	});	
});
</script>

<s:form action="welcome" id="usertable" label="User details">

	<s:a href='welcome?newUser=yes'>
	<s:label>Add New User</s:label>
	</s:a>
	<table border="5" >
		<tr>		
					<td>Select to Delete</td>
					<td><b>User ID</b></td>
                    <td><b>First Name</b></td>
                    <td><b>Last Name</b></td>
                    <td><b>Date of Birth</b></td>
                    <td><b>SSN</b></td>
                    <td><b>Street</b></td>
                    <td><b>City</b></td>
                    <td><b>State</b></td>
                    <td><b>Zip</b></td>
                    <td><b>Update</b></td>
        </tr>
		
		<s:iterator value="userdata" var="user" status="rowstatus">
		
			<s:url action="update" var="updateUrl">
			<s:param name="uid" value="%{#user.uid}"></s:param>
			</s:url>
		<tr>
		<!-- --userchk[%{#rowstatus.index}] -->
		 	<td> <s:checkbox cssClass="checkb" id="userchkList[%{#rowstatus.index}]" theme="simple" name="userchkList[%{#rowstatus.index}]" fieldValue="%{#user.uid}" value="%{#user.uid}"  ></s:checkbox></td>
		 	<td><s:property value="#user.uid"/></td>
			<td><s:property value="#user.fname"/></td>
			<td><s:property value="#user.lname"/></td>
			<td><s:property value="#user.dob"/></td>
			<td><s:property value="#user.ssn"/></td>
			<td><s:property value="#user.street"/></td>
			<td><s:property value="#user.city"/></td>
			<td><s:property value="#user.state"/></td>
			<td><s:property value="#user.zip"/></td>
			<td><s:a label="Update" href="%{updateUrl}"  errorText="Sorry your request had an error." preInvokeJS="confirm('Are you sure you want to delete this item?')">
			<s:label >Update</s:label>
			</s:a></td>
		 </tr>
		</s:iterator>
		
		<s:submit id="userdel" src="/contactApp/image/b_delete.gif" type="image"  ></s:submit>		 
		
		
	</table>
</s:form>

</body>
</html>
