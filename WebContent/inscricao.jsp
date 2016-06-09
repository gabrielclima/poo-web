<%@page import="modelo.Inscricao"%>
<%@page import="modelo.Concurso"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Fazer inscrição</title>
	<link rel="stylesheet" type="text/css" href="css/estilo.css">

	<script type="text/javascript">
	function validar(form)
	{
		// form = document.forms[0];
		// form = document.getElementById("formInscricao");
		if (form.codigoConcurso.value == "")
		{
			alert('O Campo Concurso não foi preenchido');
			return false;
		}
		else
		if (form.nome.value == "")
		{
			alert('O Campo Nome não foi preenchido');
			return false;
		}
		else
		if (form.cpf.value == "")
		{
			alert('O Campo CPF não foi preenchido');
			return false;
		}
		else
		if (form.nascimento.value == "")
		{
			alert('O Campo Nascimento não foi preenchido');
			return false;
		}
		
		return true;
	}
	</script>
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
		<h3>Preencha seus dados pessoais para realizar a inscrição</h3>
		<form id="formInscricao" method="post" action="salvarInscricao"
				onsubmit="return validar(this)">
			<table>
				<tr>
					<td class="tituloCampo">Concurso:</td>
					<td><select name="codigoConcurso">
							<option value="" disabled selected>--Escolha um concurso--</option>
<%				if (lista != null)
					for (Concurso concurso: lista) {
						String selecionado = "";
						if ((inscricao.getConcurso() != null) && (concurso.equals(inscricao.getConcurso())))
							selecionado = "selected=\"selected\"";
%>							
							<option <%=selecionado%> value="<%=concurso.getCodigoConcurso()%>"><%=concurso.getDescricao()%></option>
<%						}
%>
					</select></td>
				</tr>
				<tr>
					<td class="tituloCampo">Nome:</td>
					<td><input type="text" name="nome" size="50" maxlength="120"
							value='<jsp:getProperty property="nome" name="inscricao"/>'></td>
				</tr>
				<tr>
					<td class="tituloCampo">CPF:</td>
					<td><input type="text" name="cpf" size="11" maxlength="11"
							value="<%=inscricao.getCpf()%>"></td>
				</tr>
				<tr>
					<td class="tituloCampo">Data de Nascimento:<br>
						Formato: dd/mm/aaaa</td>
					<td><input type="text" name="nascimento" size="10" maxlength="10"
							value="<%=inscricao.getNascimentoFormatado()%>"></td>
				</tr>
				<tr>
					<td></td>
					<td><input type="submit" value="Confirmar Inscrição">
						<input type="button" value="Cancelar" onclick="location.href = './'">
					</td>
				</tr>
			</table>
		</form>
	</div>


</body>
</html>