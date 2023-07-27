package com.game.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.game.common.CommonView;
import com.game.service.BoardInfoService;
import com.game.service.impl.BoardInfoServiceImpl;

@WebServlet("/board-info/*")
public class BoardInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	BoardInfoService boardService = new BoardInfoServiceImpl();

	private boolean isLogin(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		if (session.getAttribute("user") == null) {
			request.setAttribute("msg", "로그인이 필요한 화면입니다");
			request.setAttribute("url", "/user-info/login");

			CommonView.forwardMessage(request, response);
			return false;
		}
		return true;
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if (!isLogin(request, response)) { // 로그인이 되어있으면 아래로 내려간다
			return;
		}
		String cmd = CommonView.getcmd(request);
		if ("list".equals(cmd)) {
			request.setAttribute("boardList", boardService.selectBoardInfoList(null));
		} else if ("view".equals(cmd) || "update".equals(cmd)) {
			String biNum = request.getParameter("biNum");
			request.setAttribute("board", boardService.selectBoardInfo(biNum));
		}
		CommonView.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		if (!isLogin(request, response)) {
			return;
		}
		String cmd = CommonView.getcmd(request);
		HttpSession session = request.getSession();
		Map<String, String> user = (Map<String, String>) session.getAttribute("user");
		if(cmd.equals("insert")) {
			
			String biTitle = request.getParameter("biTitle");
			String biContent = request.getParameter("biContent");
			Map<String, String> board = new HashMap<String, String>();
			board.put("biTitle", biTitle);
			board.put("biContent", biContent);
			board.put("uiNum", user.get("UI_NUM"));
			
			int result = boardService.insertBoardInfo(board);
			request.setAttribute("msg", "등록이 안됬습니다");
			if(result == 1) {
				request.setAttribute("msg", "등록이 되었습니다.");
				request.setAttribute("url", "/board-info/list");
			}
			
		}
		CommonView.forwardMessage(request, response);
	}

}
