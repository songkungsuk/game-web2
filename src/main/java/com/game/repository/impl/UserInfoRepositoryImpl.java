package com.game.repository.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import com.game.common.DBcon;
import com.game.repository.UserInfoRepository;

public class UserInfoRepositoryImpl implements UserInfoRepository {
	
	@Override
	public List<Map<String, String>> selectUserInfoList(Map<String, String> userInfo) {
		String sql = "SELECT * FROM USER_INFO WHERE 1=1";
		List<Map<String, String>> userInfoList = new ArrayList<>();
		try (Connection con = DBcon.getCon()) {
			try (PreparedStatement ps = con.prepareStatement(sql)) {
				try (ResultSet rs = ps.executeQuery()) {
					while (rs.next()) {
						Map<String, String> user = new HashMap<>();
						user.put("UI_NUM", rs.getString("UI_NUM"));
						user.put("UI_NAME", rs.getString("UI_NAME"));
						user.put("UI_ID", rs.getString("UI_ID"));
						user.put("UI_PWD", rs.getString("UI_PWD"));
						user.put("UI_IMG_PATH", rs.getString("UI_IMG_PATH"));
						user.put("UI_DESC", rs.getString("UI_DESC"));
						user.put("UI_BIRTH", rs.getString("UI_BIRTH"));
						user.put("CREDAT", rs.getString("CREDAT"));
						user.put("CRETIM", rs.getString("CRETIM"));
						user.put("LMODAT", rs.getString("LMODAT"));
						user.put("LMOTIM", rs.getString("LMOTIM"));

						userInfoList.add(user);
					}
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
		}

		return userInfoList;
	}

	@Override
	public Map<String, String> selectUserInfo(String uiNum) {

		String sql = "SELECT * FROM USER_INFO WHERE UI_NUM=?";

		try (Connection con = DBcon.getCon()) {
			try (PreparedStatement ps = con.prepareStatement(sql)) {
				ps.setString(1, uiNum);
				try (ResultSet rs = ps.executeQuery()) {
					if (rs.next()) {
						Map<String, String> user = new HashMap<>();
						user.put("UI_NUM", rs.getString("UI_NUM"));
						user.put("UI_NAME", rs.getString("UI_NAME"));
						user.put("UI_ID", rs.getString("UI_ID"));
						user.put("UI_PWD", rs.getString("UI_PWD"));
						user.put("UI_IMG_PATH", rs.getString("UI_IMG_PATH"));
						user.put("UI_DESC", rs.getString("UI_DESC"));
						user.put("UI_BIRTH", rs.getString("UI_BIRTH"));
						user.put("CREDAT", rs.getString("CREDAT"));
						user.put("CRETIM", rs.getString("CRETIM"));
						user.put("LMODAT", rs.getString("LMODAT"));
						user.put("LMOTIM", rs.getString("LMOTIM"));

						return user;
					}
				}
			}
		} catch (Exception e) {
		}

		return null;
	}

	@Override
	public int insertUserInfo(Map<String, String> userInfo) {
		String sql = "INSERT INTO USER_INFO(UI_NAME, UI_ID, UI_PWD, UI_IMG_PATH, UI_DESC, UI_BIRTH, CREDAT, CRETIM, LMODAT, LMOTIM)\r\n"
				+ "VALUES(?, ?, ?, ?, ?, ?, DATE_FORMAT(NOW(), '%Y%m%d'),  DATE_FORMAT(NOW(), '%H%i%s'), DATE_FORMAT(NOW(), '%Y%m%d'),  DATE_FORMAT(NOW(), '%H%i%s'))";

		try (Connection con = DBcon.getCon()) {
			try (PreparedStatement ps = con.prepareStatement(sql)) {
				ps.setString(1, userInfo.get("UI_NAME"));
				ps.setString(2, userInfo.get("UI_ID"));
				ps.setString(3, userInfo.get("UI_PWD"));
				ps.setString(4, userInfo.get("UI_IMG_PATH"));
				ps.setString(5, userInfo.get("UI_DESC"));
				ps.setString(6, userInfo.get("UI_BIRTH"));

				return ps.executeUpdate();
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return 0;
	}

	@Override
	public int updateUserInfo(Map<String, String> userInfo) {
		String sql = "UPDATE user_info SET UI_NAME = ?, UI_ID=?, UI_PWD=?, UI_IMG_PATH=?, UI_DESC=?, UI_BIRTH=?, LMODAT=DATE_FORMAT(NOW(), '%Y%m%d'), LMOTIM = DATE_FORMAT(NOW(), '%H%i%s') \r\n"
				+ "WHERE UI_NUM = ?";
		try (Connection con = DBcon.getCon()) {
			try (PreparedStatement ps = con.prepareStatement(sql)) {
				ps.setString(1, userInfo.get("UI_NAME"));
				ps.setString(2, userInfo.get("UI_ID"));
				ps.setString(3, userInfo.get("UI_PWD"));
				ps.setString(4, userInfo.get("UI_IMG_PATH"));
				ps.setString(5, userInfo.get("UI_DESC"));
				ps.setString(6, userInfo.get("UI_BIRTH"));
				ps.setString(7, userInfo.get("UI_NUM"));

				return ps.executeUpdate();
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return 0;
	}

	@Override
	public int deleteUserInfo(String userInfo) {
		String sql = "DELETE FROM user_info WHERE UI_NUM=?";

		try (Connection con = DBcon.getCon()) {
			try (PreparedStatement ps = con.prepareStatement(sql)) {
				ps.setString(1, userInfo);
				return ps.executeUpdate();
			}
		} catch (Exception e) {
			// TODO: handle exception
		}

		return 0;
	}

	public static void main(String[] args) {
		UserInfoRepository urRepo = new UserInfoRepositoryImpl();
		Map<String, String> user = new HashMap<>();
		user.put("UI_NAME", "hong");
		user.put("UI_ID", "hongsong");
		user.put("UI_PWD", "hsoonngg");
		user.put("UI_IMG_PATH", "");
		user.put("UI_DESC", "donghae");
		user.put("UI_BIRTH", "20230725");
		user.put("UI_NUM", "2");
//		System.out.println(urRepo.insertUserInfo(user));
//		System.out.println(urRepo.updateUserInfo(user));
//		System.out.println(urRepo.deleteUserInfo("1"));
		System.out.println(urRepo.selectUserInfoList(null));
		System.out.println(urRepo.selectUserInfo("1"));

	}

	@Override
	public Map<String, String> selectUserInfoById(String uiId) {
		String sql = "SELECT * FROM USER_INFO WHERE UI_ID=?";

		try (Connection con = DBcon.getCon()) {
			try (PreparedStatement ps = con.prepareStatement(sql)) {
				ps.setString(1, uiId);
				try (ResultSet rs = ps.executeQuery()) {
					if (rs.next()) {
						Map<String, String> user = new HashMap<>();
						user.put("UI_NUM", rs.getString("UI_NUM"));
						user.put("UI_NAME", rs.getString("UI_NAME"));
						user.put("UI_ID", rs.getString("UI_ID"));
						user.put("UI_PWD", rs.getString("UI_PWD"));
						user.put("UI_IMG_PATH", rs.getString("UI_IMG_PATH"));
						user.put("UI_DESC", rs.getString("UI_DESC"));
						user.put("UI_BIRTH", rs.getString("UI_BIRTH"));
						user.put("CREDAT", rs.getString("CREDAT"));
						user.put("CRETIM", rs.getString("CRETIM"));
						user.put("LMODAT", rs.getString("LMODAT"));
						user.put("LMOTIM", rs.getString("LMOTIM"));

						return user;
					}
				}
			}
		} catch (Exception e) {

		}

		return null;
	}


}
