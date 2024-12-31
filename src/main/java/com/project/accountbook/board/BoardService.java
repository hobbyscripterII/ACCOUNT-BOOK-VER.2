package com.project.accountbook.board;

import org.springframework.stereotype.Service;

@Service
public class BoardService {
	private final BoardMapper boardMapper;
	
	public BoardService(BoardMapper boardMapper) {
		this.boardMapper = boardMapper;
	}
}