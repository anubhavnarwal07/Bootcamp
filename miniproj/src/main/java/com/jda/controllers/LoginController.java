package com.jda.controllers;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jda.dao.AppData;
import com.jda.model.UserModel;

public class LoginController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserModel usermodel = new UserModel();
		usermodel.setEmail(request.getParameter("username"));
		usermodel.setPassword(request.getParameter("password"));
		UserModel user = null;
		try {
			user = AppData.loginUser(usermodel);
			if (user != null) {
				if (request.getParameter("password").equals(user.getPassword())) {
					user.setPassword(null);
					request.getSession().setAttribute("user", user);
				
				} else {
				}
			
			RequestDispatcher requestDispatcher = request .getRequestDispatcher("Welcome.jsp");
			requestDispatcher.forward(request, response); }
			else {
			}

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
