package org.nhnnext.web;

import java.util.Collections;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.nhnnext.repository.BoardRepository;
import org.nhnnext.repository.CommentRepository;
import org.nhnnext.support.FileUploader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

@Controller
@RequestMapping("/board")
public class BoardController{
	
	private static final Logger log = LoggerFactory.getLogger(BoardController.class);
	
	@Autowired
	BoardRepository dbRepository; 
	
	@Autowired
	CommentRepository commentRepository;
	
	@RequestMapping("/form")
	public String boardForm() {
		return "form";
	}
	
	@RequestMapping(value="", method=RequestMethod.POST)
	public String create(BoardData boardData, MultipartFile file) {
		log.debug("Param boardData : {}", boardData);
		
		// log.debug("board : "+ boardData);
		// 이렇게 구현될 경우 메서드 호출 전 전달인자를 먼저 처리하기 때문에 
		// string비용발생이 생기게 된다. info 레벨이 더라도!! 그렇기 때문에 slf4j, logback에서 지원되고 있는 이 기능을 사용하면, 
		// 메서드에 전달인자를 그냥 전달하기 때문에 성능상에 이슈가 없다.
		
		String uploadFileName = FileUploader.upload(file);
		boardData.setFileName(uploadFileName);
		
		BoardData savedBoardData = dbRepository.save(boardData);
		
		log.debug("savedBoardData : {}", savedBoardData.toString());
		
		return "redirect:/board/" + savedBoardData.getId();
	}

	@RequestMapping("/{id}")
	public String confirm(@PathVariable Long id, Model model) {
		BoardData getBoardData = dbRepository.findOne(id);
		model.addAttribute("board", getBoardData);
		return "redirect:/board/list";
	}
	
	@RequestMapping("/list")
	public String showList(Model model, HttpSession session) {
		
		if ( session.getAttribute("userId")  == null ) 
			return "redirect:/";
		
		Iterable<BoardData> boardAllData = dbRepository.findAll();
		Collections.reverse((List<BoardData>) boardAllData);
		model.addAttribute("boardAllData", boardAllData);
		return "list";
	}
	
	@RequestMapping("/modify/{id}")
	public String modify(@PathVariable Long id, Model model) {
		
		//악의적 접근에 대한 처리가 필요
		BoardData getBoardData = dbRepository.findOne(id);
		model.addAttribute("data", getBoardData);
		return "modify";
	}
	
	@RequestMapping("/delete/{id}")
	public String delete(@PathVariable Long id, Model model) {
		List<CommentData> list = dbRepository.findOne(id).getComments();
		
		//악의적 접근에 대한 처리가 필요
		for (CommentData commentData : list) {
			commentRepository.delete(commentData.getId());
		}

		dbRepository.delete(id);
		
		return "redirect:/board/list";
	}

}
