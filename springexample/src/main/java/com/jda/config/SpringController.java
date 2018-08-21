package com.jda.config;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SpringController {

	@RequestMapping(value = "/Hello")
	public ModelAndView printfunc() {
		ModelAndView MAV = new ModelAndView("HellWorld");
		MAV.addObject("name", "shanky");
		return MAV;
	}
}
