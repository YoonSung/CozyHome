package org.nhnnext.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {
	@RequestMapping("/")
	public String index() {
		return "index";
	}
	
	@RequestMapping(value="/main", method=RequestMethod.POST)
	public String main(HomeData homeData) {
		System.out.println(homeData.toString());
		return "main";
	}
}