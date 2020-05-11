package social.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import _00_init.util.HibernateUtil;
import social.bean.MatchingBean;
import social.service.Match;
import social.service.MatchImpl;

@WebServlet("/social/match/5.do")
public class Matching extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session hSession = factory.getCurrentSession();
//		try {
//			Transaction ts = hSession.beginTransaction();
			Match matching = new MatchImpl(HibernateUtil.getSessionFactory().getCurrentSession());
			List<MatchingBean> todayRequest = matching.todayRequest(1);
			List getMatch = matching.getMatch(todayRequest);
			matching.insertMatchResult(getMatch);   
			request.setAttribute("matching", todayRequest);
			request.setAttribute("getMatch", getMatch);
//			ts.commit();
//		} catch (Exception e) {
//			hSession.getTransaction().rollback();
//			e.printStackTrace();
//		}
		RequestDispatcher rd = request.getRequestDispatcher("/social/match/Matching.jsp");
		rd.forward(request,response);
	}
}
