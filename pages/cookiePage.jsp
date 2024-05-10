<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page import="java.util.Objects" %>

<html>
    <head>
        <title>Servlet/JSPの基礎を学ぼう</title>
    </head>
    <body>
        <%
        // Servletからのデータを取得
        String userName = (String) request.getAttribute("userName");
        String userAge = (String) request.getAttribute("userAge");

        // データが存在しない場合は空文字に置き換え
        userName = Objects.toString(userName, "");
        userAge = Objects.toString(userAge, "");
        %>

        <%-- Servletへの画面遷移(POSTメソッド) --%>
        <form action="<%= request.getContextPath() %>/cookie" method="post">
            <table>
                <tr>
                    <th>氏名</th>
                    <td><input type="text" name="name" value=<%= userName %> ></td>
                </tr>
                <tr>
                    <th>年齢</th>
                    <td><input type="text" name="age" value=<%= userAge %> ></td>
                </tr>
            </table>
            <input type="submit" value="保存">

            <input type="checkbox" id="deleteCookie" name="deleteCookie" value="true">
            <label for="deleteCookie">クッキーを削除する</label>
        </form>
    </body>
</html>
