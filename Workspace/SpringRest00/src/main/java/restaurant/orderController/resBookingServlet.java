package restaurant.orderController;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/restaurant/resBookingServlet.do")
public class resBookingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();

		session.setAttribute("name", request.getParameter("name"));
		session.setAttribute("type", request.getParameter("type"));
		session.setAttribute("address",request.getParameter("address"));
		session.setAttribute("phone",request.getParameter("phone"));
		session.setAttribute("zone",request.getParameter("zone"));
		response.sendRedirect(request.getContextPath() + "/restaurant/bookingRes.jsp");
		return;
//		RestaurantBean memoryBean = new RestaurantBean();
//		memoryBean.setRestaurantAddress(address);
//		memoryBean.setRestaurantName(name);
//		memoryBean.setRestaurantPhone(phone);
//		memoryBean.setRestaurantType(type);
//		memoryBean.setRestaurantZone(zone);
//		List<RestaurantBean> memory = new ArrayList<RestaurantBean>();
//		memory.add(memoryBean);
//		if (memory.size() > 5) {
//		//未完成
//		}
		
	}
	
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
//		BookingBean =new BookingBean();
//		rb.setrequest.getParameter("resName");

	}

}
