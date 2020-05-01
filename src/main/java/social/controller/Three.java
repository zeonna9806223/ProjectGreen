package social.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import social.bean.MatchesBean;
import social.service.Match;
import social.service.MatchImpl;

/**
 * Servlet implementation class Three
 */
@WebServlet("/social/99.do")
public class Three extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Three() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
//		Match match = new MatchImpl();
//		System.out.println(match.todayRequest().size());
//		List<MatchesBean> matches = match.showMatch();
//		System.out.println("FUUUUUUUUUUUUUUUUUUUUUUk");
//		System.out.println(matches.size());
		Match match = new MatchImpl();
		List<MatchesBean> mb = match.showMatch();
		System.out.println(mb.size());
		request.setAttribute("showMatch", mb);
//		List list = new ArrayList();
//		List list2 = new ArrayList();
//		for (MatchesBean matchess : matches) {
//			Integer t = matchess.getMemberId1();
//			Integer t2 = matchess.getMemberId1();
//			Date d = matchess.getPairDate();
//			Date d2 = matchess.getFriendDate();
//			list2.add(t);
//			list2.add(t2);
//			list2.add(d);
//			list2.add(d2);
//			list.add(list2);
//		}	
		request.setAttribute("showMatch", mb );
			RequestDispatcher rd = request.getRequestDispatcher("/social/0.jsp");
			rd.forward(request, response);
			return;
//			chain.doFilter(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
