package com.game.repository.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.game.common.DBcon;
import com.game.repository.BoardInfoRepository;

public class BoardInfoRepositoryImpl implements BoardInfoRepository {

	@Override
	public List<Map<String, String>> selectBoardInfoList(Map<String, String> boardInfo) {
		List<Map<String, String>> boardInfoList = new ArrayList<Map<String,String>>();
		String sql = "SELECT * FROM board_info";
		try (Connection con = DBcon.getCon()){
			try(PreparedStatement ps = con.prepareStatement(sql)){
				try(ResultSet rs = ps.executeQuery()){
					while(rs.next()) {
						Map<String, String> map = new HashMap<String, String>();
						map.put("biNum", rs.getString("BI_NUM"));
						map.put("biTitle", rs.getString("BI_TITLE"));
						map.put("biContent", rs.getString("BI_CONTENT"));
						map.put("uiNum", rs.getString("UI_NUM"));
						map.put("credat", rs.getString("CREDAT"));
						map.put("cretim", rs.getString("CRETIM"));
						map.put("lmodat", rs.getString("LMODAT"));
						map.put("lmotim", rs.getString("LMOTIM"));
						
						boardInfoList.add(map);
						
					}
				}
			}
		} catch (Exception e) {

		}
		return boardInfoList;
	}

	@Override
	public Map<String, String> selectBoardInfo(String biNum) {
		String sql = "SELECT * FROM board_info WHERE BI_NUM=?";
		try (Connection con = DBcon.getCon()){
			try(PreparedStatement ps = con.prepareStatement(sql)){
				ps.setString(1, biNum);
				try(ResultSet rs = ps.executeQuery()){
					while(rs.next()) {
						Map<String, String> map = new HashMap<String, String>();
						map.put("biNum", rs.getString("BI_NUM"));
						map.put("biTitle", rs.getString("BI_TITLE"));
						map.put("biContent", rs.getString("BI_CONTENT"));
						map.put("uiNum", rs.getString("UI_NUM"));
						map.put("credat", rs.getString("CREDAT"));
						map.put("cretim", rs.getString("CRETIM"));
						map.put("lmodat", rs.getString("LMODAT"));
						map.put("lmotim", rs.getString("LMOTIM"));
						
						return map;
						
					}
				}
			}
		} catch (Exception e) {

		}
		
		return null;
	}

	@Override
	public int insertBoardInfo(Map<String, String> board) {
		String sql ="INSERT INTO board_info(BI_TITLE, BI_CONTENT, UI_NUM, CREDAT, CRETIM, LMODAT, LMOTIM)\r\n"
				+ "VALUES(?,?, ?, DATE_FORMAT(NOW(), '%Y%m%d'), DATE_FORMAT(NOW(), '%H%i%s'), DATE_FORMAT(NOW(), '%Y%m%d'), DATE_FORMAT(NOW(), '%H%i%s'))";
		
		try (Connection con = DBcon.getCon()){
			try(PreparedStatement ps = con.prepareStatement(sql)){
				ps.setString(1, board.get("biTitle"));
				ps.setString(2, board.get("biContent"));
				ps.setString(3, board.get("uiNum"));
				
				return ps.executeUpdate();
			}
		} catch (Exception e) {

		}
		return 0;
	}

	@Override
	public int updateBoardInfo(Map<String, String> board) {
		String sql = "UPDATE board_info SET BI_TITLE=?, BI_CONTENT=?, UI_NUM=?, LMODAT=DATE_FORMAT(NOW(), '%Y%m%d'), LMOTIM = DATE_FORMAT(NOW(), '%H%i%s') WHERE BI_NUM = ?";
		
		try (Connection con = DBcon.getCon()){
			try(PreparedStatement ps = con.prepareStatement(sql)){
				ps.setString(1, board.get("biTitle"));
				ps.setString(2, board.get("biContent"));
				ps.setString(3, board.get("uiNum"));
				ps.setString(4, board.get("biNum"));
				return ps.executeUpdate();
			}
		} catch (Exception e) {

		}
		return 0;
	
	}

	@Override
	public int deleteBoardInfo(String biNum) {
		String sql = "DELETE FROM board_info WHERE BI_NUM = ?";
		
		try (Connection con = DBcon.getCon()){
			try(PreparedStatement ps = con.prepareStatement(sql)){
				ps.setString(1, biNum);
				return ps.executeUpdate();
			}
		} catch (Exception e) {

		}
		return 0;
	}
	public static void main(String[] args) {
		BoardInfoRepository boardinfo = new BoardInfoRepositoryImpl();
		Map<String, String> board = new HashMap<String, String>();
		board.put("biTitle", "red");
		board.put("biContent", "sharks");
		board.put("uiNum", "6");
		board.put("biNum", "3");
		
//		System.out.println(boardinfo.selectBoardInfo("3"));
//		System.out.println(boardinfo.selectBoardInfoList(board));
//		System.out.println(boardinfo.insertBoardInfo(board));
//		System.out.println(boardinfo.deleteBoardInfo("2"));
//		System.out.println(boardinfo.updateBoardInfo(board));
		
	}
}
