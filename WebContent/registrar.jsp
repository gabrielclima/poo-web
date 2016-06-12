<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Registrar Usuário</title>

<style type="text/css">
.tituloCampo {
	text-align: right;
	color: blue;
}
</style>

</head>
<%
	String mensagem = (String) request.getAttribute("mensagem");
	if (mensagem != null)
		out.println("<h3>" + mensagem + "</h3>");
%>
<body>
	<form action="salvarUsuario" method="post" onsubmit="return validar()">
		<table>
			<tr>
				<td class="tituloCampo">Login:</td>
				<td><input type="text" name="login" size="30" maxlength="80"></td>
			</tr>
			<tr>
				<td class="tituloCampo">Nome Completo:</td>
				<td><input type="text" name="nome" size="11" maxlength="11"></td>
			</tr>
			<tr>
				<td class="tituloCampo">Senha:</td>
				<td><input type="text" name="senha" size="10" maxlength="10"></td>
			</tr>
			<tr>
				<td class="tituloCampo">Senha:</td>
				<td><input type="text" name="senhaConf" size="10" maxlength="10"></td>
			</tr>
			<tr>
				<td class="tituloCampo">CPF:</td>
				<td><input type="text" name="cpf" size="30" maxlength="80"></td>
			</tr>
			<tr>
				<td class="tituloCampo">Data Nascimento:</td>
				<td><input type="text" name="dataNascimento" size="30" maxlength="80"></td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" value="Enviar"></td>
			</tr>
		</table>
	</form>
</body>
</html>








