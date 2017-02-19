package com.kevin.mvcdemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/hello")
public class HelloMvcController {

	@RequestMapping("/hi")
	public String sayhi()
	{
		return "home";
	}
}
