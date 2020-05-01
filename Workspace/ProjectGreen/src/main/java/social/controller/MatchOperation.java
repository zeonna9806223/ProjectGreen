package social.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import social.bean.MatchRequestBean;
import social.service.Match;
import social.service.MatchImpl;

@WebServlet("/social/mr8.do")
public class MatchOperation extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String delete1 = nullFix(request.getParameter("delete"));
		System.out.println(delete1);
		String new1 = nullFix(request.getParameter("new"));
		Integer delete2 = Integer.valueOf(delete1);
		Integer new2 = Integer.valueOf(new1);

		Match match = new MatchImpl();
		if(delete1!=null) {
			match.deleteFriend(delete2);		
		}
		if(new1!=null) {
			match.markMatch(new2);
			match.markPairDate(new2);
		}
		String url = request.getContextPath() + "/social/Match.jsp";
		String targetURL = response.encodeRedirectURL(url);
		response.sendRedirect(targetURL);
	}

	public String nullFix(String string) {
		if (string == null) {
			return new String("-1");
		} else {
			return string;
		}
	}
}
