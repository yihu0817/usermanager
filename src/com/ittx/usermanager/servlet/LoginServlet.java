package com.ittx.usermanager.servlet;

import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/login.servlet")
public class LoginServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String autoLogin = request.getParameter("autoLogin");
		String userName = request.getParameter("name");
		String passWord = request.getParameter("password");
		if("admin".equals(userName) && "123".equals(passWord)){
			//保存登录用户名密码到cookie
			if("true".equals(autoLogin)){
				saveCookie(response,userName,passWord);
			}else{
				clearCookie(response);
			}
			//保存登录状态信息
			HttpSession session = request.getSession();
			session.setAttribute("loginState", userName);
//			session.setMaxInactiveInterval(2);
			request.getRequestDispatcher("main.jsp").forward(request, response);
			
		}else{
			String msg = URLEncoder.encode("用户名或密码错误!", "UTF-8");
			request.getRequestDispatcher("login.jsp?message="+msg).forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
	
	/**
	 * 清除cookie
	 * @param response
	 */
	private void clearCookie(HttpServletResponse response){
		Cookie userNameCookie = new Cookie("userName",null);
		Cookie pswCookie = new Cookie("passWord",null);
		pswCookie.setMaxAge(0);
		userNameCookie.setMaxAge(0);
		response.addCookie(userNameCookie);
		response.addCookie(pswCookie);
	}
	
	/**
	 * 保存cookie
	 * @param response
	 * @param userName
	 * @param passWord
	 */
	private void saveCookie(HttpServletResponse response,String userName,String passWord){
		Cookie userNameCookie = new Cookie("userName",userName);
		Cookie pswCookie = new Cookie("passWord",passWord);
		response.addCookie(userNameCookie);
		response.addCookie(pswCookie);
	}
}
