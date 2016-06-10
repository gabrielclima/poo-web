<%@page import="modelo.dominio.Filme"%>
<%@page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Confirmação de Aluguel</title>

</head>
<body>
	<jsp:useBean id="filme" class="modelo.dominio.Filme" scope="request"></jsp:useBean>
	<p class="tituloCampo">
		O alguel do filme <b>"<%=filme.getNomeFilme()%>"
		</b> foi confirmado.
	</p>
	<a href="exibirCatalogo">Voltar ao catálogo</a>
	<br>
	<br>
	<a href="logout">Sair</a>
</body>
</html>








