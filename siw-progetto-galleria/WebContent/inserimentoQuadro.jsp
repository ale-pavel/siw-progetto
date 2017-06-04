<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<link rel="stylesheet" href="bootstrap.min.css" />
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<title>Inserisci Quadro</title>
</head>
<body>
	<div class="container">
		<nav class="navbar navbar-default">
		<div class="container-fluid">
			<div class="navbar-header">

				<a class="navbar-brand" href="#">Galleria</a>
			</div>
			<div id="navbar" class="navbar-collapse collapse">
				<ul class="nav navbar-nav">
					<li><a href="faces/indexAdmin.jsp">Home</a></li>
					<li class="active"><a href="faces/inserimentoQuadro.jsp">Inserimento
							Quadro</a></li>
					<li><a href="faces/inserimentoAutore.jsp">Inserimento Autore</a></li>

				</ul>
				<ul class="nav navbar-nav navbar-right">
					<li><a href="#">Profilo</a></li>
				</ul>
			</div>
		</div>
		</nav>
		<f:view>
			<h:form>
				<div>
					Titolo:
					<h:inputText value="#{quadroController.titolo}" required="true"/>
				</div>
				<div>
					Anno:
					<h:inputText value="#{quadroController.anno}" required="true"/>
				</div>
				<div>
					Dimensioni:
					<h:inputText value="#{quadroController.dimensioni}" required="true"/>
				</div>
				<div>
					Tecnica:
					<h:inputText value="#{quadroController.tecnica}" required="true"/>
				</div>
				<div>
					<h:commandButton value="Submit"
						action="#{quadroController.inserisciQuadro}" />
				</div>
			</h:form>
		</f:view>
	</div>
</body>
</html>