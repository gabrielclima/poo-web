<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@page import="modelo.dominio.Gerente"%>
<%@page import="java.util.List"%>
<%@page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cadastro de Gerentes</title>
</head>
<body>
	<h3>Cadastro de Gerentes</h3>
	Opções: <a href="abrirCadastro">Incluir</a>
	
	<br>
	<br>
	Lista de Gerentes:
	<table cellpadding="5" cellspacing="0" border="1">
		<tr>
			<td>Opções</td>
			<td>Id</td>
			<td>Nome Gerente</td>
			<td>CPF</td>
			<td>Data Nascimento</td>
		</tr>
<%
	List<Gerente> lista = (List<Gerente>) request.getAttribute("lista");
	if (lista != null)
	{
		for (Gerente gerente: lista)
		{
%>
		<tr>
			<td><a href="alterarCadastroGerente?id=<%=gerente.getId()%>">Alterar</a><br>
				<a href="excluirGerente?id=<%=gerente.getId()%>">Excluir</a>
			</td>
			<td><%=gerente.getId()%></td>
			<td><%=gerente.getNome()%></td>
			<td><%=gerente.getCpf()%></td>
			<td><%=gerente.getDataNascimento()%></td>
		</tr>
<%
		}
	}
%>
	</table>
	<a href="exibirPainelAdmin">Voltar a Página de Administração</a>
	<br>
	<br>
	<a href="logout">Sair</a>
	
</body>
</html>












	