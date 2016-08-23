<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login Information</title>
<script type="text/javascript">

	
</script>
</head>
<body>
<s:form action="welcome" >
<s:textfield id="uid" label="Login Id" key="username" />
<s:password id="pwd" label="Password" key="password"/>
<s:submit value="Submit"/>
</s:form>
</body>
</html>
