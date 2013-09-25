package org.nhnnext.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/board")
public class BoardController {
	@RequestMapping("/form")
	public String boardForm() {
		return "form";
	}
	
	@RequestMapping("")
	public String board(String title, String article) {
		System.out.println("/board is called");
		System.out.println("title : "+title+"  /  article : "+article);
		
		return "forward:/board/confirmForm";
//		return "redirect:/board/confirmForm";
	}
	
	@RequestMapping("/confirmForm")
	public String boardConfirmForm() {
		return "confirmForm";
	}
}
