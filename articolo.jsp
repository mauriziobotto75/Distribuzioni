package acquisti;

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ taglib prefix="sb" uri="/struts-bootstrap-tags" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Index page</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap-theme.min.css">
<link href="resources/css/mycss.css" rel="stylesheet">
<link href="resources/css/simple-sidebar.css" rel="stylesheet">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
	<sb:head/>


</head>
<body>

<div id="wrapper" >
	<div class="header">
		<jsp:include page="/WEB-INF/jsp/header.jsp" />
	</div>
	
	<div id="sidebar-wrapper">
		<s:url action="search.action" var="urlTag" >
   			<s:param name="index" value="'Elettronica'"/> 
		</s:url>
	
            <ul class="sidebar-nav">
                <li class="sidebar-brand inactiveLink">
                    <a href="#">
                        Categorie
                    </a>
                </li>
                <li>
                	<s:url action="goToCategoria.action" var="elettro" >
			   			<s:param name="categoria" value="'elettronica'"/> 
					</s:url>
                    <s:a href="%{elettro}">Elettronica</s:a>
                </li>
                <li>
                	<s:url action="goToCategoria.action" var="cancell" >
			   			<s:param name="categoria" value="'cancelleria'"/> 
					</s:url>
                    <s:a href="%{cancell}">Cancelleria</s:a>
                </li>
                <li>
                	<s:url action="goToCategoria.action" var="casal" >
			   			<s:param name="categoria" value="'casalinghi'"/> 
					</s:url>
                    <s:a href="%{casal}">Casalinghi</s:a>
                </li>
                
            </ul>
        </div>  
	
		<div id="page-content-wrapper"> 
			<div class="container-fluid articolo" style="background: #A5E6F0;">
				<div class="row" style="margin-top: 50px;">
				  	<s:set var="baseUrl">${pageContext.request.contextPath}/image/</s:set>
					<s:set var="imgUrl" value="%{#baseUrl + magazzino.articolo.img}"/>
				
				    <div class="col-md-4"><div class="well text-center"><img src="${imgUrl}" class="img-thumbnail my_img"/><br/><br/></div></div>
				    <div class="col-md-8">
					    <div class="row">
						        <div class="col-md-6"><div class="well well-sm">Articolo: <s:property value="%{magazzino.articolo.nome}"/></div></div>
						        <div class="col-md-6"><div class="well well-sm">Quantità disp. <s:property value="%{magazzino.pezzi}"/></div></div>
						</div>
					    <div class="row">
						        <div class="col-md-6"><div class="well well-sm">Produttore: <s:property value="%{magazzino.articolo.marca}"/></div></div>
						        <div class="col-md-6"><div class="well well-sm">Prezzo: <s:property value="%{magazzino.articolo.prezzo}"/> &euro;</div></div>
						</div>
						<div class="row">
					    	<div class="col-md-6">
					        	<div class="well well-sm">Tipo: <s:property value="%{magazzino.articolo.tipo}"/><br> </div>
					    	</div>
					    	<div class="col-md-6">
					    	<s:if test="magazzino.pezzi>0">
							    <div class="well well-sm text-center"> 
							    	<form action="addToCart">
								        <s:hidden name="id" value="%{magazzino.articolo.id}"/> 
								       	<s:select name="pezzi" list="#{1:1, 2:2, 3:3, 4:4, 5:5, 10:10, 25:25}"/>
									 	<s:submit value="Aggiungi" class="btn btn-info btn-sm"/>
									 	<s:token />
									 </form>
							    </div>
							</s:if>
							<s:else>
								<div class="well well-sm alert alert-danger">Articolo non disponibile</div>
							</s:else>
							</div>
						</div>
				    </div>
				</div>
				<br>
			</div>
		</div>
</div>
</body>
</html>