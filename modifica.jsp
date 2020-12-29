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
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
	<sb:head/>
	
</head>
<body>

<div id="wrapper">
	<div class="header">
		<jsp:include page="/WEB-INF/jsp/header.jsp" />
	</div>
	
	<div id="sidebar-wrapper">
		<ul class="sidebar-nav">
                <li class="sidebar-brand inactiveLink">
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
				<h4> Modifica Articolo</h4>
				<s:form action="modificaArticolo" method="post" enctype="multipart/form-data" theme="bootstrap">
						<s:hidden value="%{id}" name="id"/>
						<s:textfield name="articolo.nome" label="Nome" value="%{nome}" /> 
						<s:textfield name="articolo.marca" label="Marca" value="%{marca}"/>
						<s:select label="Tipo" name="articolo.tipo" list="#{'elettronica':'elettronica' , 'cancelleria':'cancelleria' , 'casalinghi':'casalinghi'}"/>
						<s:textfield name="articolo.prezzo" label="Prezzo" value="%{prezzo}"/>
						<s:file label="File" name="file"></s:file>
						<br>
						<s:submit value="Modifica" class="btn btn-info btn-sm"/>
						<s:token />
					</s:form>
				</div>
				<div class="row">
					<div class="col-md-3">
						<s:if test="modificato!='' && modificato!=null ">
							<div class="alert alert-success">
								<s:property value="modificato"/>
							</div>
						</s:if>
					</div>
				</div>
			</div>
		
		
		</div>
</div>

		

</body>
</html>