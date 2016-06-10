<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@page import="modelo.dominio.Cliente"%>
<%@page import="java.util.List"%>
<%@page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cadastro de Clientes</title>
</head>
<body>
	<h3>Cadastro de Clientes</h3>
	Opções: <a href="abrirCadastroCliente">Incluir</a>
	<br>
	<br>
	Lista de Clientes:
	<table cellpadding="5" cellspacing="0" border="1">
		<tr>
			<td>Opções</td>
			<td>Id</td>
			<td>Nome Gerente</td>
			<td>CPF</td>
			<td>Data Nascimento</td>
		</tr>
<%
	List<Cliente> lista = (List<Cliente>) request.getAttribute("lista");
	if (lista != null)
	{
		for (Cliente cliente: lista)
		{
%>
		<tr>
			<td><a href="alterarCadastroCliente?id=<%=cliente.getId()%>">Alterar</a><br>
				<a href="excluirCliente?id=<%=cliente.getId()%>">Excluir</a>
			</td>
			<td><%=cliente.getId()%></td>
			<td><%=cliente.getNome()%></td>
			<td><%=cliente.getCpf()%></td>
			<td><%=cliente.getDataNascimento()%></td>
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












	