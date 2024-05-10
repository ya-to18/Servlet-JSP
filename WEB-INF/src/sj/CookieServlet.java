package sj;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
public class CookieServlet extends HttpServlet {
	// GETメソッドのリクエスト受信時に実行されるメソッド
	public void doGet(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
		
		// リクエスト・レスポンスの設定
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		// クッキーの取得
		Cookie[] userCookies = request.getCookies();
		// クッキーが存在する場合
		if( userCookies != null ) {
			for( Cookie cookie : userCookies ) {
				// クッキー名に応じてデータを取得・保存
				switch( cookie.getName() ) {
					case "name" -> { // 氏名
						request.setAttribute("userName", cookie.getValue() );
					}
					case "age" -> { // 年齢
						request.setAttribute("userAge", cookie.getValue() );
					}
					default -> {} // なにもしない
				}
			}
		}
		
		// JSPへの画面遷移
		RequestDispatcher dispatcher = request.getRequestDispatcher("/pages/cookiePage.jsp");
		dispatcher.forward(request, response);
	}
	
	// POSTメソッドのリクエスト受信時に実行されるメソッド
	public void doPost(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
		
		// リクエスト・レスポンスの設定
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		// JSPからのリクエストデータ
		String userName = request.getParameter("name");
		String userAge = request.getParameter("age");
		String deleteCookie = request.getParameter("deleteCookie");
		
		int expirationDate = 60 * 60 * 24 * 1; // 有効期限は1日
		String message = "クッキーを保存しました。"; // 表示するメッセージ
		
		// チェックが入っていたらクッキー削除
		if( "true".equals(deleteCookie) ) {
			expirationDate = 0; // 削除するために有効期限を0にする
			message = "クッキー削除を受け付けました。";
		}
		
		// クッキーに保存
		setCookie(response, "name", userName, expirationDate);
		setCookie(response, "age", userAge, expirationDate);
		
		// 取得したデータの表示
		PrintWriter out = response.getWriter();
		out.println(message);
	}
	
	// 新しいクッキーを設定するメソッド
	private void setCookie(HttpServletResponse response, String name, String value, int expiration) {
		Cookie cookie = new Cookie(name, value);
		cookie.setMaxAge(expiration);
		response.addCookie(cookie);
	}

}
