<%@page import="java.util.List"%>
<%@page import="com.curso.spring.simpsons.front.dto.Personaje"%>
<%@page
	import="com.curso.spring.simpsons.front.services.ServicioPersonajesRemotoRestTemplate"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Listado</title>
</head>
<body>
	<div>
		<%
			for (Personaje personaje : ((List<Personaje>) request.getAttribute("resultado"))) {
		%>

		<div>${personaje.nombre }</div>
		<div>${personaje.apellido }</div>

		<%
			}
		%>
	</div>
</body>
</html>