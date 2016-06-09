<%@page import="modelo.Concurso"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Inscri��o Realizada</title>
	<link rel="stylesheet" type="text/css" href="css/estilo.css">

</head>
<body>
<jsp:useBean id="inscricao" scope="request" class="modelo.Inscricao"></jsp:useBean>
<%
	String mensagem = (String) request.getAttribute("mensagem");
	List<Concurso> lista = (List<Concurso>) request.getAttribute("lista");
	
	if (mensagem != null)
		out.println("<div style=\"color: red;\">" + mensagem + "</div>");
%>
	<div>
		<h3>Dados da Inscri��o</h3>
		<table>
			<tr>
				<td class="tituloCampo">Concurso:</td>
				<td><%=inscricao.getConcurso().getDescricao()%></td>
			</tr>
			<tr>
				<td class="tituloCampo">N� Inscri��o:</td>
				<td><%=inscricao.getNumeroInscricao()%></td>
			</tr>
			<tr>
				<td class="tituloCampo">Nome:</td>
				<td><%=inscricao.getNome()%></td>
			</tr>
			<tr>
				<td class="tituloCampo">CPF:</td>
				<td><%=inscricao.getCpf()%></td>
			</tr>
			<tr>
				<td class="tituloCampo">Data de Nascimento:</td>
				<td><%=inscricao.getNascimentoFormatado()%></td>
			</tr>
		</table>
	</div>
	<br/>
	Op��es:<br/>
	<a href="abrirPesquisa">Pesquisar outra Inscri��o</a>  <br/>
	<a href="abrirNovaInscricao">Fazer uma nova inscri��o</a> <br/>
	<a href="./">Voltar ao In�cio</a>


</body>
</html>