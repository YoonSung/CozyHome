package org.nhnnext.web;

import java.util.Iterator;

import org.nhnnext.repository.DBRepository;
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
public class BoardController {
	
	@Autowired
	DBRepository dbRepository; 
	
	
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
		return "confirmForm";
	}
	
	@RequestMapping("/list")
	public String showList(Model model) {
		Iterable<BoardData> boardAllData = dbRepository.findAll();
		model.addAttribute("boardAllData", boardAllData);
		return "list";
	}
	
	@RequestMapping("/modify/{id}")
	public String modify(@PathVariable Long id, Model model) {
		BoardData getBoardData = dbRepository.findOne(id);
		model.addAttribute("data", getBoardData);
		return "modify";
	}
}
