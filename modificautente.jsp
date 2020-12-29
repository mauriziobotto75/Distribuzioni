<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ taglib prefix="sb" uri="/struts-bootstrap-tags" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Modifica dati utente</title>

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap-theme.min.css">
<link href="resources/css/mycss.css" rel="stylesheet">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
	<sb:head/>
</head>
<body>
<!--<s:set name="url" scope="session" value="'/WEB-INF/jsp/utente/register.jsp'"/> -->

<div id="wrap">
	<div class="header">
		<jsp:include page="/WEB-INF/jsp/header.jsp" />
	</div>
	
	<div class="container" >
	<div class="row ">
        <div class="col-md-6 col-md-offset-1">
		<h3>Modifica Dati personali</h3>
			<s:fielderror fieldName="utente" />
			<s:form action="modificaUtente" theme="bootstrap">
				<s:textfield name="utente.userName" label="User Name" value="%{#attr.currentUser.userName}"/>
				<s:textfield name="utente.nome" label="Nome" value="%{#attr.currentUser.nome}"/>
				<s:textfield name="utente.cognome" label="Cognome" value="%{#attr.currentUser.cognome}"/>
				<s:password name="utente.password" label="Password" value="%{#attr.currentUser.password}" />
				<s:password name="pwd2" label="Ripeti Password" value="%{#attr.currentUser.password}"/>
				<s:textfield name="utente.email" label="E-mail" value="%{#attr.currentUser.email}"/>
				<s:textfield name="indirizzo.citta" label="Città" value="%{#attr.currentUser.indirizzo.citta}"/>
				<s:textfield name="indirizzo.strada" label="Indirizzo" value="%{#attr.currentUser.indirizzo.strada}"/>
				<s:textfield name="indirizzo.cap" label="CAP" value="%{#attr.currentUser.indirizzo.cap}"/>
				<s:submit value="Modifica" class="btn btn-info btn-sm"/>
			</s:form>
		</div>
	</div>
		
	</div>
</div>


</body>
</html>