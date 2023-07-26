package com.game.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.game.common.CommonView;
import com.game.service.GameInfoService;
import com.game.service.impl.GameInfoServiceImpl;


@WebServlet("/game-info/*")
public class GameInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    GameInfoService gameInfo = new GameInfoServiceImpl();

    public GameInfoServlet() {
    	System.out.println("GameInfo Constructor Make");
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String cmd = CommonView.getcmd(request);
		if(cmd.equals("list")) {
			request.setAttribute("gameList", gameInfo.selectGameList(null));
		}
		if(cmd.equals("view")) {
			
		}
		if(cmd.equals("update")) {
			
		}
		if(cmd.equals("insert")) {
			
		}
		CommonView.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
