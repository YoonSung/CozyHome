package org.nhnnext.web;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.nhnnext.repository.BoardRepository;
import org.nhnnext.repository.CommentRepository;
import org.nhnnext.support.FileUploader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.google.gson.Gson;

@Controller
@RequestMapping("/board")
public class BoardController {

	private static final Logger log = LoggerFactory
			.getLogger(BoardController.class);

	@Autowired
	BoardRepository dbRepository;

	@Autowired
	CommentRepository commentRepository;

	@RequestMapping("/form")
	public String boardForm() {
		return "form";
	}

	@RequestMapping(value = "", method = RequestMethod.POST)
	public String create(BoardData boardData, MultipartFile file) {
		log.debug("Param boardData : {}", boardData);

		// log.debug("board : "+ boardData);
		// 이렇게 구현될 경우 메서드 호출 전 전달인자를 먼저 처리하기 때문에
		// string비용발생이 생기게 된다. info 레벨이 더라도!! 그렇기 때문에 slf4j, logback에서 지원되고 있는 이
		// 기능을 사용하면,
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

		// if ( session.getAttribute("userId") == null )
		// return "redirect:/";

		Iterable<BoardData> boardAllData = dbRepository.findAll();
		Collections.reverse((List<BoardData>) boardAllData);
		model.addAttribute("boardAllData", boardAllData);
		return "list";
	}

	@RequestMapping("/modify/{id}")
	public String modify(@PathVariable Long id, Model model) {

		// 악의적 접근에 대한 처리가 필요
		BoardData getBoardData = dbRepository.findOne(id);
		model.addAttribute("data", getBoardData);
		return "modify";
	}

	@RequestMapping("/delete/{id}")
	public String delete(@PathVariable Long id, Model model) {
		List<CommentData> list = dbRepository.findOne(id).getComments();

		// 악의적 접근에 대한 처리가 필요
		for (CommentData commentData : list) {
			commentRepository.delete(commentData.getId());
		}

		dbRepository.delete(id);

		return "redirect:/board/list";
	}

	@RequestMapping(value="/newPost", method=RequestMethod.POST)
	public @ResponseBody String uploadFromIOS(BoardData boardData, MultipartFile file) {
			log.debug("Param boardData : {}", boardData);
			
			String uploadFileName = FileUploader.upload(file);
			boardData.setFileName(uploadFileName);
			
			BoardData savedBoardData = dbRepository.save(boardData);
			
			log.debug("savedBoardData : {}", savedBoardData.toString());
			
		
			HashMap<String, String> result = new HashMap<String, String>();
			result.put("result", "NO");
			result.put("code", "400");
		
		if ( savedBoardData != null) {
				result.put("result", "OK");
				result.put("code", "200");
		}
		
		Gson gson = new Gson();
		return gson.toJson(result);
	}

	@RequestMapping("/xhr/{callback}/{frameNumber}")
	public @ResponseBody String htmlXHRFuction(@PathVariable String callback,
			@PathVariable int frameNumber) {
		System.out.println("in htmlXHRFunction");

		ArrayList<String> urls = new ArrayList<String>();
		urls.add("http://adcreative.naver.com/ad3/1004/1004874/420_90_61381195734140.jpg");
		urls.add("http://adcreative.naver.com/ad3/1004/1004874/420_90_11382339269735.jpg");
		urls.add("http://adcreative.naver.com/ad3/1004/1004874/420_90_01381801624212.jpg");

		int randomIndex = (int) (Math.random() * urls.size());
		log.info("randomIndex : {}\n", randomIndex);

		String param = urls.get(randomIndex);
		log.info("param : {}\n", param);

		String result = callback + "(\'" + param + "\'," + frameNumber + ");";
		log.info("result : {}\n", result);

		return result;
	}
	
	@RequestMapping("/test/koreanFile")
	public void koreanTest() {
		
		File file1 = null;
		File file2 = new File("/Users/YOON-SUNG/Desktop/test/javajigi.png");
		
		try {
			
			file1 = new File( new String("/Users/YOON-SUNG/Desktop/test/자바지기.png".getBytes(), "UTF-8") );;


			System.out.println("file1 exists? : "+file1.exists());
			System.out.println("file2 exists? : "+file2.exists());			
			System.out.println("file1 create sucess? : "+file1.createNewFile());
			System.out.println("file2 create sucess? : "+file2.createNewFile());
			
			
			
			//file1.renameTo(new File( new String("/Users/YOON-SUNG/Desktop/test/정윤성.png".getBytes(), "UTF-8")));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		System.out.println("System File Encoding : "+System.getProperty("file.encoding")); //UTF8로 잘 표기됩니다.
	}
}
