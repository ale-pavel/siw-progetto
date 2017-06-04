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
<title>Inserisci Autore</title>
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
					<li><a href="faces/inserimentoQuadro.jsp">Inserimento
							Quadro</a></li>
					<li class="active"><a href="faces/inserimentoAutore.jsp">Inserimento Autore</a></li>

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
					Nome:
					<h:inputText value="#{autoreController.nome}" />
				</div>
				<div>
					Cognome:
					<h:inputText value="#{autoreController.cognome}" />
				</div>
				<div>
					Nazionalita:
					<h:inputText value="#{autoreController.nazionalita}" />
				</div>
				<div>
					Data di nascita:
					<h:inputText value="#{autoreController.dataNascita}" />
				</div>
				<div>
					Data di morte:
					<h:inputText value="#{autoreController.dataMorte}" />
				</div>
				<div>
					<h:commandButton value="Submit"
						action="#{autoreController.inserisciAutore}" />
				</div>
			</h:form>
		</f:view>
	</div>
</body>
</html>