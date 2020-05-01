package social.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import social.bean.MatchingBean;
import social.service.Match;
import social.service.MatchImpl;

@WebServlet("/social/match/5.do")
public class Matching extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Match matching = new MatchImpl();
		List<MatchingBean> todayRequest = matching.todayRequest();
		List getMatch = matching.getMatch(todayRequest);
		request.setAttribute("Matchlist", getMatch);
		matching.insertMatchResult(getMatch);
		RequestDispatcher rd = request.getRequestDispatcher("/social/match/Matching.jsp");
		rd.forward(request,response);
		return;
	}
}
