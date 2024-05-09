package sj;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class J2S_Servlet extends HttpServlet {
	// GETメソッドのリクエスト受信時に実行されるメソッド
    public void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {

        getJspData(request, response);
    }

    // POSTメソッドのリクエスト受信時に実行されるメソッド
    public void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {

        getJspData(request, response);
    }

    // JSPから受け取ったデータを取得するメソッド
    private void getJspData(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {

        // リクエストのエンコード設定
        request.setCharacterEncoding("UTF-8");

        // JSPからのリクエストデータ取得
        String userName = request.getParameter("user");

        // レスポンスのコンテンツタイプ設定
        response.setContentType("text/html; charset=UTF-8");

        // 取得したデータの表示
        PrintWriter out = response.getWriter();
        out.println("JSPから送られたユーザー名は" + userName );
    }
}
