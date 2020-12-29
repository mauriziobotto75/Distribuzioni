
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
<s:set name="url" scope="session" value="'/WEB-INF/jsp/admin/administration.jsp'"/>

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
			<h4>Gestione Magazzino</h4>
			<div class="container-fluid text-center" > 
		    	<form action="orderBy"> 
		    		<s:select name="orderCat" list="#{1:'nome', 2:'marca',3:'tipo', 4:'prezzo', 5:'id'}"/>
			       	<s:select name="orderVal" list="#{1:'order by asc', 2:'order by desc'}"/>
				 	<s:submit value="Ordina" class="btn btn-info btn-sm"/>
				 </form>
		    </div>
		    <br>
			<table class="table table-striped table-bordered table-condensed">
				<tr>
					<th>ID</th><th>Nome</th><th>Marca</th><th>Tipo</th><th>Prezzo</th><th>Pezzi</th><th>Aggiungi</th><th>Rimuovi da magazzino</th><th>Dettagli</th><th>Modifica</th>
				</tr>
				<s:iterator value="#attr.magazzinoList" var="count">
					<tr>
						<td><s:property value="articolo.id"/></td>
						<td><s:property value="articolo.nome"/></td>
						<td><s:property value="articolo.marca"/></td>
						<td><s:property value="articolo.tipo"/></td>
						<td><s:property value="articolo.prezzo"/></td>
						<td><s:property value="pezzi"/></td>
						<td><s:form action="updateMagazzino" class="form-inline pull-left">
							  	<s:hidden name="id" value="%{articolo.id}"/>
							  	<s:select name="add" list="#{1:1, 5:5 , 10:10 , 25:25 , 50:50}"/>
								<s:submit value="Aggiungi" class="btn btn-info btn-sm" />
								<s:token />
							</s:form>
						</td>
						<td>
							<s:form action="deleteFromMagazzino" class="pull-left">
								<s:hidden name="id" value="articolo.id"/>
							  	<s:submit value="Rimuovi" class="btn btn-info btn-sm" />
							  	<s:token />
							</s:form>
						</td>
						<td>
							<s:url action="articoloDetails.action" var="details" >
					   			<s:param name="id" value="%{articolo.id}"/> 
							</s:url>
		                    <s:a href="%{details}">Dettagli</s:a>
						</td>
						<td>
							<s:url action="goToModifica.action" var="modifica" >
					   			<s:param name="id" value="%{articolo.id}"/> 
					   			<s:param name="nome" value="%{articolo.nome}"/>
					   			<s:param name="marca" value="%{articolo.marca}"/>
					   			<s:param name="tipo" value="%{articolo.tipo}"/>
					   			<s:param name="prezzo" value="%{articolo.prezzo}"/>
					   			<s:param name="img" value="%{articolo.img}"/>
							</s:url>
		                    <s:a href="%{modifica}">Modifica</s:a>
						</td>
					</tr>
					
				</s:iterator>
			</table>	
		</div>
		
	
     
 	<div>
	  <ul class="pagination">
	  	<s:if test="#attr.counter > 1">
	  		<s:url action="showNextPage.action" var="nextPage" >
				   <s:param name="next" value="-1"/> 
			</s:url>
	     <li><s:a href="%{nextPage}">Prev</s:a> </li>
	     
	     <!-- counter -1 -->
		    <li>
		    	<s:url action="showNextPage.action" var="nextPage" >
					   <s:param name="next" value="-1"/> 
				</s:url>
		                    <s:a href="%{nextPage}"><s:property value="%{#attr.counter-1}"/></s:a>
		    </li>
	    </s:if>
	
	    
	    <!-- counter -->
	    <li class="active">
	    	 <a href="#"><s:property value="#attr.counter"/></a>
	    </li> <!-- +1 a counter -->	
	    
	    
	    <s:if test="#attr.counter < #attr.limite">
	    
	    <!-- counter +1 -->
	    <li>
	    <s:url action="showNextPage.action" var="nextPage" >
				   <s:param name="next" value="1"/> 
			</s:url>
	                    <s:a href="%{nextPage}"><s:property value="%{#attr.counter+1}"/></s:a>
	    </li> 
	    
	    	<s:url action="showNextPage.action" var="nextPage" >
				   <s:param name="next" value="1"/> 
			</s:url> 
	        <li><s:a href="%{nextPage}">Next</s:a></li>
	    </s:if>
	  </ul>
	</div>
		
	</div>
 
	

</div>
</body>
</html>