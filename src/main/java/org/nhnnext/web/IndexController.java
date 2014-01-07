package org.nhnnext.web;

import java.util.Dictionary;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.nhnnext.repository.IndexRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;


@Controller
public class IndexController {
	
	private static final Logger log = LoggerFactory.getLogger(IndexController.class);
	
	@Autowired
	IndexRepository indexRepository;
	
	@RequestMapping("/")
	public String index(HttpSession session) {
		
		if ( session.getAttribute("userId") != null && session.getAttribute("nickname") !=null ) {
			return "redirect:/board/list";
		}
		return "home";
	}
	
	@RequestMapping("/main")
	public String main() {
		return "redirect:/home";
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
	
	@RequestMapping(value="/login.json", method=RequestMethod.POST) 
	public @ResponseBody String LoginJson(@RequestBody String data){
		
		Gson gson = new Gson();
		HashMap<String, String> loginData= gson.fromJson(data, new TypeToken<HashMap<String,String>>(){}.getType());
		
		String id = loginData.get("ID");
		String password= loginData.get("PW");
		HashMap<String, String> result = new HashMap<String, String>();
		result.put("result", "NO");
		result.put("code", "400");
		
		//test code
		log.error("data = "+data);
		log.error("ID = "+loginData.get("ID"));
		log.error("PW = "+loginData.get("PW"));
		
		
		IndexData indexData = indexRepository.findOne(id) ;
		if ( indexData != null) {
			if ( indexData.getPassword().equals(password) ) {
				result.put("result", "OK");
				result.put("code", "200");
				result.put("nickname", indexData.getNickname());
			}
		}
		
		log.error("tostring : "+gson.toJson(result));
		return gson.toJson(result);
	}
	
	
	@RequestMapping("/logout")
	public String Logout(HttpSession session) {
		session.invalidate();
		return "home";
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