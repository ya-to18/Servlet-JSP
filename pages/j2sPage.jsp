<%@ page contentType="text/html; charset=UTF-8" %>

<html>
    <head>
        <title>Servlet/JSPの基礎を学ぼう</title>
    </head>
    <body>
        <%-- リンクのクリック時にServletへデータを渡す(GETメソッド) --%>
        <h2>GETメソッド送信リンク</h2>
        <a href="<%= request.getContextPath() %>/j2s?user=samurai">GET送信</a>

        <%-- フォームの送信時にServletへデータを渡す(POSTメソッド) --%>
        <h2>POSTメソッド送信フォーム</h2>
        <form action="<%= request.getContextPath() %>/j2s" method="post">
            <input type="text" name="user">
            <input type="submit" value="POST送信">
        </form>
    </body>
</html>
