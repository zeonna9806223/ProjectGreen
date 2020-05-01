package restaurant.searchAll_C;

import java.io.IOException;
import java.util.List;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import restaurant.model.RestaurantBean;
import restaurant.search_S.RestaurantServiceImp;


@WebServlet("/restaurant/queryall.do")
public class QueryAllServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			RestaurantServiceImp service = new RestaurantServiceImp();
			HttpSession session = request.getSession();
			List<RestaurantBean>  restaurants = service.getAllRestaurant();
			session.setAttribute("queryresult", restaurants);
		} catch(Exception e) {
			e.printStackTrace();
			request.setAttribute("error", e.getMessage());
		}
//		RequestDispatcher rd = request.getRequestDispatcher("/res_SQL_Test/restarurant_index.jsp");
//		rd.forward(request, response);
		response.sendRedirect(request.getContextPath()+"/restaurant/rSearchResult.jsp");
		return;	
		
	}
}
