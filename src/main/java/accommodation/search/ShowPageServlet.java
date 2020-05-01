package accommodation.search;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import accommodation.mod02.model.AccNumBean;
import accommodation.mod02.service.AccNumService;
import accommodation.mod02.service.AccNumServiceImpl;

@WebServlet("/accommodation/search/ShowPageServlet")
public class ShowPageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	SearchJdbcDao3 s = new SearchJdbcDao3();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String hotel = request.getParameter("h");
		AccNumService as = new AccNumServiceImpl();
		int hotelId = as.getHotelId(hotel);
		as.updateViewNum(hotelId);
		System.out.println(hotel);

		Map<String, TestBean42> map = s.hotelInfo(hotel);
		request.setAttribute("name", hotel);
		request.setAttribute("hInfo", map);
		RequestDispatcher rd = request.getRequestDispatcher("/accommodation/search/Show2.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String bookNum = request.getParameter("booking");
		if (bookNum != null) {
			String hotelname = request.getParameter("hname");
			AccNumService as = new AccNumServiceImpl();
			int hotelId = as.getHotelId(hotelname);
			String plus = as.updateBookNum(hotelId);
			RequestDispatcher rd = request.getRequestDispatcher("Show2.jsp");
			rd.forward(request, response);
		}
	}

}
