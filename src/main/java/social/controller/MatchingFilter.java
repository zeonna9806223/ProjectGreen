package social.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import social.bean.MatchesBean;
import social.bean.MatchingBean;
import social.bean.RestaurantTypeBean;
import social.bean.TravelTypeBean;
import social.service.Match;
import social.service.MatchImpl;
import social.service.RestaurantType;
import social.service.RestaurantTypeImpl;
import social.service.TravelType;
import social.service.TravelTypeImpl;

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
		RestaurantType rst = new RestaurantTypeImpl();
		List<RestaurantTypeBean> listt = rst.queryRestaurantTypes();
		session.setAttribute("resTypes", listt);
		TravelType tst = new TravelTypeImpl();
		List<TravelTypeBean> list = tst.queryTravelTypes();
		session.setAttribute("tTypes", list);
		Match match = new MatchImpl();
		List<MatchesBean> mb = match.showFriends();
		List<MatchesBean> mt = match.showTodayMatch();
		List<MatchingBean> td = match.todayRequest();
		session.setAttribute("already", 0);
		for(MatchingBean m :td) {
			if(m.getMemberID()==1) {
				session.setAttribute("already", 1);
			}
		}
		session.setAttribute("showFriends", mb);
		session.setAttribute("showTodayMatch", mt);
		chain.doFilter(request, response);
	}

	public void init(FilterConfig fConfig) throws ServletException {
	}

}
