<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ taglib prefix="sb" uri="/struts-bootstrap-tags" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap-theme.min.css">
<link href="resources/css/mycss.css" rel="stylesheet">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
<title>Carrello</title>
	<sb:head/>
</head>
<body>

<div id="wrap">
	<div class="header">
		<jsp:include page="/WEB-INF/jsp/header.jsp" />
	</div>
	
	<s:set name="url" scope="session" value="'/WEB-INF/jsp/acquisti/carrello.jsp'"/>
	
	<div class="container">
	<h3>Carrello</h3>
		<s:if test=" #attr.carrello == null">
			<div class="alert alert-warning">
				  <strong>Nessun articolo aggiunto al carrello.</strong>
				</div>
		</s:if>
		<s:else>
		<div class="row">
			<div class="col-md-12">
				<table class="table table-striped table-bordered table-condensed">
				<tr>
					<th>Articolo</th><th>Marca</th><th>Tipo</th><th>Pezzi</th><th>Prezzo</th><th>Modifica</th><th>Rimuovi</th>
				</tr>
					<s:iterator value=" #attr.carrello" var="ordine" status="stato">
						<s:url action="removeFromCart.action" var="urlTag" >
		   					 <s:param name="index" value="%{#stato.index}"/> 
		   					 <s:param name="id" value="%{articolo.id}"/>
						</s:url>
						<tr>
							<td><s:property value="%{articolo.nome}"/></td>
							<td><s:property value="%{articolo.marca}"/></td>
							<td><s:property value="%{articolo.tipo}"/></td>
							<td><s:property value="%{pezzi}"/></td>
							<td><s:property value="%{articolo.prezzo}"/> &euro;</td>
							<td>
								<s:form action="updateOrdine">
									<s:hidden name="id" value="%{id}"/> <!-- ordine ID!! -->
								    <s:hidden name="index" value="%{#stato.index}"/>
								    <s:select name="pezziUp" list="#{1:1, 2:2, 3:3, 4:4, 5:5, 10:10, 25:25}"/>
									<s:submit value="Modifica" class="btn btn-info btn-sm"/>
								</s:form>
							</td>
							<td><s:a href="%{urlTag}">Rimuovi Articolo</s:a></td>
						</tr>
					</s:iterator>
					
				</table>
			</div>
		</div>	
		<div class="row">
			<div class="col-md-3 col-md-offset-9">
				<table class="table bg-info table-condensed">
					<tr>
						<th>Totale</th><th><s:property value="#attr.totale"/> &euro; </th>
					</tr>
				</table>
			</div>
		</div>		
		</s:else>
		
		<div class="row">
			<div class="col-md-2">
				<a href="<s:url action='goToIndex'/>"><button type="button" class="btn btn-info">Torna agli acquisti</button></a>
			</div>
			<div class="col-md-2 pull-right">
				<s:if test="#attr.carrello!=null">
					<a href="<s:url action='goToCheckout'/>"><button type="button" class="btn btn-info pull-right">Vai al Checkout</button></a>
				</s:if>
			</div>
		</div>
	</div>
	
	<br>
	<div class="container my_div2">
		<s:if test="#attr.nonDisponibili!=null">
				
				<div class="container alert alert-danger">
				<div class="alert alert-danger">
					<h4>Attenzione. Alcuni articoli presenti nel carrello non sono disponibili nella quantità richiesta</h4>
				</div>
				<br>
					<table class="table table-striped table-bordered table-condensed table-hover">
						<tr>
							<th>Articolo</th><th>Marca</th><th>Tipo</th><th>Pezzi disponibili</th><th>Prezzo</th>
						</tr>
						<s:iterator value="#attr.nonDisponibili" var="magazzino" status="stato">
							<tr>
								<td><s:property value="%{articolo.nome}"/></td>
								<td><s:property value="%{articolo.marca}"/></td>
								<td><s:property value="%{articolo.tipo}"/></td>
								<td><s:property value="%{pezzi}"/></td>
								<td><s:property value="%{articolo.prezzo}"/> &euro;</td>
							</tr>
						</s:iterator>
					</table>
				</div>
			</s:if>
	</div>
		
</div>
</body>
</html>