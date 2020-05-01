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
import transportation.model.TaipeiMRTBean;

/**
 * Servlet implementation class TaipeiMRTServlet
 */
@WebServlet("/june/Transportation/TaipeiMRTServlet.do")
public class TaipeiMRTServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public TaipeiMRTServlet() {
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		HttpSession session =request.getSession();
		String line = request.getParameter("line");
		System.out.println(line);
		String station = request.getParameter("station");
		System.out.println(station);
		
		TransportationDaoImpl tDao = new TransportationDaoImpl();
		if (line != null && station ==null) {
			List<String> stations = tDao.queryLine(line);
			
			session.setAttribute("stations", stations);
			session.setAttribute("line", line);
			RequestDispatcher rd = request.getRequestDispatcher("TaipeiMRT.jsp");
			rd.forward(request, response);
			
		} else if (line == null && station !=null) {
				String line1 = session.getAttribute("line").toString();
				System.out.println(line1);
				List<TaipeiMRTBean> exits = tDao.queryMRT(station);
				session.setAttribute("stationExits", exits);
				session.setAttribute("qStation", station);
				response.sendRedirect(request.getContextPath()+"/june/Transportation/TaipeiMRTQuery.jsp");
		} 
		else {
			RequestDispatcher rd = request.getRequestDispatcher("TaipeiMRT.jsp");
			rd.forward(request, response);
		}
	}

}
