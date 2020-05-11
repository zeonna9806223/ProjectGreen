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
import accommodation.search.service.AccommodationService;
import accommodation.search.service.AccommodationTownService;
import accommodation.utility.AccommodationUtility;

@WebServlet("/accommodation/search/controller/SearchPageServlet")
public class SearchPageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private SessionFactory factory = HibernateUtil.getSessionFactory();
	AccommodationService aService = new AccommodationService(factory);
	AccommodationUtility au = new AccommodationUtility();
	AccommodationTownService atService = new AccommodationTownService(factory);

	public SearchPageServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		String region = request.getParameter("region");
		System.out.println(region);
		if (region != null) {
			response.setContentType("application/Json; charset=UTF-8");
			List<Map> list = atService.townChoice(region);
			String json = au.jsonParse(list);
			response.getWriter().write(json);
		} else {
			System.out.println("region is null");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		String region = request.getParameter("region");
		String townId = request.getParameter("town");
		String town = atService.getTownName(townId);
		System.out.println( region + " "  +  town + " " + townId  );
		if (town != null) {
			List<Map> list = aService.hotelChoice(town);
//			System.out.println( list.get(0).get("0") );
			request.setAttribute("hmap", list);
			String result = region + "  " + town + " 旅宿查詢結果:";
			request.setAttribute("show", result);

			RequestDispatcher rd = request.getRequestDispatcher("/accommodation/search/Search2.jsp");
			rd.forward(request, response);
		}

	}
}
