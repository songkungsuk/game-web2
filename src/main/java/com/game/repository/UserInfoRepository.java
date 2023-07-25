package com.game.repository;

import java.util.List;
import java.util.Map;

public interface UserInfoRepository {
	List<Map<String, String>> selectUserInfoList();
	
	Map<String, String> selectUserInfo(String uiNum);
	
	int insertUserInfo(Map<String, String> userInfo);
	
	int updateUserInfo(Map<String, String> userInfo);
	
	int deleteUserInfo(String userInfo);
}
