package social.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import social.bean.RestaurantTypeBean;
import social.bean.TravelTypeBean;
import social.service.RestaurantType;
import social.service.RestaurantTypeImpl;
import social.service.TravelType;
import social.service.TravelTypeImpl;


@WebServlet(urlPatterns = {"/social/match/3.do"},
loadOnStartup = 5)
public class QueryTravelType extends HttpServlet {
	private static final long serialVersionUID = 1L;
//	ServletContextEvent sce = new ServletContextEvent(null);
//	ServletContext sc = sce.getServletContext();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	TravelType tst = new TravelTypeImpl();
	List<TravelTypeBean> list = tst.queryTravelTypes();
	request.setAttribute("tTypes",list);
//	sc.setAttribute("tTypes", list);
//	RequestDispatcher rd = request.getRequestDispatcher("/socialtemp/Match.jsp");
//	rd.forward(request,response);
//	return;
	RestaurantType rst = new RestaurantTypeImpl();
	List<RestaurantTypeBean> list2 = rst.queryRestaurantTypes();
	request.setAttribute("resTypes",list2);
//	sc.setAttribute("resTypes", list2);
	RequestDispatcher rd = request.getRequestDispatcher("/social/matchrequest/matchrequest.jsp");
	rd.forward(request,response);
	return;
	}

}
