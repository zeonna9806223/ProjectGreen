package accommodation.edit.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.SessionFactory;

import _00_init.util.HibernateUtil;
import accommodation.edit.model.bean.EditDetail;
import accommodation.edit.service.EditDetailService;
import accommodation.search.service.AccommodationNumService;
import accommodation.search.service.AccommodationService;
import accommodation.search.service.AccommodationTownService;
import accommodation.utility.AccommodationUtility;
import member.model.MemberBean;

@WebServlet("/accommodation/edit/controller/EditServlet")
public class EditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public EditServlet() {
		super();
	}

	private SessionFactory factory = HibernateUtil.getSessionFactory();

	AccommodationTownService atService = new AccommodationTownService(factory);
	AccommodationUtility aUtility = new AccommodationUtility();
	AccommodationService aService = new AccommodationService(factory);
	AccommodationNumService anService = new AccommodationNumService(factory);
	EditDetailService eService = new EditDetailService(factory);

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");

		String regionId = request.getParameter("Hregion");
		System.out.println(regionId);
		String region = atService.getRegionName(regionId);
		System.out.println(region);
		if (region != null) {
			response.setContentType("application/Json; charset=UTF-8");
			List<Map> list = atService.townChoice(region);
			String json = aUtility.jsonParse(list);
			response.getWriter().write(json);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		String status = request.getParameter("status");
		String status2 = request.getParameter("status2");
		MemberBean mBean = (MemberBean) session.getAttribute("LoginOK");
		int memberId = mBean.getPKey();

		String oidHotelName = "";
		
		// 顯示會員的旅館資料
		if (status2 != null) {
			if (status2.equals("update") || status2.equals("delete")) {
				int memberHotelId = eService.findHotelId(memberId);
				System.out.println(memberHotelId);
				List<Map> list = aService.hotelShow(memberHotelId);
				String region = atService.getRegionName((String) list.get(0).get("regionId"));
				String town = atService.getTownName((String) list.get(0).get("townId"));
				oidHotelName=(String) list.get(0).get("name");
				System.out.println( oidHotelName+"================" );
				request.setAttribute("hotel", list.get(0));
				request.setAttribute("region", region);
				request.setAttribute("town", town);
				if (status2.equals("update")) {
					RequestDispatcher rd = request.getRequestDispatcher("/accommodation/edit/Update2.jsp");
					rd.forward(request, response);
					return;
				} else if (status2.equals("delete")) {
					RequestDispatcher rd = request.getRequestDispatcher("/accommodation/edit/Delete2.jsp");
					rd.forward(request, response);
					return;
				}
			}
		}

		if (status != null) {
//			session.getAttribute("LoginOK");
			String Hname = request.getParameter("Hname");
			String Htel = request.getParameter("Htel");
			String Hemail = request.getParameter("Hemail");
			String Hweb = request.getParameter("Hweb");
			String Hregion = request.getParameter("Hregion");
			String Htown = request.getParameter("Htown");
			String Haddr = request.getParameter("Haddr");
			int Hprice = Integer.parseInt(request.getParameter("Hprice").trim());
			String region = atService.getRegionName(Hregion);
			System.out.println(region);
			String town = atService.getTownName(Htown);
			System.out.println(town);

			switch (status) {
			case "insert":
				EditDetail eBean = new EditDetail(memberId, mBean.getMemberName(), 0, Hname, Hregion, Htown, Haddr,
						Htel, Hemail, Hweb, Hprice, status);
				int memberHoteld = aService.insert(eBean, region, town);
				int editIdInsert = eService.insert(eBean, memberHoteld);
				request.setAttribute("hotel", eBean);
				request.setAttribute("insert", "insert");
				anService.insertNewHotel(memberHoteld, Hname);
				RequestDispatcher rd = request.getRequestDispatcher("/accommodation/edit/Success2.jsp");
				rd.forward(request, response);
				break;
			case "update":
				int hotelId = eService.findHotelId(memberId);
				EditDetail eBean2 = new EditDetail(memberId, mBean.getMemberName(), hotelId, Hname,
						Hregion, Htown, Haddr, Htel, Hemail, Hweb, Hprice, status);
				aService.update(eBean2, region, town);
				int editIdUpdate = eService.insert(eBean2);
				if (!oidHotelName.equals("Hname")) {
					anService.updateHotelName(hotelId, Hname);
				}
				request.setAttribute("hotel", eBean2);
				request.setAttribute("update", "update");
				RequestDispatcher rd2 = request.getRequestDispatcher("/accommodation/edit/Success2.jsp");
				rd2.forward(request, response);
				break;
			case "delete":
				EditDetail eBean3 = new EditDetail(memberId, mBean.getMemberName(), eService.findHotelId(memberId), Hname,
						Hregion, Htown, Haddr, Htel, Hemail, Hweb, Hprice, status);
				aService.delete(eBean3);
				System.out.println("delete");
				int editIdDelete = eService.insert(eBean3);
				request.setAttribute("hotel", eBean3);
				request.setAttribute("delete", "delete");
				RequestDispatcher rd3 = request.getRequestDispatcher("/accommodation/edit/Success2.jsp");
				rd3.forward(request, response);
				break;
			}
		}
	}

}
