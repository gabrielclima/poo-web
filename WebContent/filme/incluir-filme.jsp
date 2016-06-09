<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Inclusão</title>

<style type="text/css">
.tituloCampo {
	text-align: right;
	color: blue;
}
</style>

<jsp:useBean id="filme" class="modelo.dominio.Filme" scope="request"></jsp:useBean>
</head>
<%
	String mensagem = (String) request.getAttribute("mensagem");
	if (mensagem != null)
		out.println("<h3>" + mensagem + "</h3>");
%>
<body>
	<form action="salvarFilme" method="post" onsubmit="return validar()">
		<table>
			<tr>
				<td class="tituloCampo">Nome:</td>
				<td><input type="text" name="nomeFilme" size="30" maxlength="80" placeholder="Nome do Filme"></td>
			</tr>
			<tr>
				<td class="tituloCampo">Descrição:</td>
				<td><input type="text" name="descricao" size="11" maxlength="11" placeholder="Descrição do Filme"></td>
			</tr>
			<tr>
				<td class="tituloCampo">Lançamento:</td>
				<td><input type="text" name="data" size="10" maxlength="10" placeholder="Lançamento do Filme"></td>
			</tr>
			<tr>
				<td class="tituloCampo">Categoria:</td>
				<td><input type="text" name="categoria" size="30" maxlength="80"  placeholder="Categoria do Filme"></td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" value="Enviar"></td>
			</tr>
		</table>
	</form>
</body>
</html>








