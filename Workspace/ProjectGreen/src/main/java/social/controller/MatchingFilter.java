package social.controller;

import java.io.IOException;
import java.util.List;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import social.bean.MatchesBean;
import social.bean.MatchingBean;
import social.service.Match;
import social.service.MatchImpl;
import social.service.RestaurantType;
import social.service.RestaurantTypeImpl;
import social.service.TravelType;
import social.service.TravelTypeImpl;
import _00_init.util.HibernateUtil;
import member.model.MemberBean;

/**
 * Servlet Filter implementation class MatchingFilter
 */
//@WebFilter(servletNames = { "Match" }) //*****可以監控servlet
@WebFilter(urlPatterns = { "/social/Match.jsp" })

public class MatchingFilter implements Filter {

	public MatchingFilter() {
	}

	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpSession session = ((HttpServletRequest) request).getSession();
		MemberBean memberBean = (MemberBean) session.getAttribute("LoginOK");
		Integer pk = memberBean.getPKey();
		System.out.println(pk);
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session hSession = factory.getCurrentSession();
		System.out.println("第二次交易要開始");
//		try {
//			System.out.println("第二次交易開始");
//			Transaction ts = hSession.beginTransaction();
			RestaurantType rst = new RestaurantTypeImpl(HibernateUtil.getSessionFactory().getCurrentSession());
			List<String> listt = rst.queryRestaurantTypes();
			session.setAttribute("resTypes", listt);
			TravelType tst = new TravelTypeImpl(HibernateUtil.getSessionFactory().getCurrentSession());
			List<String> list = tst.queryTravelTypes();
			session.setAttribute("tTypes", list);
			Match match = new MatchImpl(HibernateUtil.getSessionFactory().getCurrentSession());
			Integer ii=1;
			List<MatchesBean> mb = match.showFriends(pk);
			List<MatchesBean> mt = match.showTodayMatch(pk);
			List<MatchingBean> td = match.todayRequest(0);
			session.setAttribute("already", 0);
			for (MatchingBean m : td) {
				if (m.getMemberID() == pk) {
					session.setAttribute("already", 1);
				}
			}
			session.setAttribute("showFriends", mb);
			session.setAttribute("showTodayMatch", mt);

		chain.doFilter(request, response);
//		HibernateUtil.closeSessionFactory();
//		ts.commit();
//		} catch (Exception e) {
//			hSession.getTransaction().rollback();
//			e.printStackTrace();
//		}
	}

	public void init(FilterConfig fConfig) throws ServletException {
	}

}
