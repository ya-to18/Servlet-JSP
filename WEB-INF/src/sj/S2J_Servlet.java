package sj;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class S2J_Servlet extends HttpServlet {
	// GETメソッドのリクエスト受信時に実行されるメソッド
    public void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {

        // リクエスト・レスポンスの設定
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");

        PrintWriter out = response.getWriter();
        out.println("【Servlet Start】");

        // URLのパラメータ(画面遷移の種類)を取得
        String transType = request.getParameter("type");

        // 画面遷移の種類ごとの処理
        if( transType.equals("forward") ) {
            // フォワードによる画面遷移
            request.setAttribute( "productName", "えんぴつ" );
            RequestDispatcher dispatcher = request.getRequestDispatcher("/pages/s2jForwardPage.jsp");
            dispatcher.forward(request, response);
        } else {
        	// インクルードによる画面遷移
            request.setAttribute( "productName", "消しゴム" );
        	RequestDispatcher dispatcher = request.getRequestDispatcher("/pages/s2jIncludePage.jsp");
            dispatcher.include(request, response);
        }

        out.println("【Servlet End】");
    }
}
