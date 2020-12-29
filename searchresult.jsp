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



<!-- Wrap all page content here -->
<div id="wrapper" >
	<div class="header">
		<jsp:include page="/WEB-INF/jsp/header.jsp" />
	</div>
	<s:set name="url" scope="session" value="'/WEB-INF/jsp/acquisti/searchresult.jsp'"/>
	
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
			   			<s:param name="next" value="0"/>
					</s:url>
                    <s:a href="%{elettro}">Elettronica</s:a>
                </li>
                <li>
                	<s:url action="goToCategoria.action" var="cancell" >
			   			<s:param name="categoria" value="'cancelleria'"/> 
			   			<s:param name="next" value="0"/>
					</s:url>
                    <s:a href="%{cancell}">Cancelleria</s:a>
                </li>
                <li>
                	<s:url action="goToCategoria.action" var="casal" >
			   			<s:param name="categoria" value="'casalinghi'"/> 
			   			<s:param name="next" value="0"/>
					</s:url>
                    <s:a href="%{casal}">Casalinghi</s:a>
                </li>
                
            </ul>
        </div>
	
	<div id="page-content-wrapper">
	
		 
   
	
	<s:if test="#attr.magazzinoList == null"><h4>Nessun articolo trovato.</h4></s:if>
	<s:else><h4>Risulato Ricerca:</h4>
		<div class="text-center">
			 	<form action="orderBy"> 
	    		<s:select name="orderCat" list="#{1:'nome', 2:'marca',3:'tipo', 4:'prezzo'}"/>
		       	<s:select name="orderVal" list="#{1:'order by asc', 2:'order by desc'}"/>
		       	<s:hidden name="page" value="2"/>
			 	<s:submit value="Ordina" class="btn btn-info btn-sm"/>
			 </form>
    </div>
    </s:else>
	<s:if test="aggiunto!='' && aggiunto!=null ">
		<div class="alert alert-success">
			<s:property value="aggiunto"/>
		</div>
	</s:if>
	
	
	<s:iterator value="#attr.magazzinoList" var="magazzino" status="counter">
		<s:url action="showArticolo.action" var="urlTag" >
				 <s:param name="id" value="%{articolo.id}"/>
		</s:url>
		<s:if test="pezzi >=0">
			<div class="container-fluid articolo">
				<div class="row" style="margin-top: 50px;">
					<s:set var="baseUrl">${pageContext.request.contextPath}/image/</s:set>
					<s:set var="imgUrl" value="%{#baseUrl + articolo.img}"/>
				
				    <div class="col-md-4"><div class="well text-center"><s:a href="%{urlTag}"><img src="${imgUrl}" class="img-thumbnail my_img"/></s:a><br/><br/></div></div>
				    <div class="col-md-8">
					    <div class="row">
						        <div class="col-md-6"><div class="well well-sm">Articolo: <s:property value="%{articolo.nome}"/></div></div>
						        <div class="col-md-6"><div class="well well-sm">Quantità disp. <s:property value="%{pezzi}"/></div></div>
						</div>
					    <div class="row">
						        <div class="col-md-6"><div class="well well-sm">Produttore: <s:property value="%{articolo.marca}"/></div></div>
						        <div class="col-md-6"><div class="well well-sm">Prezzo: <s:property value="%{articolo.prezzo}"/> &euro;</div></div>
						</div>
						<div class="row">
					    	<div class="col-md-6">
					        	<div class="well well-sm">Tipo: <s:property value="%{articolo.tipo}"/><br> </div>
					    	</div>
					    	<div class="col-md-6">
							    <s:if test="pezzi>0">
								    <div class="well well-sm text-center"> 
								    	<form action="addToCart">
									        <s:hidden name="id" value="%{articolo.id}"/> 
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
		</s:if>
	</s:iterator>
	
	</div>
	
	<!-- paginazione -->

	
	<!-- paginazione -->
	<div>
	  <ul class="pagination">
	  	<s:if test="#attr.counter > 1">
	  		<s:url action="search.action" var="nextPage" >
				   <s:param name="next" value="-1"/> 
			</s:url>
	     <li><s:a href="%{nextPage}">Prev</s:a> </li>
	     
	     <!-- counter -1 -->
		    <li>
		    	<s:url action="search.action" var="nextPage" >
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
	    <s:url action="search.action" var="nextPage" >
				   <s:param name="next" value="1"/> 
			</s:url>
	                    <s:a href="%{nextPage}"><s:property value="%{#attr.counter+1}"/></s:a>
	    </li> 
	    
	    	<s:url action="search.action" var="nextPage" >
				   <s:param name="next" value="1"/> 
			</s:url> 
	        <li><s:a href="%{nextPage}">Next</s:a></li>
	    </s:if>
	  </ul>
	</div>

</div> <!-- wrap -->
<!-- 
 <script>
    $("#menu-toggle").click(function(e) {
        e.preventDefault();
        $("#wrapper").toggleClass("toggled");
    });
    </script>  -->

</body>
</html>