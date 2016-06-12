<%@page import="java.text.SimpleDateFormat"%>
<%@page import="modelo.dominio.Cliente"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Confirmação de Alteracao de Cliente</title>

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
<a href="exibirCadastroClientes">Voltar para o cadastro de Clientes</a>
<a href="exibirPainelAdmin">Voltar a Página de Administração</a>

<p>A alteração foi feita</p>
<jsp:useBean id="cliente" class="modelo.dominio.Cliente" scope="request"></jsp:useBean>
	<table>
		<tr>
			<td class="tituloCampo">ID:</td>
			<td><%=cliente.getId()%></td>
		</tr>
		<tr>
			<td class="tituloCampo">Login:</td>
			<td><%=cliente.getLogin()%></td>
		</tr>
		
		<tr>
			<td class="tituloCampo">Nome:</td>
			<td><%=cliente.getNome()%></td>
		</tr>
		<tr>
			<td class="tituloCampo">CPF:</td>
			<td><%=cliente.getCpf()%></td>
		</tr>
		<tr>
			<td class="tituloCampo">Nascimento:</td>
			<td><%=cliente.getDataNascimento()%></td>
		</tr>
	</table>
	<br>
	<br>
	<a href="logout">Sair</a>
</body>
</html>








