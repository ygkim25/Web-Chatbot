package com.lec.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.lec.domain_dto.Board;

public interface BoardService {
	
	void insertBoard(Board board);
	void updateBoard(Board board);
	void deleteBoard(Board board);
	
	Board getBoard(Board board);
	long getTotalRowCount(Board board);
	Page<Board> getBoardList(Pageable pageable, String searchType, String searchWord);
	
	
}
