<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.Objects" %>

<html>
    <head>
        <title>Servlet/JSPの基礎を学ぼう</title>
    </head>
    <body>
        <%
        // 最後に送信されたフォームの入力データを取得
        String userName = request.getParameter("name");
        String userPassword = request.getParameter("password");
        String userEmail = request.getParameter("email");

        // データが存在しない場合は空文字に置き換え
        userName = Objects.toString(userName, "");
        userPassword = Objects.toString(userPassword, "");
        userEmail = Objects.toString(userEmail, "");
        %>

        <%-- Servletへの画面遷移(POSTメソッド) --%>
        <form action="<%= request.getContextPath() %>/validation" method="post">
            <table>
                <tr>
                    <th style="text-align: right;">氏名</th>
                    <td><input type="text" name="name" value=<%= userName %> ></td>
                </tr>
                <tr>
                    <th style="text-align: right;">パスワード</th>
                    <td><input type="text" name="password" value=<%= userPassword %> ></td>
                </tr>
                <tr>
                    <td style="text-align: right;">メールアドレス</td>
                    <td><input type="text" name="email" value=<%= userEmail %> ></td>
                </tr>
            </table>
            <input type="submit" value="バリデーション実施">

            <%
            // バリデーションのチェック結果をServletから取得
            ArrayList<String> errorList = (ArrayList<String>) request.getAttribute("errorList");

            // バリデーションNGがあればエラーメッセージを表示
            if( errorList != null ) {
                for( String errorMessage : errorList ) {
                    out.println("<br><font color=\"red\">" + errorMessage + "</font>");
                }
            }
            %>
        </form>
    </body>
</html>
