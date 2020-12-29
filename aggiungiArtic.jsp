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
				<h4> Inserisci nuovo articolo</h4>
				<s:fielderror fieldName="articoloPresente" />
				<s:fielderror fieldName="fileUpload" />
					<s:form action="insert" method="post" enctype="multipart/form-data" theme="bootstrap"> 
						<s:textfield name="articolo.nome" label="Nome" value="" /> 
						<s:textfield name="articolo.marca" label="Marca" value=""/>
						<!--<s:textfield name="articolo.tipo" label="Tipo" value=""/> -->
						<s:select label="Tipo" name="articolo.tipo" list="#{'elettronica':'elettronica' , 'cancelleria':'cancelleria' , 'casalinghi':'casalinghi'}"/>
						<s:textfield name="articolo.prezzo" label="Prezzo" value="0.0"/>
						<s:textfield name="pezzi" label="Numero Pezzi" value="0"/>
						<s:file label="File" name="file"></s:file>
						<br>
						<s:submit value="Aggiungi" class="btn btn-sm"/>
						<s:token />
					</s:form>
				</div>
				</div>
			</div>
	
		</div>

		
</div>
</body>
</html>