<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<header id="product-highlight" class="clearfix">
		<div id="product-overview" class="container">
			<img itemprop="image" width="280px" height="395px" src=''
				class="product-featured-image" alt="${product.title}">
			<h1 class="product-title" itemprop="name">${product.title}</h1>
			<p class="product-author">
				<span class="product-author-link"> ${product.title} </span>
			</p>
			<p itemprop="description" class="book-description">
				${product.description} Veja o <a
					href="<c:url value='/${product.summaryPath}'/>" target="_blank">sum&#225;rio</a>
				completo do livro!
			</p>
		</div>
	</header>
	<section class="buy-options clearfix">
		<form action="<c:url value="/shopping"/>" method="post"
			class="container">
			<input type="hidden" value="${product.id}" name="productId" />
			<ul id="variants" class="clearfix">
				<c:forEach items="${product.prices}" var="price">
					<li class="buy-option"><input type="radio" name="bookType"
						class="variant-radio" id="${product.id}-${price.bookType}"
						value="${price.bookType}"
						${price.bookType.name()=='COMBO'?'checked':''}> <label
						class="variant-label" for="${product.id}-${price.bookType}">
							${price.bookType} </label>
						<p class="variant-price">${price.value}</p></li>
				</c:forEach>
			</ul>
			<input type="submit" class="submit-image icon-basket-alt"
				alt="Compre agora" title="Compre agora '${product.title}'!"
				value="comprar" />
		</form>
	</section>
</body>
</html>