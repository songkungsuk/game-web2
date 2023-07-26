package com.game.service.impl;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import com.game.repository.UserInfoRepository;
import com.game.repository.impl.UserInfoRepositoryImpl;
import com.game.service.UserInfoService;

public class UserInfoServiceImpl implements UserInfoService {
	private UserInfoRepository urRepo = new UserInfoRepositoryImpl();
	// service 가 실무에 나가게되면 제일 열심히 해야되는 곳,,
	@Override
	public List<Map<String, String>> selectUserInfoList(Map<String, String> userInfo) {
		
		return urRepo.selectUserInfoList(null);
	}

	@Override
	public Map<String, String> selectUserInfo(String uiNum) {
		
		return urRepo.selectUserInfo(uiNum);
	}

	@Override
	public int insertUserInfo(Map<String, String> userInfo) {
		
		return urRepo.insertUserInfo(userInfo);
	}

	@Override
	public int updateUserInfo(Map<String, String> userInfo) {
		
		return urRepo.updateUserInfo(userInfo);
	}

	@Override
	public int deleteUserInfo(String userInfo) {
		
		return urRepo.deleteUserInfo(userInfo);
	}

	@Override
	public boolean login(Map<String, String> userInfo, HttpSession session) {
		
		return urRepo.login(userInfo, session);
	}

}
