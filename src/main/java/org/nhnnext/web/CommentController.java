package org.nhnnext.web;

import org.nhnnext.repository.BoardRepository;
import org.nhnnext.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class CommentController {

	@Autowired
	BoardRepository boardRepository;
	
	@Autowired
	CommentRepository commentRepository;
	
	@RequestMapping(value="/board/comment/{id}", method=RequestMethod.POST)
	public String commentSave(@PathVariable Long id, String comment) {
		System.out.println(0);
		System.out.println("id : "+id);
		System.out.println("reefle : "+comment);
		
		BoardData getBoardData = boardRepository.findOne(id);
		System.out.println(1);
		CommentData commentData = new CommentData(getBoardData, comment);
		System.out.println(2);
		commentRepository.save(commentData);
		System.out.println(3);
		
		return "redirect:/board/list";
	}
}
