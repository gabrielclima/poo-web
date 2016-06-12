<%@page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Alteração em Cliente</title>

<style type="text/css">
.tituloCampo {
	text-align: right;
	color: blue;
}
</style>

<script type="text/javascript">
function validar()
{
	var f = document.forms[0];
	if (f.nome.value == '')
	{
		alert('O campo NOME não foi preenchido.');
		f.nome.focus();
		return false;
	}
	else if (f.cpf.value == '')
	{
		alert('O campo CPF não foi preenchido.');
		f.cpf.focus();
		return false;
	}
	return true;
}
</script>
<jsp:useBean id="cliente" class="modelo.dominio.Cliente" scope="request"></jsp:useBean>
</head>
<%
	String mensagem = (String) request.getAttribute("mensagem");
	if (mensagem != null)
		out.println("<h3>" + mensagem + "</h3>");
%>
<body>
	<form action="alterarCliente" method="post" onsubmit="return validar()">
		<table>
			<tr>
				<td class="tituloCampo">Id:</td>
				<td><input type="text" name="id" value='<jsp:getProperty property="id" name="cliente"/>' size="30" maxlength="80"></td>
			</tr>
			<tr>
				<td class="tituloCampo">Login:</td>
				<td><input type="text" name="login" value='<jsp:getProperty property="login" name="cliente"/>' size="30" maxlength="80"></td>
			</tr>
			<tr>
				<td class="tituloCampo">Nome:</td>
				<td><input type="text" name="nome" value='<jsp:getProperty property="nome" name="cliente"/>' size="11" maxlength="11"></td>
			</tr>
			<tr>
				<td class="tituloCampo">CPF:</td>
				<td><input type="text" name="cpf" value='<jsp:getProperty property="cpf" name="cliente"/>' size="10" maxlength="10"></td>
			</tr>
			<tr>
				<td class="tituloCampo">Data Nascimento:</td>
				<td><input type="text" name="dataNascimento" value='<jsp:getProperty property="dataNascimento" name="cliente"/>' size="30" maxlength="80"></td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" value="Enviar"></td>
			</tr>
		</table>
	</form>
	<br>
	<br>
	<a href="logout">Sair</a>
</body>
</html>








