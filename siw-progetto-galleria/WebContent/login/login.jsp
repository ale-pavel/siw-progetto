<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml"
	xmlns:f="http://java.sun.com/jsf/core"
	xmlns:h="http://java.sun.com/jsf/html">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<link rel="stylesheet" href="../bootstrap.min.css"/>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<style type="text/css">
input[type=text], input[type=password] {
	display: block;
}
</style>
<title>Login Amministratore</title>
</head>
<body>
	<f:view>
		<h1>Effettuare il login</h1>
		<p>Inserire le credenziali di amministratore per procedere.</p>
		<form action="j_security_check" method="post" name="loginForm">
			<label for="user">Username:</label> 
			<input id="user" type="text" name="j_username" size="20"/> 
			<label for="password">Password</label>
			<input id="password" type="password" name="j_password" size="20"/>
			<input type="submit" value="Login"/>
		</form>
	</f:view>
</body>
</html>