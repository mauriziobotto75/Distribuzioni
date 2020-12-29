<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ taglib prefix="sb" uri="/struts-bootstrap-tags" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap-theme.min.css">
<link href="resources/css/mycss.css" rel="stylesheet">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
	<sb:head/>
	
</head>
<body>
<div id="wrap">
	<div class="header">
		<jsp:include page="/WEB-INF/jsp/header.jsp" />
	</div>
	
	<div class="container">
		<strong><h4>Login</h4></strong>
		<s:form action="login">
			<s:textfield name="userName" label="User Name" theme="bootstrap"/>
			<s:password name="password" label="Password" theme="bootstrap" />
			<s:submit value="Login"/><br>
		</s:form>
		
		<s:form action="goToRegister">
			<s:submit value="Registrati"></s:submit>
		</s:form>
	</div>
</div>
</body>
</html>