<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ taglib prefix="sb" uri="/struts-bootstrap-tags" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Checkout</title>
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
	<s:set name="url" scope="session" value="'/WEB-INF/jsp/acquisti/checkout.jsp'"/>
	
	<div class="container">
		<h3>Checkout</h3>
		
		<s:if test=" #attr.carrello == null" >
			
				<div class="alert alert-warning">
				  <strong>Nessun articolo aggiunto al carrello.</strong>
				</div>
			
				<div>
					<a href="<s:url action='goToIndex'/>"><button type="button" class="btn btn-info">Torna agli acquisti</button></a>
				</div>
			
		</s:if>
		
		<s:elseif test="#attr.currentUser == null"> 
			<div class="alert alert-warning">
			  <strong>Login necessario</strong>
			</div>
		</s:elseif>
		
		<s:else>
			<div class="row">
				<table class="table table-striped table-bordered table-condensed">
					<tr>
						<th>Articolo</th><th>Marca</th><th>Tipo</th><th>Pezzi</th><th>Prezzo</th>
					</tr>
					<s:iterator value=" #attr.carrello" var="articolo" status="stato">
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
			<br>
			<s:if test="hasActionErrors()">
		    	<div class="alert alert-danger">
					<s:fielderror fieldName="pagamento" />
				</div>
			</s:if>
				<div class="row">
					<s:if test="#attr.currentUser.metodi==null"> <!-- non funziona il controllo.. -->
						<div class="col-md-6 alert alert-danger">
							<h4>Non ci sono metodi di pagamento disponibili. Vai alla pagina utente per aggiungerne uno</h4>
						</div>
					</s:if>
					<s:else>
						<div class="row">
							<div class="col-md-3 col-md-offset-9">
								<table class="table bg-info table-condensed">
										<tr>
											<th>Totale</th><th><s:property value="#attr.totale"/> &euro; </th>
										</tr>
								</table>
							</div>
						</div>	
						
						<div class="row">	
							 <div class="col-md-3 col-md-offset-9">
								<s:form action="checkout" >
							 		<s:select name="id" list="#attr.currentUser.metodi" listKey="id" value="%{#attr.currentUser.metodi.tipo}" theme="bootstrap"></s:select>
									<s:submit value="Conferma" class="btn btn-info btn-sm"/>
								</s:form>
							 </div>
						</div>
					</s:else>
					 
				</div>	
		</s:else>
	</div><!-- fine container -->

</div>



</body>
</html>