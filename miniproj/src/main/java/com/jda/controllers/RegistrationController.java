package com.jda.controllers;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jda.dao.AppData;
import com.jda.model.UserModel;
import java.io.IOException;
import javax.servlet.ServletException;

public class RegistrationController extends HttpServlet {
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		UserModel user = new UserModel();
		user.setName(request.getParameter("name"));
		user.setEmail(request.getParameter("email"));
		user.setUsername(request.getParameter("username"));
		user.setPassword(request.getParameter("password"));

		try {
			AppData.registerUser(user);
			RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
			  dispatcher.forward(request, response);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}
