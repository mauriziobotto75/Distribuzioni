<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="/struts-tags" prefix="s"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="resources/css/bootstrap.css" rel="stylesheet">
<link href="resources/css/mycss.css" rel="stylesheet">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
<title>Acquisto Completato</title>
</head>
<body>

<div id="wrap">
	<div class="container">
		<div class="header">
			<jsp:include page="/WEB-INF/jsp/header.jsp" />
		</div>
		<div class="alert alert-success">
		  <strong>Transazione avvenuta con successo!</strong> <br>
		  Id transazione: <s:property value="ordineFin.id"/>, <s:property value="ordineFin.metodo"/>,
		  Totale: <s:property value="ordineFin.totale"/>&euro;<br>
		  Spedizione: <s:property value="ordineFin.utente.indirizzo"/>
		</div>
		<a href="<s:url action='goToIndex'/>"><button type="button" class="btn btn-info">Torna all'Index</button></a>
	</div>

</div>


</body>
</html>