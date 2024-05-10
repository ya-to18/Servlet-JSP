package sj;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class SessionServlet extends HttpServlet {
	//GETメソッドのリクエスト受信時に実行されるメソッド
	public void doGet(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
		
		//リクエスト・レスポンスの設定
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		//セッションの取得（存在しなければ新規に開始）
		HttpSession session = request.getSession();
		
		// セッションのデータ登録
		session.setAttribute("cartItem", "コーヒー");
		
		// セッションのタイムアウト設定（30秒）
		session.setMaxInactiveInterval(30);
		
		// JSPへの画面遷移
		RequestDispatcher dispatcher = request.getRequestDispatcher("/pages/sessionPage.jsp");
		dispatcher.forward(request, response);
	}
	
	//POSTメソッドのリクエスト受信時に実行されるメソッド
	public void doPost(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
		
		// リクエスト・レスポンスの設定
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		//セッションの取得（存在しなければ新規に開始）
		HttpSession session = request.getSession();
		
		// セッションデータの取得
		String cartItem = (String)session.getAttribute("cartItem");
		
		// 取得したデータの表示
		PrintWriter out = response.getWriter();
		if( cartItem == null ) { // 有効なデータが存在しない場合
			out.println("<h3>【Servlet:doPost()】カートに商品が入っていません</h3>");
		} else {
			out.println("<h3>【Servlet:doPost()】カートに入った商品は" + cartItem + "</h3>");
		}
		out.println("<p>セッションID:" + session.getId() + "</p>");
		
		//セッションの終了
		session.invalidate();
	}
}
