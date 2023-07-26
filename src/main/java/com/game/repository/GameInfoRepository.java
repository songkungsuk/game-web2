package com.game.repository;

import java.util.List;
import java.util.Map;

public interface GameInfoRepository {
	List<Map<String, String>> selectGameList(Map<String, String> games);
	
	Map<String, String> selectGame(String gameNum);
	
	int insertGameContent(Map<String, String> games);
	
	int updateGameContent(Map<String, String> games);
	
	int deleteGameContent(String gameNum);
}
