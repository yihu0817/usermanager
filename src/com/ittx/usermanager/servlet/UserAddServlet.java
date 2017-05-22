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

/**
 * 控制层
 * 
 * 1.接收 请求 2.调用业务层 3.响应数据
 *
 */
@WebServlet("/user_add.servlet")
public class UserAddServlet extends HttpServlet {
	private UserService userService = new UserServiceImpl();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String age = request.getParameter("age");
		String sex = request.getParameter("sex");
		String type = request.getParameter("type");
		userService.addUser(id,name,age,sex,type);

		request.getRequestDispatcher("user_list.servlet").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
