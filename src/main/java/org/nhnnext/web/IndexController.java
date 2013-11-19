package org.nhnnext.web;

import javax.servlet.http.HttpSession;

import org.nhnnext.repository.IndexRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class IndexController {
	
	private static final Logger log = LoggerFactory.getLogger(IndexController.class);
	
	@Autowired
	IndexRepository indexRepository;
	
	@RequestMapping("/")
	public String index() {
		return "index";
	}
	
	@RequestMapping("/main")
	public String main() {
		return "index";
	}
	
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public @ResponseBody String LogIn(String id, String password, HttpSession session) {
		IndexData indexData = indexRepository.findOne(id) ;

		if ( indexData != null) {
			if ( ! indexData.getPassword().equals(password) ) {
				return "pwError";
			}
			
			String nickname = indexData.getNickname();
			session.setAttribute("userId", id);
			session.setAttribute("nickname", nickname);
			return nickname;
		}
		return "notExist";
	}
	
	@RequestMapping(value="/join", method=RequestMethod.POST)
	public @ResponseBody boolean Join(IndexData joinData) {
		log.error(joinData.toString());
		
		if ( indexRepository.findOne(joinData.getId()) == null) {
			indexRepository.save(joinData);
			return true;
		} else {
		}
		return false;
	}
}