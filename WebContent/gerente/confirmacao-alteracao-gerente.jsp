<%@page import="java.text.SimpleDateFormat"%>
<%@page import="modelo.dominio.Gerente"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Confirmação de Alteracao de Gerente</title>

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
<a href="exibirCadastroGerente">Voltar para o cadastro de Gerentes</a>
<a href="exibirPainelAdmin">Voltar a Página de Administração</a>

<p>A alteração foi feita</p>
<jsp:useBean id="gerente" class="modelo.dominio.Gerente" scope="request"></jsp:useBean>
	<table>
		<tr>
			<td class="tituloCampo">Login:</td>
			<td><%=gerente.getLogin()%></td>
		</tr>
		<tr>
			<td class="tituloCampo">Nome:</td>
			<td><%=gerente.getNome()%></td>
		</tr>
		<tr>
			<td class="tituloCampo">CPF:</td>
			<td><%=gerente.getCpf()%></td>
		</tr>
		<tr>
			<td class="tituloCampo">Data Nascimento:</td>
			<td><%=gerente.getDataNascimento()%></td>
		</tr>
	</table>
</body>
</html>








