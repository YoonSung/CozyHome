package org.nhnnext.web;

import java.util.Collections;
import java.util.List;

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

@Controller
@RequestMapping("/board")
public class BoardController{
	
	@Autowired
	BoardRepository dbRepository; 
	
	@Autowired
	CommentRepository commentRepository;
	
	@RequestMapping("/form")
	public String boardForm() {
		return "form";
	}
	
	@RequestMapping(value="", method=RequestMethod.POST)
	public String board(BoardData boardData, MultipartFile file) {
		
		String uploadFileName = FileUploader.upload(file);
//		System.out.println(uploadFileName);
		boardData.setFileName(uploadFileName);
		
		BoardData savedBoardData = dbRepository.save(boardData);
		System.out.println("Board Point Execute End");
		return "redirect:/board/" + savedBoardData.getId();
	}

	@RequestMapping("/{id}")
	public String confirm(@PathVariable Long id, Model model) {
		BoardData getBoardData = dbRepository.findOne(id);
		model.addAttribute("board", getBoardData);
		System.out.println("confirm Point Execute End");
		return "redirect:/board/list";
	}
	
	@RequestMapping("/list")
	public String showList(Model model) {
		Iterable<BoardData> boardAllData = dbRepository.findAll();
		Collections.reverse((List<BoardData>) boardAllData);
		model.addAttribute("boardAllData", boardAllData);
		return "list";
	}
	
	@RequestMapping("/modify/{id}")
	public String modify(@PathVariable Long id, Model model) {
		
		//악의적
		BoardData getBoardData = dbRepository.findOne(id);
		model.addAttribute("data", getBoardData);
		return "modify";
	}
	
	@RequestMapping("/delete/{id}")
	public String delete(@PathVariable Long id, Model model) {
		List<CommentData> list = dbRepository.findOne(id).getComments();
		
		//악의적으로
		for (CommentData commentData : list) {
			commentRepository.delete(commentData.getId());
		}

		dbRepository.delete(id);
		
		return "redirect:/board/list";
	}

}
