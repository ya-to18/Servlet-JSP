<%@ page contentType="text/html; charset=UTF-8" %>

<html>
	<head>
		<title>Servelt/JSPの基礎を学ぼう</title>
	</head>
	<body>
		<h2>フォワード</h2>
		<%
		// リクエストスコープの商品名を取得
		String productName = (String)request.getAttribute("productName");
		%>
		<h3>商品名：<%= productName %></h3>
	</body>
</html>