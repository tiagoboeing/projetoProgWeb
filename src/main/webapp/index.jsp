<%@ page language="java" import="java.util.*, java.text.*"
	contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<?xml version="1.0" encoding="UTF-8" ?>

<!-- <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd"> -->
<!DOCTYPE html>

<html xmlns="http://www.w3.org/1999/xhtml"
	xmlns:h="http://xmlns.jcp.org/jsf/html"
	xmlns:p="http://primefaces.org/ui"
	xmlns:f="http://xmlns.jcp.org/jsf/core">

<h:head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
	<title>Projeto - Programação Web</title>

	<meta name="viewport"
		content="width=device-width, initial-scale=1, shrink-to-fit=no" />

	<link rel="stylesheet" type="text/css" href="css/estilo.css" />

	<!-- GOOGLE FONTS -->
	<link
		href="https://fonts.googleapis.com/css?family=Open+Sans|Oswald|Roboto|Roboto+Slab"
		rel="stylesheet" />

	<!-- IMPORTA BOOTSTRAP -->
	<link rel="stylesheet"
		href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/css/bootstrap.min.css"
		integrity="sha384-/Y6pD6FV/Vv2HJnA6t+vslU6fwYXjCFtcEpHbNJ0lyAFsXTsjBbfaDjzALeQsN6M"
		crossorigin="anonymous" />

	<!-- FONT-AWESOME -->
	<script src="https://use.fontawesome.com/73e4bfdca5.js"></script>

</h:head>

<h:body>

	<!-- TOPO DA PÁGINA -->
	<%@ include file="pages/parts/header.xhtml" %>

	<!-- conteúdo -->
	<%@ include file="pages/paginas.jsp" %>
	

	<!-- Bibliotecas Bootstrap -->
	<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
		type="text/javascript"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.11.0/umd/popper.min.js"
		type="text/javascript"></script>
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/js/bootstrap.min.js"
		type="text/javascript"></script>

</h:body>
</html>