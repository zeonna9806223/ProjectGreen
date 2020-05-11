package restaurant.resController;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import restaurant.resBean.RestaurantBean;
import restaurant.resService.IRestaurantService;
import restaurant.resService.RestaurantServiceImp;
import _00_init.util.HibernateUtil;

@WebServlet("/restaurant/InsertintoServlet.do")
public class CreateDeleteResServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public CreateDeleteResServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// 刪除
		request.setCharacterEncoding("UTF-8");
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session currentSession = sessionFactory.getCurrentSession();
		HttpSession session = request.getSession();

		RestaurantBean rBean = new RestaurantBean();
		// getParameter需要強制轉行int
		rBean.setRestaurantID(Integer.parseInt(request.getParameter("id")));
		rBean.setRestaurantName(request.getParameter("name"));
		rBean.setRestaurantType(request.getParameter("type"));
		rBean.setRestaurantZone(request.getParameter("zone"));
		rBean.setRestaurantAddress(request.getParameter("address"));
		rBean.setRestaurantPx(request.getParameter("px"));
		rBean.setRestaurantPy(request.getParameter("py"));
		rBean.setRestaurantPhone(request.getParameter("phone"));
		try {
			currentSession.beginTransaction();	
			IRestaurantService service;
			service = new RestaurantServiceImp(currentSession);
			service.deleteRestaurant(rBean);

			// 因為畫面看起來像沒刪除不會自動更新,所以一些程式碼更新畫面
			List<RestaurantBean> restaurants = service.search("請選擇", "請選擇");
			session.setAttribute("queryresult", restaurants);
			response.sendRedirect(request.getContextPath() + "/restaurant/rSearchResult.jsp");
			currentSession.getTransaction().commit();
			return;
		} catch (Exception e) {
			e.printStackTrace();
			currentSession.getTransaction().rollback();
		}
		return;

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 新增
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session currentSession = sessionFactory.getCurrentSession();

		request.setCharacterEncoding("UTF-8");
		Map<String, String> errorMsg = new HashMap<String, String>();
		HttpSession session = request.getSession();
		request.setAttribute("MsgMap", errorMsg); // 顯示錯誤訊息
		currentSession.beginTransaction();	

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
//		rBean.setRestaurantID(Integer.parseInt(request.getParameter("id")));
		rBean.setRestaurantName(request.getParameter("name"));
		rBean.setRestaurantType(request.getParameter("type"));
		rBean.setRestaurantZone(request.getParameter("zone"));
		rBean.setRestaurantAddress(request.getParameter("address"));
		rBean.setRestaurantPx(request.getParameter("px"));
		rBean.setRestaurantPy(request.getParameter("py"));
		rBean.setRestaurantPhone(request.getParameter("phone"));
//		
		try {
			IRestaurantService service = new RestaurantServiceImp(currentSession);
			service.insertRestaurant(rBean);
			// 因為畫面看起來像沒刪除不會自動更新,所以一些程式碼更新畫面
			List<RestaurantBean> restaurants = service.search("請選擇", "請選擇");
			session.setAttribute("queryresult", restaurants);
			response.sendRedirect(request.getContextPath() + "/restaurant/rSearchResult.jsp");
			currentSession.getTransaction().commit();
			return;
		} catch (Exception e) {
			e.printStackTrace();
			currentSession.getTransaction().rollback();
		}

	}

}
