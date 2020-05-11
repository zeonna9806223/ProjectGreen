package restaurant.resController;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import _00_init.util.HibernateUtil;
import restaurant.resBean.RestaurantBean;
import restaurant.resService.IRestaurantService;
import restaurant.resService.RestaurantServiceImp;

@WebServlet("/restaurant/UpdateResServlet.do")
public class UpdateResServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@SuppressWarnings("unused")
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//把資料傳給下個JSP直接透過${}顯示在畫面上
		request.setCharacterEncoding("UTF-8");
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session currentSession = sessionFactory.getCurrentSession();
		HttpSession session = request.getSession();
		currentSession.beginTransaction();
		
		session.setAttribute("id", request.getParameter("id"));
		session.setAttribute("name", request.getParameter("name"));
		session.setAttribute("type", request.getParameter("type"));
		session.setAttribute("address",request.getParameter("address"));
		session.setAttribute("phone",request.getParameter("phone"));
		session.setAttribute("zone", request.getParameter("zone"));
		session.setAttribute("px",request.getParameter("px"));
		session.setAttribute("py", request.getParameter("py"));
		response.sendRedirect(request.getContextPath() + "/restaurant/RestaurantUpdate.jsp");
		currentSession.getTransaction().commit();
		return;
	
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 執行update
		request.setCharacterEncoding("UTF-8");
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session currentSession = sessionFactory.getCurrentSession();
		HttpSession session = request.getSession();
		RestaurantBean rBean = new RestaurantBean();
		rBean.setRestaurantID( Integer.parseInt(request.getParameter("id")));
		rBean.setRestaurantName(request.getParameter("name"));
		rBean.setRestaurantType(request.getParameter("type"));
		rBean.setRestaurantZone(request.getParameter("zone"));
		rBean.setRestaurantAddress(request.getParameter("address"));
		rBean.setRestaurantPx(request.getParameter("px"));
		rBean.setRestaurantPy(request.getParameter("py"));
		rBean.setRestaurantPhone(request.getParameter("phone"));

		try {
			currentSession.beginTransaction();
			IRestaurantService service = new RestaurantServiceImp(currentSession);
			service.updateRestaurant(rBean);
			
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
