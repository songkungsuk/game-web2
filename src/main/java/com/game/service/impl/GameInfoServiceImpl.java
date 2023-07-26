package com.game.service.impl;

import java.util.List;
import java.util.Map;

import com.game.repository.GameInfoRepository;
import com.game.repository.impl.GameInfoRepositoryImpl;
import com.game.service.GameInfoService;

public class GameInfoServiceImpl implements GameInfoService{
	GameInfoRepository gameInfo = new GameInfoRepositoryImpl();
	@Override
	public List<Map<String, String>> selectGameList(Map<String, String> games) {
		
		return gameInfo.selectGameList(null);
	}

	@Override
	public Map<String, String> selectGame(String gameNum) {
		
		return gameInfo.selectGame(gameNum);
	}

	@Override
	public int insertGameContent(Map<String, String> games) {
		
		return gameInfo.insertGameContent(games);
	}

	@Override
	public int updateGameContent(Map<String, String> games) {
		
		return gameInfo.updateGameContent(games);
	}

	@Override
	public int deleteGameContent(String gameNum) {
		
		return gameInfo.deleteGameContent(gameNum);
	}

}
