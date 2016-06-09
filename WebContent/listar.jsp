<%@page import="modelo.Inscricao"%>
<%@page import="modelo.Concurso"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Pesquisar inscri��es</title>
	<link rel="stylesheet" type="text/css" href="css/estilo.css">

	<script type="text/javascript">
	function validar(form)
	{
		// form = document.forms[0];
		// form = document.getElementById("formInscricao");
		if (form.codigoConcurso.value == "")
		{
			alert('O Campo Concurso n�o foi preenchido');
			return false;
		}
		
		return true;
	}
	</script>
</head>
<body>
<%
	String mensagem = (String) request.getAttribute("mensagem");
	List<Concurso> lista = (List<Concurso>) request.getAttribute("lista");
	
	if (mensagem != null)
		out.println("<div style=\"color: red;\">" + mensagem + "</div>");
%>
	<div>
		<h3>Escolha o concurso para exibir as inscri��es</h3>
		<form id="formInscricao" method="post" action="listarInscricoes"
				onsubmit="return validar(this)">
			<table>
				<tr>
					<td class="tituloCampo">Concurso:</td>
					<td><select name="codigoConcurso">
							<option value="" disabled selected>--Escolha um concurso--</option>
<%				if (lista != null)
					for (Concurso concurso: lista) {
%>							
							<option value="<%=concurso.getCodigoConcurso()%>"><%=concurso.getDescricao()%></option>
<%						}
%>
					</select></td>
				</tr>
				<tr>
					<td></td>
					<td><input type="submit" value="Enviar Pesquisa">
						<input type="button" value="Cancelar" onclick="location.href = './'">
					</td>
				</tr>
			</table>
		</form>
	</div>
	
	<table border="1">
	<tr>
		<td>N� Inscri��o</td>
		<td>Nome</td>
		<td>CPF</td>
		<td>Data Nasc.</td>
	</tr>
<%
	List<Inscricao> inscricoes = (List<Inscricao>) request.getAttribute("inscricoes");
	if (inscricoes != null)
	{
		for (Inscricao inscricao: inscricoes)
		{
%>
	<tr>
		<td><%=inscricao.getNumeroInscricao() %></td>
		<td><%=inscricao.getNome() %></td>
		<td><%=inscricao.getCpf() %></td>
		<td><%=inscricao.getNascimentoFormatado() %></td>
	</tr>
<%
		}
	}
%>
	</table>
</body>
</html>