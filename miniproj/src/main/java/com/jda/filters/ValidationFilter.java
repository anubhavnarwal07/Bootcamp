package com.jda.filters;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class ValidationFilter implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
	      throws IOException, ServletException {
		// TODO Auto-generated method stub
		String email = request.getParameter("email");
		  String  emailRegex= "^[\\w-\\+]+(\\.[\\w]+)*@[\\w-]+(\\.[\\w]+)*(\\.[a-z]{2,})$";
		  String passwordP = "(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}";
		  String password  = request.getParameter("password");
			 Pattern patternE,patternP;
			 Matcher matcherE,matcherP;
			 patternE = Pattern.compile(emailRegex, Pattern.CASE_INSENSITIVE);
			 patternP = Pattern.compile(passwordP, Pattern.CASE_INSENSITIVE);
			 
			 matcherE = patternE.matcher(email);
			 matcherP = patternP.matcher(password);
			if(!matcherE.matches()){
				RequestDispatcher dispatcher = request.getRequestDispatcher("reg.jsp");
				PrintWriter out = response.getWriter();
				out.println("<font color=red><center>please enter valid email</center></font>");
				dispatcher.include(request, response);
			}
			else if(!matcherP.matches()){
				RequestDispatcher dispatcher = request.getRequestDispatcher("reg.jsp");
				PrintWriter out = response.getWriter();
				out.println("<font color=red><center>please enter valid password</center></font>");
				dispatcher.include(request, response);
			}
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

}
