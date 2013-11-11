package org.nhnnext.web;

import org.nhnnext.repository.BoardRepository;
import org.nhnnext.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class CommentController {

	@Autowired
	BoardRepository boardRepository;
	
	@Autowired
	CommentRepository commentRepository;
	
	@RequestMapping(value="/board/comment/{id}", method=RequestMethod.POST)
	public String commentSave(@PathVariable Long id, String comment) {
		
		BoardData getBoardData = boardRepository.findOne(id);
		CommentData commentData = new CommentData(getBoardData, comment);
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
		BoardData boardData = boardRepository.findOne(id);
		CommentData commentData = new CommentData(boardData, comment);
		return commentRepository.save(commentData);
	}
}
