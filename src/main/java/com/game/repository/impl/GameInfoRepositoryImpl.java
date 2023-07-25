package com.game.repository.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.game.common.DBcon;
import com.game.repository.GameInfoRepository;

public class GameInfoRepositoryImpl implements GameInfoRepository {

	@Override
	public List<Map<String, String>> selectGameList() {
		List<Map<String, String>> games = new ArrayList<Map<String,String>>();
		String sql = "SELECT * FROM GAME_INFO";
		try (Connection con = DBcon.getCon()){
			try(PreparedStatement ps = con.prepareStatement(sql)){
				try(ResultSet rs = ps.executeQuery()){
					while(rs.next()) {
						Map<String, String> game = new HashMap<String, String>();
						game.put("GAME_NUM", rs.getString("GAME_NUM"));
						game.put("GAME_NAME", rs.getString("GAME_NAME"));
						game.put("GAME_DESC", rs.getString("GAME_DESC"));
						game.put("GAME_GRADE", rs.getString("GAME_GRADE"));
						
						games.add(game);
					}
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return games;
	}

	@Override
	public Map<String, String> selectGame(String gameNum) {
		String sql = "SELECT * FROM GAME_INFO WHERE GAME_NUM=?";
		try (Connection con = DBcon.getCon()){
			try(PreparedStatement ps = con.prepareStatement(sql)){
				ps.setString(1, gameNum);
				try(ResultSet rs = ps.executeQuery()){
					while(rs.next()) {
						Map<String, String> game = new HashMap<String, String>();
						game.put("GAME_NUM", rs.getString("GAME_NUM"));
						game.put("GAME_NAME", rs.getString("GAME_NAME"));
						game.put("GAME_DESC", rs.getString("GAME_DESC"));
						game.put("GAME_GRADE", rs.getString("GAME_GRADE"));
						
						return game;
					}
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}

	@Override
	public int insertGameContent(Map<String, String> games) {
		String sql ="INSERT INTO GAME_INFO(GAME_NAME, GAME_DESC, GAME_GRADE)\r\n"
				+ "VALUES(?, ?, ?);";
		try (Connection con = DBcon.getCon()){
			try(PreparedStatement ps = con.prepareStatement(sql)){
				ps.setString(1, games.get("GAME_NAME"));
				ps.setString(2, games.get("GAME_DESC"));
				ps.setString(3, games.get("GAME_GRADE"));
	
				
				return ps.executeUpdate();
			}
		} catch (Exception e) {
	
		}
		return 0;
	}

	@Override
	public int updateGameContent(Map<String, String> games) {
		String sql ="UPDATE GAME_INFO SET GAME_NAME = ?, GAME_DESC = ?, GAME_GRADE = ? WHERE GAME_NUM = ?";
		try (Connection con = DBcon.getCon()){
			try(PreparedStatement ps = con.prepareStatement(sql)){
				ps.setString(1, games.get("GAME_NAME"));
				ps.setString(2, games.get("GAME_DESC"));
				ps.setString(3, games.get("GAME_GRADE"));
				ps.setString(4, games.get("GAME_NUM"));
				
				return ps.executeUpdate();
			}
		} catch (Exception e) {
	
		}
		return 0;
	}

	@Override
	public int deleteGameContent(String gameNum) {
		String sql = "DELETE FROM GAME_INFO WHERE GAME_NUM = ?";
		try (Connection con = DBcon.getCon()){
			try(PreparedStatement ps = con.prepareStatement(sql)){
				ps.setString(1, gameNum);
				
				return ps.executeUpdate();
			}
		} catch (Exception e) {
	
		}	
		return 0;
	}
	public static void main(String[] args) {
		GameInfoRepository gameRepo = new GameInfoRepositoryImpl();
		
		System.out.println(gameRepo.selectGame("1"));
		Map<String, String> gameInfo = new HashMap<String, String>();
		gameInfo.put("GAME_NAME", "메이플스토리");
		gameInfo.put("GAME_DESC", "개쉽망겜");
		gameInfo.put("GAME_GRADE", "FF");
		gameInfo.put("GAME_NUM", "1");
//		System.out.println(gameRepo.insertGameContent(gameInfo));
//		System.out.println(gameRepo.updateGameContent(gameInfo));
//		System.out.println(gameRepo.deleteGameContent("1"));
		System.out.println(gameRepo.selectGameList());
		
	}
}
