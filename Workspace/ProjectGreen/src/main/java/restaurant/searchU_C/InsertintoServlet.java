package restaurant.searchU_C;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import restaurant.model.RestaurantBean;
import restaurant.search_S.RestaurantServiceImp;
import restaurant.search_S.IRestaurantService;

@WebServlet("/restaurant/InsertintoServlet.do")
public class InsertintoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public InsertintoServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		Map<String, String> errorMsg = new HashMap<String, String>();
		HttpSession session = request.getSession();
		request.setAttribute("MsgMap", errorMsg); // 顯示錯誤訊息

//		String px=request.getParameter("px");
//		String py=request.getParameter("py");
//		String phone=request.getParameter("phone");
		String name = request.getParameter("name");
		String type = request.getParameter("type");
		String zone = request.getParameter("zone");
		String address = request.getParameter("address");

		if (name == null || name.trim().length() == 0) {
			errorMsg.put("name", "名字必須輸入");
			System.out.println("名字必須輸入");
		}
		if (type == null || name.trim().length() == 0) {
			errorMsg.put("type", "餐廳類型必須選擇");
		}
		if (zone == null || name.trim().length() == 0) {
			errorMsg.put("zone", "區域必須輸入");
		}
		if (address == null || address.trim().length() == 0) {
			errorMsg.put("address", "地址必須輸入");
		}

		if (!errorMsg.isEmpty()) {
			
			RequestDispatcher rd = request.getRequestDispatcher("/restaurant/insertInto.jsp");
			rd.forward(request, response);
			return;
		} 
			RestaurantBean rBean = new RestaurantBean();
			rBean.setRestaurantName(request.getParameter("name"));
			rBean.setRestaurantType(request.getParameter("type"));
			rBean.setRestaurantZone(request.getParameter("zone"));
			rBean.setRestaurantAddress(request.getParameter("address"));
//		rBean.setRestaurantPx(request.getParameter("px"));
//		rBean.setRestaurantPy(request.getParameter("py"));
//		rBean.setRestaurantPhone(request.getParameter("phone"));
//		
			try {
				IRestaurantService dao = new RestaurantServiceImp();
				dao.insertRestaurant(rBean);
				session.setAttribute("name", rBean.getRestaurantName());
				session.setAttribute("type", rBean.getRestaurantType());
				session.setAttribute("zone", rBean.getRestaurantZone());
				session.setAttribute("address", rBean.getRestaurantAddress());
				session.setAttribute("px", rBean.getRestaurantPx());
				session.setAttribute("py", rBean.getRestaurantPy());
				session.setAttribute("phone", rBean.getRestaurantPhone());

				response.sendRedirect(request.getContextPath() + "/restaurant/rSearchResult.jsp");
				return;
			} catch (Exception e) {
				e.printStackTrace();
			}

		}

	}


