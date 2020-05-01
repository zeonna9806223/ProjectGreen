package transportation.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import transportation.dao.Impl.TransportationDaoImpl;
import transportation.model.YouBikeBean;

@WebServlet("/june/Transportation/Transportation.do")
public class TransportationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		HttpSession session =request.getSession();
		String city = request.getParameter("city");
		System.out.println(city);
		String district = request.getParameter("district");
		System.out.println(district);
		
		TransportationDaoImpl td = new TransportationDaoImpl();
		if (city != null && district ==null) {
			List<String> districts = td.queryDist(city);
			session.setAttribute("districts", districts);
			session.setAttribute("city", city);
			RequestDispatcher rd = request.getRequestDispatcher("Youbike.jsp");
			rd.forward(request, response);
			
		} else if (city == null && district !=null) {
				String city1 = session.getAttribute("city").toString();
				System.out.println(city1);
				
				List<YouBikeBean> query = td.queryDistYouBike(city1, district);
				session.setAttribute("queryYouBike", query);
				session.setAttribute("qDistrict", district);
				response.sendRedirect(request.getContextPath()+"/june/Transportation/YoubikeQuery.jsp");
		} 
		else {
			RequestDispatcher rd = request.getRequestDispatcher("Youbike.jsp");
			rd.forward(request, response);
		}
	}
	
    public TransportationServlet() {
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//		doPost(request, response);
	}

	
	
	
	
}
