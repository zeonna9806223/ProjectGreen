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
import social.service.RestaurantType;
import social.service.RestaurantTypeImpl;

@WebServlet(urlPatterns = {"/social/match/2.do"})
public class QueryRestaurantType extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//	RestaurantType rst = new RestaurantTypeImpl();
//	List<RestaurantTypeBean> list = rst.queryRestaurantTypes();
	ServletContext servletContext =this.getServletContext();//*****
	request.setAttribute("reTypes",servletContext.getAttribute("resTypes"));
	RequestDispatcher rd = request.getRequestDispatcher("/social/matchrequest/matchrequest.jsp");
	rd.forward(request,response);
	return;
	}

}
