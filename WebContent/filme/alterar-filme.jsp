<%@page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>INSCRIÇÃO</title>

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
<jsp:useBean id="filme" class="modelo.dominio.Filme" scope="request"></jsp:useBean>
</head>
<%
	String mensagem = (String) request.getAttribute("mensagem");
	if (mensagem != null)
		out.println("<h3>" + mensagem + "</h3>");
%>
<body>
	<form action="alterarFilme" method="post" onsubmit="return validar()">
		<table>
			<tr>
				<td class="tituloCampo">Registro:</td>
				<td><input type="text" name="registro" value='<jsp:getProperty property="registro" name="filme"/>' size="30" maxlength="80"></td>
			</tr>
			<tr>
				<td class="tituloCampo">Nome:</td>
				<td><input type="text" name="nomeFilme" value='<jsp:getProperty property="nomeFilme" name="filme"/>' size="30" maxlength="80"></td>
			</tr>
			<tr>
				<td class="tituloCampo">Descrição:</td>
				<td><input type="text" name="descricao" value='<jsp:getProperty property="descricao" name="filme"/>' size="11" maxlength="11"></td>
			</tr>
			<tr>
				<td class="tituloCampo">Lançamento:</td>
				<td><input type="text" name="dataLancamento" value='<jsp:getProperty property="dataLancamento" name="filme"/>' size="10" maxlength="10"></td>
			</tr>
			<tr>
				<td class="tituloCampo">Categoria:</td>
				<td><input type="text" name="categoria" value='<jsp:getProperty property="categoria" name="filme"/>' size="30" maxlength="80"></td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" value="Enviar"></td>
			</tr>
		</table>
	</form>
</body>
</html>








