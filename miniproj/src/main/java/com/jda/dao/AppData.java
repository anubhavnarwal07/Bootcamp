package com.jda.dao;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jda.model.UserModel;

public class AppData {
	private static String jdbcURL = "jdbc:mysql://" + System.getenv("DBHOST") + ":3306/" + System.getenv("DBNAME")
	      + "?user=" + System.getenv("DBUSER") + "&password=" + System.getenv("DBPASSWORD");

	private static Connection connection;

	public static Connection getConnection() throws ClassNotFoundException {
		Class.forName("com.mysql.jdbc.Driver");
		try {
			connection = DriverManager.getConnection(jdbcURL);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return connection;
	}

	public static boolean registerUser(UserModel user) throws ClassNotFoundException {
		String sql = "Insert into User(name,email,username,password)values(?,?,?,?)";

		try {
			PreparedStatement pst = getConnection().prepareStatement(sql);
			pst.setString(1, user.getName());
			pst.setString(2, user.getEmail());
			pst.setString(3, user.getUsername());
			pst.setString(4, user.getPassword());
			pst.executeUpdate();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	public static UserModel loginUser(UserModel usermodel) throws ClassNotFoundException, SQLException {
		String str = "select * from User where username = ?";
		PreparedStatement pst = getConnection().prepareStatement(str);

		pst.setString(1, usermodel.getEmail());
		ResultSet res = pst.executeQuery();
		while (res.next()) {
			UserModel user1 = new UserModel();
			user1.setName(res.getString(2));
			user1.setEmail(res.getString(3));
			user1.setUsername(res.getString(4));
			user1.setPassword(res.getString(5));

			return user1;
		}
		return null;
	}
}