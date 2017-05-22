package com.ittx.usermanager.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ittx.usermanager.model.User;
import com.ittx.usermanager.service.UserService;
import com.ittx.usermanager.service.impl.UserServiceImpl;

@WebServlet("/user_update.servlet")
public class UserUpdateServlet extends HttpServlet {
	private UserService userService = new UserServiceImpl();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userId = request.getParameter("userId");
		User user = userService.getUserById(Integer.parseInt(userId));
		request.setAttribute("user", user);
		request.setAttribute("type", "modify");
		request.getRequestDispatcher("jsp/user/user_add.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
