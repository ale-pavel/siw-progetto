<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml"
	xmlns:f="http://java.sun.com/jsf/core"
	xmlns:h="http://java.sun.com/jsf/html">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<link rel="stylesheet" href="bootstrap.min.css" />
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>charset=ISO-8859-1" />
<title>Autore Inserito</title>
</head>
<body>
	<div class="container">
		<!-- Static navbar -->
		<nav id="navMenu" class="navbar navbar-default"><script src="navBar.js"></script></nav>
		<f:view>
	Nome:${autoreController.nome}
	Cognome:${autoreController.cognome}
	Nazionalita:${autoreController.nazionalita}
	Data di nascita:${autoreController.dataNascita}
	Data di morte:${autoreController.dataMorte}
</f:view>
	</div>
</body>
</html>