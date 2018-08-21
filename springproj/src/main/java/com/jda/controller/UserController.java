package com.jda.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.jda.DAO.UserDao;
import com.jda.model.UserModel;
import com.jda.service.IUserService;
import com.jda.utility.ApplicationMailer;

@Controller
public class UserController {

	@Autowired
	private IUserService userService;
	@RequestMapping(value = "/")
	public ModelAndView getView() {
		return new ModelAndView("index");
	}

	@RequestMapping(value = "/registerform")
	public ModelAndView registerationForm() {
		return new ModelAndView("registeration");
	}
@RequestMapping(value="forgotpasswordform",method=RequestMethod.POST)
public ModelAndView forgotPassword(@ModelAttribute("user") UserModel userModel, HttpServletRequest req) {
	String url = req.getRequestURL().toString();
	userService.forgotPassword(userModel,url);
	return new ModelAndView("index");
}
@RequestMapping(value="/resetpassword",method=RequestMethod.POST)
public ModelAndView resetPasswordFOrm(@ModelAttribute("User") UserModel userModel, HttpServletRequest request){
	String header = request.getHeader("Referer");
	if(userService.update(header,userModel))
	{ return new ModelAndView("index");
	}
	else
	{
		 return new ModelAndView("ResetPassword");
	}
}
	@RequestMapping(value = "/registeration")
	public ModelAndView registerUser(@ModelAttribute("User") UserModel userModel) {
		
		if (userService.registerUser(userModel)) {
			return new ModelAndView("index");
		}
		return null;
	}

	@RequestMapping(value="resetpasswordform")
	public ModelAndView resetPasswordForm(@RequestParam("uuid") String uuid)
	{
		return new ModelAndView("ResetPassword");
	}
	@RequestMapping(value = "/forgotpassword")
	public ModelAndView forgotPasswordForm() {
		ModelAndView modelAndView = new ModelAndView("ForgotPassword");
		return modelAndView;
	}

	@RequestMapping(value = "/login")
	public ModelAndView getLoginDetails(@ModelAttribute("User") UserModel userModel) {
		UserModel user = userService.loginUser(userModel);
		if ( user != null) {

	return new ModelAndView("Welcome");
		}
		return new ModelAndView("index");
	}
}
