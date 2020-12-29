package utente;
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ taglib prefix="sb" uri="/struts-bootstrap-tags" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Userpage</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap-theme.min.css">
<link href="resources/css/mycss.css" rel="stylesheet">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
	<sb:head/>
	
</head>
<body>
<div id="wrap">
	<div class="header">
		<jsp:include page="/WEB-INF/jsp/header.jsp" />
	</div>
	
	<div class="container">
		<div class="row">
	        <div class="col-md-4">
	
			<h4>Dati Personali</h4>
				<table class="table table-striped table-bordered table-condensed">
					<tr>
						<td>UserName:</td><td><s:property value="#attr.currentUser.userName"/></td>
					</tr>
					<tr>
						<td>Nome:</td><td><s:property value="#attr.currentUser.nome"/></td>
					</tr>
					<tr>
						<td>Cognome:</td><td><s:property value="#attr.currentUser.cognome"/></td>
					</tr>
					<tr>
						<td>Email:</td><td><s:property value="#attr.currentUser.email"/></td>
					</tr>
					<tr>
						<td>Città:</td><td><s:property value="#attr.currentUser.indirizzo.citta"/></td>
					</tr>
					<tr>
						<td>Indirizzo:</td><td><s:property value="#attr.currentUser.indirizzo.strada"/></td>
					</tr>
					<tr>
						<td>Cap:</td><td><s:property value="#attr.currentUser.indirizzo.cap"/></td>
					</tr>
					
				</table>
				<s:form action="goToModificaUtente" theme="bootstrap">
					<s:submit value="Modifica" class="btn btn-info btn-sm"/>
				</s:form>
			</div>
		</div>
			<div class="row">	
				<div class="col-md-4">
				<h4>Metodi pagamento</h4>
				<table class="table table-striped table-bordered table-condensed">	
					<tr>
					<th>Id</th><th>Tipo</th><th>Codice</th>
					</tr>
					<s:iterator value="#attr.currentUser.metodi" var="ordine" status="status">
					<!-- <tr>
					<td colspan="2"><s:property/></td>
					</tr>  -->
					<tr>
					<td><s:property value="id"/></td><td><s:property value="tipo"/></td><td><s:property value="codice"/> </td>
					</tr>
					</s:iterator>
					
				</table>
				</div>
			
			
		
			<div class="col-md-6 col-md-offset-1">
				<div class="col-md-6 col-md-offset-2">
				<h4>Aggiungi metodo di pagamento</h4>
					<s:form action="addMetodo" theme="bootstrap">
						<s:select label="Tipo" name="tipo" list="#{'carta di credito':'carta di credito' , 'bonifico':'bonifico'}"/>
						<s:textfield name="codice" label="Codice"/>
						<s:submit value="Aggiungi" class="btn btn-info btn-sm"/>
					</s:form>
				</div>
			</div>	
		</div>
	</div>
	
	
	<br>
	<div class="container">
		<h4>Storico Ordine</h4>
		<table class="table table-striped table-bordered table-condensed">
		<tr>
			<th>ID transazione</th><th>Data</th><th>Totale</th><th>Tipo Pagamento</th><th>Codice</th><th>Id metodo pagamento</th><th>Dettaglio</th>
		</tr>
			<s:iterator value="#attr.currentUser.ordiniFin" var="ordine" status="status">
				<s:url action="showDetails.action" var="urlTag" >
   					 <s:param name="index" value="%{#status.index}"/> 
				</s:url>
			<tr>
				<td><s:property value="id"/></td>
				<td><s:date name="timestamp"/></td>
				<td><s:property value="totale"/> &euro;</td>
				<td><s:property value="metodo.tipo"/></td>
				<td><s:property value="metodo.codice"/></td>
				<td><s:property value="metodo.id"/></td>
				<td><s:a href="%{urlTag}">Visualizza dettaglio ordine</s:a></td>
			</tr>
				
			</s:iterator>
		</table>
	</div>
	
</div> <!-- wrap -->
</body>
</html>