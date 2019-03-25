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
		<ul>
			<c:forEach var="error" items="${errors.allErrors}">
				<li><s:message code="${error.code}"
						text="${error.defaultMessage}" /></li>
			</c:forEach>
		</ul>
	</s:hasBindErrors>
	<form:form action="${s:mvcUrl('PC#save').build()}" method="post"
		commandName="produto">
		<div>
			<label for="titulo">Titulo</label> <input type="text" name="titulo"
				id="titulo" />
			<form:errors path="titulo" />
		</div>
		<div>
			<label for="descricao">Descrição</label>
			<textarea rows="10" cols="20" name="descricao" id="descricao">
			</textarea>
		</div>
		<div>
			<label for="paginas">Número de paginas</label> <input type="text"
				name="paginas" id="paginas" />
		</div>
		<c:forEach items="${tipos}" var="tipoDeLivro" varStatus="status">
			<div>
				<label for="preco_${tipoDeLivro}">${tipoDeLivro}</label> <input
					type="text" name="precos[${status.index}].value"
					id="preco_${tipoDeLivro}" /> <input type="hidden"
					name="precos[${status.index}].tipoDeLivro" value="${tipoDeLivro}" />
			</div>
		</c:forEach>
		<div>
			<input type="submit" value="Enviar">
		</div>
	</form:form>

</body>
</html>