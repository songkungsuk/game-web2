package com.game.repository;

import java.util.List;
import java.util.Map;

public interface BoardInfoRepository {
	List<Map<String, String>> selectBoardInfoList(Map<String, String> boardInfo);
	
	Map<String, String> selectBoardInfo(String biNum);
	
	int insertBoardInfo(Map<String, String> board);
	
	int updateBoardInfo(Map<String, String> board);
	
	int deleteBoardInfo(String biNum);
	
}
