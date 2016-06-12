<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>AUTENTICAÇÃO</title>

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
	if (f.login.value == '')
	{
		alert('O campo LOGIN não foi preenchido.');
		f.login.focus();
		return false;
	}
	else if (f.senha.value == '')
	{
		alert('O campo SENHA não foi preenchido.');
		f.senha.focus();
		return false;
	}
	return true;
}
</script>
</head>
<%
	String mensagem = (String) request.getAttribute("mensagem");
	if (mensagem != null)
		out.println("<h3>" + mensagem + "</h3>");
%>
<body>
	<form action="autenticar" method="post" onsubmit="return validar()">
		<table>
			<tr>
				<td class="tituloCampo">Login:</td>
				<td><input type="text" name="login" value="" size="30" maxlength="80" placeholder="Usuário"></td>
			</tr>
			<tr>
				<td class="tituloCampo">Senha:</td>
				<td><input type="password" name="senha" value="" size="30" maxlength="80" placeholder="Senha"></td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" value="Enviar"></td>
			</tr>
		</table>
	</form>
</body>
</html>








