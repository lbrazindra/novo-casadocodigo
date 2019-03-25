<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Cadastro de produtos</title>
</head>
<body>
	<s:hasBindErrors name="produto">
	</s:hasBindErrors>
	<form:form action="${s:mvcUrl('PC#save').build()}" method="post"
		commandName="produto">
		<div>
			<label for="titulo">Titulo</label>
			<form:input path="titulo" />
			<form:errors path="titulo" />
		</div>
		<div>
			<label for="descricao">Descrição</label>
			<form:textarea rows="10" path="descricao" />
		</div>
		<div>
			<label for="paginas">Número de paginas</label> <input type="text"
				name="paginas" id="paginas" />
			<form:errors path="paginas" />
		</div>
		<c:forEach items="${tipos}" var="tipoDeLivro" varStatus="status">
			<div>
				<label for="preco_${tipoDeLivro}">${tipoDeLivro}</label> <input
					type="text" name="precos[${status.index}].value"
					id="preco_${tipoDeLivro}" /> <input type="hidden"
					name="precos[${status.index}].tipoDeLivro" value="${tipoDeLivro}" />
				<form:errors path="descricao" />
			</div>
		</c:forEach>
		<div>
			<input type="submit" value="Enviar">
		</div>
		<div>
			<label for="dataDoRelaase">Data de lançamento</label>
			<form:input type="date" path="dataDoRelaase" />
			<form:errors path="dataDoRelaase" />
		</div>
		<div>
			<label for="sumario">Sumário do livro</label>
			<form:input type="file" path="sumario" />
			<form:errors path="sumarioPath" />
		</div>
	</form:form>
</body>
</html>