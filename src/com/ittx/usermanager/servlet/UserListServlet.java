package com.ittx.usermanager.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ittx.usermanager.model.User;
import com.ittx.usermanager.service.UserService;
import com.ittx.usermanager.service.impl.UserServiceImpl;

@WebServlet("/user_list.servlet")
public class UserListServlet extends HttpServlet {
	private UserService userService = new UserServiceImpl();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<User> userLists = userService.getAllUser();

		request.setAttribute("userLists", userLists);
		request.getRequestDispatcher("jsp/user/user_list.jsp").forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
