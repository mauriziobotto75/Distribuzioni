<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ taglib prefix="sb" uri="/struts-bootstrap-tags" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Administration</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap-theme.min.css">
<link href="resources/css/mycss.css" rel="stylesheet">
<link href="resources/css/simple-sidebar.css" rel="stylesheet">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
	<sb:head/>
	
</head>
<body>
<s:set name="url" scope="session" value="'/WEB-INF/jsp/admin/aggiungiAdmin.jsp'"/>
<div id="wrapper">
	<div class="header">
		<jsp:include page="/WEB-INF/jsp/header.jsp" />
	</div>
	
	<div id="sidebar-wrapper">
		<s:url action="search.action" var="urlTag" >
   			<s:param name="index" value="'Elettronica'"/> 
		</s:url>
	
            <ul class="sidebar-nav">
                <li class="sidebar-brand">
                    <a href="#">
                        Admin Page
                    </a>
                </li>
                <li>
                	<a href="goToAdmin">Gestione Magazzino</a>
                </li>
                <li>
                	<a href="goToAggiungiArtic">Aggiungi articolo</a>
                </li>
                <li>
                	<s:a href="goToAggiungiAdmin">Aggiungi Amministratore</s:a>
                </li>
                
            </ul>
        </div>
   

		<div id="page-content-wrapper">
			<div class="container-fluid" >

				<div class="row">
				<div class="col-md-4 col-md-offset-2">
				<h4>Crea nuovo amministratore</h4>
				<s:if test="aggiunto!='' && aggiunto!=null ">
					<div class="alert alert-success">
						<s:property value="aggiunto"/>
					</div>
				</s:if>
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
					<s:hidden name="utente.permessi" value="true"/>
					<s:submit value="Submit" class="btn btn-info btn-sm"/>
				</s:form>
				</div>
				</div>
			</div>
	
		</div>

		
</div>
</body>
</html>