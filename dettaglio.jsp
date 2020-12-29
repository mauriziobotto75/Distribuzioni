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
	


		<div class="page-content-wrapper"> 
			<div class="container my_div3 pull-left" >
			<h4> Venduti</h4>
			<table class="table table-striped table-bordered table-condensed">
				<tr>
					<th>ID ordine</th><th>pezzi</th><th>data</th>
				</tr>
					<s:iterator value="venduti" var="counter">
					<tr>
						<td><s:property value="id"/></td>
						<td><s:property value="pezzi"/></td>
						<td><s:date name="timestamp"/></td>
					</tr>
						
					</s:iterator>
				</table>
				Totale venduti = <s:property value="totaleVenduti"/>	
			</div>
		</div>
 

</div>
</body>
</html>