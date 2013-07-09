package com.TroyEmpire.NightFuryServer.Controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.*;

@Controller
public class IndexController {

	@RequestMapping("/")
	public ModelAndView home(HttpServletRequest request) {
		return new ModelAndView("index");

	}
}