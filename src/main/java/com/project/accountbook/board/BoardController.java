package com.project.accountbook.board;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/board")
public class BoardController {
	private final BoardService boardService;
	private final Logger log = LoggerFactory.getLogger(getClass());
	
	public BoardController(BoardService boardService) {
		this.boardService = boardService;
	}
	
	@GetMapping("/list/{code}")
	public String board(@PathVariable(name = "code") String code, Model model) {
		String title = getBoardTitle(code);
		
		model.addAttribute("title", title);
		
		return "board/list";
	}
	
	private String getBoardTitle(String code) {
		String title = null;
		
		switch (code) {
			case "notice" : title = "공지사항"; break;
			case "qna" : title = "자주 묻는 질문"; break;
		}
		
		return title;
	}
}
