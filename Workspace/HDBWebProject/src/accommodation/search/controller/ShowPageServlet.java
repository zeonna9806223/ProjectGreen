package accommodation.search.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.SessionFactory;

import _00_init.util.HibernateUtil;
import accommodation.search.service.AccommodationNumService;
import accommodation.search.service.AccommodationService;

@WebServlet("/accommodation/search/ShowPageServlet")
public class ShowPageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private SessionFactory factory = HibernateUtil.getSessionFactory();
	AccommodationService aService = new AccommodationService(factory);
	AccommodationNumService anService = new AccommodationNumService(factory);
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String hotel = request.getParameter("h");
		int hotelId = aService.getHotelId(hotel);
		anService.updateViewNum(hotelId);
		System.out.println(hotel);

		 List<Map>  list = aService.hotelInfo(hotel);
		request.setAttribute("name", hotel);
		request.setAttribute("hInfo", list);
		
		RequestDispatcher rd = request.getRequestDispatcher("/accommodation/search/Show2.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String bookNum = request.getParameter("booking");
		if (bookNum != null) {
			String hotelname = request.getParameter("hname");
			
			int hotelId = aService.getHotelId(hotelname);
			anService.updateBookNum(hotelId);
			RequestDispatcher rd = request.getRequestDispatcher("Show2.jsp");
			rd.forward(request, response);
		}
	}

}
