package org.nhnnext.web;

import java.util.HashMap;

import org.nhnnext.repository.BoardRepository;
import org.nhnnext.repository.CommentRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;


@Controller
public class CommentController {

	private static final Logger log = LoggerFactory
			.getLogger(CommentController.class);
	
	@Autowired
	BoardRepository boardRepository;
	
	@Autowired
	CommentRepository commentRepository;
	
	@RequestMapping(value="/board/comment/{id}", method=RequestMethod.POST)
	public String commentSave(@PathVariable Long id, String comment, String writer) {
		
		BoardData getBoardData = boardRepository.findOne(id);
		CommentData commentData = new CommentData(getBoardData, comment);
		//commentData.setWritter(writer);
		
		commentRepository.save(commentData);
		return "redirect:/board/list";
	}
	
	@RequestMapping("/board/comment/delete/{id}")
	public String commentDelete(@PathVariable Long id) {
		commentRepository.delete(id);
		return "redirect:/board/list";
	}
	
	@RequestMapping(value="/board/comment/delete/json/{id}", method=RequestMethod.POST)
	public @ResponseBody void commentJsonDelete(@PathVariable Long id) {
		commentRepository.delete(id);
	}
	
	@RequestMapping(value="/board/comment/json/{id}", method=RequestMethod.POST)
	public @ResponseBody CommentData commentJsonSave(@PathVariable Long id, String comment) {
		
		log.debug("id : {}", id);
		log.debug("comment : {}", comment);
		
		BoardData boardData = boardRepository.findOne(id);
		CommentData commentData = new CommentData(boardData, comment);
		return commentRepository.save(commentData);
	}
	
	@RequestMapping(value="/board/comment/json/ios/{id}", method=RequestMethod.POST)
	public @ResponseBody String commentJsonFromIosSave(@PathVariable Long id, @RequestBody String data){
		
		Gson gson = new Gson();
		HashMap<String, String> cmtData= gson.fromJson(data, new TypeToken<HashMap<String,String>>(){}.getType());
		
		String cmt = cmtData.get("CMT");
		HashMap<String, String> result = new HashMap<String, String>();
		result.put("result", "NO");
		result.put("code", "400");
		
		//test code
		log.error("data = "+data);
		log.error("CMT = "+cmtData.get("CMT"));
		
		
		BoardData boardData = boardRepository.findOne(id);
		CommentData commentData = new CommentData(boardData, cmt);
		commentRepository.save(commentData);
		
		if ( commentData != null) {
			result.put("result", "OK");
			result.put("code", "200");
		}
		
		log.error("tostring : "+gson.toJson(result));
		return gson.toJson(result);
	}
}
