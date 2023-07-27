package com.game.service.impl;

import java.util.List;
import java.util.Map;

import com.game.repository.BoardInfoRepository;
import com.game.repository.impl.BoardInfoRepositoryImpl;
import com.game.service.BoardInfoService;

public class BoardInfoServiceImpl implements BoardInfoService {
	BoardInfoRepository boardRepo = new BoardInfoRepositoryImpl();
	@Override
	public List<Map<String, String>> selectBoardInfoList(Map<String, String> boardInfo) {
		
		return boardRepo.selectBoardInfoList(boardInfo);
	}

	@Override
	public Map<String, String> selectBoardInfo(String biNum) {
		
		return boardRepo.selectBoardInfo(biNum);
	}

	@Override
	public int insertBoardInfo(Map<String, String> board) {
		
		return boardRepo.insertBoardInfo(board);
	}

	@Override
	public int updateBoardInfo(Map<String, String> board) {
		
		return boardRepo.updateBoardInfo(board);
	}

	@Override
	public int deleteBoardInfo(String biNum) {
		
		return boardRepo.deleteBoardInfo(biNum);
	}
	
}
