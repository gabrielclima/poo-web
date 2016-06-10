<%@page import="modelo.dominio.Cliente"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Confirmação de Registro</title>

<style type="text/css">
.tituloCampo {
	text-align: right;
	color: blue;
}
</style>
<%
	// Candidato candidato = (Candidato) request.getAttribute("candidato");
	// if (candidato == null)
	// 	candidato = new Candidato();
%>
</head>
<body>
<jsp:useBean id="cliente" class="modelo.dominio.Cliente" scope="request"></jsp:useBean>
	<table>
		<tr>
			<td class="tituloCampo">Nome:</td>
			<td><%=cliente.getNome()%></td>
		</tr>
	</table>
	<p class="tituloCampo">Olá, gerente. O registro de <%=cliente.getNome()%> foi efetuado com sucesso.</p>
	<br>
	<br>
	<a href="exibirPainelAdmin">Voltar a Página de Administração</a>
	<br>
	<br>
</body>
</html>








