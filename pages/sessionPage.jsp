<%@ page contentType="text/html; charset=UTF-8" %>

<html>
	<head>
		<title>Servlet/JSPの基礎を学ぼう</title>
	</head>
	<body>
		<%
		// セッションデータの取得
		String cartItem = (String)session.getAttribute("cartItem");
		%>
		<h3>【JSP】カートに入った商品は<%= cartItem %></h3>
		<p>セッションID：<%= session.getId() %></p>
		
		<%-- Servletへの画面遷移(POSTメソッド) --%>
		<form action="<%= request.getContextPath() %>/session" method="post">
			<input type="submit" value="ServletへPOST送信">
		</form>
	</body>
</html>