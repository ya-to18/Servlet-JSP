package sj;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ValidationServlet extends HttpServlet {
    // POSTメソッドのリクエスト受信時に実行されるメソッド
    public void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {

        // リクエスト・レスポンスの設定
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");

        // JSPからのリクエストデータ取得
        String userName = request.getParameter("name");
        String userPassword = request.getParameter("password");
        String userEmail = request.getParameter("email");

        // データが存在しない場合は空文字に置き換え
        userName = Objects.toString(userName, "");
        userPassword = Objects.toString(userPassword, "");
        userEmail = Objects.toString(userEmail, "");

        // バリデーションNG時のメッセージを格納するリスト
        ArrayList<String> errorList = new ArrayList<String>();

        // バリデーション実施
        if( "".equals(userName.trim()) ) {
            // 氏名が未入力の場合
            errorList.add("氏名は必須です。");
        }

        if( userPassword.length() < 8 ) {
            // パスワードが8文字に満たない場合
            errorList.add("パスワードは8文字以上にしてください。");
        }

        if( !userEmail.matches("^[a-zA-Z0-9.]+@[a-zA-Z0-9.]+$") ) {
            // メールアドレスの形式でない場合
            errorList.add("メールアドレスの入力形式が正しくありません。");
        }

        // エラーリストが空かどうか
        if( errorList.isEmpty() ) {
            // バリデーションOKなら成功メッセージを表示
            response.getWriter().println("<h2>バリデーションOKです！</h2>");
        } else {
            // エラーがある場合はリストをリクエストスコープに登録してフォームに画面遷移
            request.setAttribute("errorList", errorList);
            request.getRequestDispatcher("/pages/validationPage.jsp").forward(request, response);
        }
    }
}
