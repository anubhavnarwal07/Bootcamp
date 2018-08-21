package com.jda.service;

import org.springframework.web.servlet.ModelAndView;

import com.jda.model.UserModel;

public interface IUserService {
	
	public boolean registerUser(UserModel userModel);
	public UserModel loginUser(UserModel userModel);
	public boolean forgotPassword(UserModel user, String url);
	public boolean update(String header, UserModel userModel);

}
