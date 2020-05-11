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

import restaurant.resBean.RestaurantBean;
import restaurant.resService.IRestaurantService;
import restaurant.resService.RestaurantServiceImp;
import _00_init.util.HibernateUtil;

@WebServlet("/restaurant/queryall.dodo")
public class SearchResServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session currentSession = sessionFactory.getCurrentSession();

		try {
			HttpSession session = request.getSession();
//			RestaurantDaoImp2 dao = new RestaurantDaoImp2(currentSession);
//			currentSession.beginTransaction();	
			
			IRestaurantService service = new RestaurantServiceImp(currentSession);
			List<RestaurantBean> restaurants = service.getAllRestaurant();

//			把搜尋結果印在console檢查
//			for (RestaurantBean rBean : restaurants) {;
//				System.out.println(rBean.getRestaurantName());
//			}

			session.setAttribute("queryresult", restaurants);
			
//			因為把結果導入同一頁,所以這邊關Factory會有問題			
//			HibernateUtil.closeSessionFactory();
//			currentSession.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("error", e.getMessage());
//			currentSession.getTransaction().rollback();
		}

		response.sendRedirect(request.getContextPath() + "/restaurant/rSearchResult.jsp");
		return;

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session currentSession = sessionFactory.getCurrentSession();
		HttpSession session = request.getSession();
		String type = request.getParameter("type");
		String zone = request.getParameter("zone");

		if (type == "請選擇" && zone == "請選擇") {
			response.sendRedirect(request.getContextPath() + "/res_templatemo/rSearchResult.jsp");
			return;
		}
		try {
//			currentSession.beginTransaction();	
			IRestaurantService service = new RestaurantServiceImp(currentSession);
			List<RestaurantBean> restaurants = service.search(type, zone);
			session.setAttribute("queryresult", restaurants);
//			currentSession.getTransaction().commit();
			
		} catch (Exception e) {
			e.printStackTrace();
//			currentSession.getTransaction().rollback();
			
		}
		response.sendRedirect(request.getContextPath() + "/restaurant/rSearchResult.jsp");
		return;

	}
}
