package restaurant.search_C;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import restaurant.model.RestaurantBean;
import restaurant.searchDAO.IRestarurantDao;
import restaurant.searchDAO.RestaurantDaoImp;

@WebServlet("/restaurant/res_templatemo/Lab/QueryType.do")
public class searchRestaurantServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public searchRestaurantServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);

		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		String type = request.getParameter("type");
		String zone = request.getParameter("zone");
		
		if (type == "請選擇" && zone == "請選擇") {
			response.sendRedirect(request.getContextPath() + "/res_templatemo/rSearchResult.jsp");
			return;		
		}
		IRestarurantDao dao = new RestaurantDaoImp();
		List<RestaurantBean> typeRestaurant = null;
		try {

			typeRestaurant = dao.search(type, zone);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		session.setAttribute("queryresult", typeRestaurant);
		response.sendRedirect(request.getContextPath() + "/restaurant/rSearchResult.jsp");
		return;

	}
}
