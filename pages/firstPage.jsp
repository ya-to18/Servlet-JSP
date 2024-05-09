<%-- コンテンツタイプを指定 --%>
<%@ page contentType="text/html; charset=UTF-8" %>

<html>
	<head>
		<title>Servlet/JSPの基礎を学ぼう</title>
	</head>
	<body>
		<%! int visitCount = 0; // 訪問回数を宣言 %>
		
		<%
		String local = "First JSP";
		out.println(local); // ローカル変数の中身を画面に出力
		%>
		
		<% visitCount++; // 訪問回数を1加算 %>
		
		<h3>ようこそ！<%= visitCount %>回目の訪問ですね。</h3> 
	</body>
</html>