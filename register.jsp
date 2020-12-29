<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ taglib prefix="sb" uri="/struts-bootstrap-tags" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Register</title>

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap-theme.min.css">
<link href="resources/css/mycss.css" rel="stylesheet">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
	<sb:head/>
</head>
<body>
<s:set name="url" scope="session" value="'/WEB-INF/jsp/utente/register.jsp'"/>

<div id="wrap">
	<div class="header">
		<jsp:include page="/WEB-INF/jsp/header.jsp" />
	</div>
	
	<div class="container" >
	<div class="row ">
        <div class="col-md-6 col-md-offset-1">
		<h3>Registrati</h3>
			<s:fielderror fieldName="utente" />
			<s:form action="register" theme="bootstrap">
				<s:textfield name="utente.userName" label="User Name"/>
				<s:textfield name="utente.nome" label="Nome"/>
				<s:textfield name="utente.cognome" label="Cognome"/>
				<s:password name="utente.password" label="Password" />
				<s:password name="pwd2" label="Ripeti Password" />
				<s:textfield name="utente.email" label="E-mail"/>
				<s:textfield name="indirizzo.citta" label="Città"/>
				<s:textfield name="indirizzo.strada" label="Indirizzo"/>
				<s:textfield name="indirizzo.cap" label="CAP"/>
				<s:submit value="Submit" class="btn btn-info btn-sm"/>
			</s:form>
		</div>
	</div>
		
	</div>
</div>


</body>
</html>
