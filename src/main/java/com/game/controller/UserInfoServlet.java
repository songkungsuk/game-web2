package com.game.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.game.common.CommonView;
import com.game.service.UserInfoService;
import com.game.service.impl.UserInfoServiceImpl;

@WebServlet("/user-info/*")
public class UserInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	UserInfoService urService = new UserInfoServiceImpl();

	public UserInfoServlet() {
		System.out.println("userInfoServlet create");
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String cmd = CommonView.getcmd(request);

		if ("list".equals(cmd)) {
			request.setAttribute("userList", urService.selectUserInfoList(null));
		}
		if ("view".equals(cmd)) {
			String uiNum = request.getParameter("uiNum");
			request.setAttribute("user", urService.selectUserInfo(uiNum));
		}
		if ("update".equals(cmd)) {
			String uiNum = request.getParameter("uiNum");
			request.setAttribute("user", urService.selectUserInfo(uiNum));
		}else if ("logout".equals(cmd)) {
			HttpSession session = request.getSession();
			session.invalidate();
			request.setAttribute("msg", "logout 되셧습니다");
			request.setAttribute("url", "/user-info/login");
			CommonView.forwardMessage(request, response);
			return;
		}

		CommonView.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		String cmd = CommonView.getcmd(request);
		Map<String, String> user = new HashMap<String, String>();
		user.put("UI_NAME", request.getParameter("UI_NAME"));
		user.put("UI_ID", request.getParameter("UI_ID"));
		user.put("UI_PWD", request.getParameter("UI_PWD"));
		if (request.getParameter("UI_BIRTH") != null) {
			user.put("UI_BIRTH", request.getParameter("UI_BIRTH").replace("-", ""));
		}
		user.put("UI_IMG_PATH", request.getParameter("UI_IMG_PATH"));
		user.put("UI_DESC", request.getParameter("UI_DESC"));
		user.put("UI_NUM", request.getParameter("UI_NUM"));
		if ("insert".equals(cmd)) {

			int result = urService.insertUserInfo(user);
			request.setAttribute("msg", "유저 등록 성공");
			request.setAttribute("url", "/user-info/list");

			if (result != 1) {
				request.setAttribute("msg", "유저 등록 실패");
				request.setAttribute("url", "/user-info/insert");
			}
		}
		if ("update".equals(cmd)) {

			int result = urService.updateUserInfo(user);

			request.setAttribute("msg", "유저 수정 성공");
			request.setAttribute("url", "/user-info/list");

			if (result != 1) {
				request.setAttribute("msg", "유저 수정 실패");
				request.setAttribute("url", "/user-info/list");
			}
		}
		if ("delete".equals(cmd)) {
			String uiNum = request.getParameter("UI_NUM");

			int result = urService.deleteUserInfo(uiNum);
			request.setAttribute("msg", "유저 삭제 성공");
			request.setAttribute("url", "/user-info/list");

			if (result != 1) {
				request.setAttribute("msg", "유저 삭제 실패");
				request.setAttribute("url", "/user-info/list");
			}
		}
		if ("login".equals(cmd)) {
			request.setAttribute("msg", "아이디나 비밀번호를 확인해주세요");
			request.setAttribute("url", "/user-info/login");
			HttpSession session = request.getSession();
			String uiId = request.getParameter("UI_ID");
			String uiPwd = request.getParameter("UI_PWD");
			Map<String, String> ui = urService.login(uiId);
			if(ui != null) {
				String dbUI_PWD = ui.get("UI_PWD");
				if(uiPwd.equals(dbUI_PWD)) {
					request.setAttribute("msg", "로그인이 성공하셧습니다.");
					request.setAttribute("url", "/user-info/");
					session.setAttribute("user", ui);
				}
			}
			
		}

		CommonView.forwardMessage(request, response);
	}

}
