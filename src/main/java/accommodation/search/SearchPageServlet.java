package accommodation.search;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Reader;
import java.io.Writer;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/accommodation/search/SearchPageServlet")
public class SearchPageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	SearchJdbcDao3 ss = new SearchJdbcDao3();
	TestBean tt = new TestBean();

	public SearchPageServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		String region = request.getParameter("region");
		if (region != null) {
			response.setContentType("application/Json; charset=UTF-8");
			List<String> list5 = ss.townChoice(region);
			String json = ss.jsonParse(list5);
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
		String town = request.getParameter("town");

		if (town != null) {

			Map<Integer, TestBean> map = ss.hotelChoice(town);
			request.setAttribute("hmap", map);
			String result = region+"  "+town+" 旅宿查詢結果:";
			request.setAttribute("show", result);
			
			RequestDispatcher rd = request.getRequestDispatcher("/accommodation/search/Search2.jsp");
			rd.forward(request, response);
		}

	}
}
