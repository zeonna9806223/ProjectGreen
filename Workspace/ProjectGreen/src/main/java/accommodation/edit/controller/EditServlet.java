package accommodation.edit.controller;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.plaf.synth.Region;

import accommodation.edit.model.EditBean;
import accommodation.edit.service.EditService;
import accommodation.edit.service.EditServiceImpl;


@WebServlet("/accommodation/edit/controller/EditServlet")
public class EditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public EditServlet() {
		super();
	}

	EditService es = new EditServiceImpl();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");

		String region2 = request.getParameter("Hregion");
		System.out.println(region2);
		String region = es.getRegionName(region2);
		System.out.println(region);
		if (region != null) {
			response.setContentType("application/Json; charset=UTF-8");
			String json = es.regionToTown(region);
			response.getWriter().write(json);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		String uname = request.getParameter("Uname");
		String hidname = request.getParameter("hidname");
		System.out.println(hidname + "yjghjgjghjg");
//		System.out.println(hidname.equals(""));
//		System.out.println(eb.getUname()+"sdvsvsvss");

		String update = request.getParameter("s");
		String delete = request.getParameter("delete");
		String delete2 = request.getParameter("delete2");
		
		EditBean eb = new EditBean();
		eb = es.findUser();

		if (uname != null && hidname != null) {
			// insert
			System.out.println("insert");
			String utel = request.getParameter("Utel");
			String uemail = request.getParameter("Uemail");

			String Hname = request.getParameter("Hname");
			String Htel = request.getParameter("Htel");
			String Hemail = request.getParameter("Hemail");
			String Hweb = request.getParameter("Hweb");
			String Hregion = request.getParameter("Hregion");// 數字字串
			String Htown = request.getParameter("Htown");
			String Haddr = request.getParameter("Haddr");
			String Hprice = request.getParameter("Hprice");
//			System.out.println(Hregion+" : "+Htown);

			EditBean hotelEditor = new EditBean(uname, utel, uemail);
			EditBean newHotel = new EditBean(Hname, Htel, Hemail, Hweb, Hregion, Htown, Haddr, Hprice);
			String status = "insert";
			es.insertA(newHotel);
			if (!eb.getUserName().contains(uname)) {
				es.insertM(hotelEditor);
				
			}
			es.insertE(newHotel, hotelEditor, status);

			response.setContentType("text/html; charset=UTF-8");
			request.setAttribute("user", hotelEditor);
			request.setAttribute("hotel", newHotel);
			RequestDispatcher rd = request.getRequestDispatcher("/accommodation/edit/Success2.jsp");
			rd.forward(request, response);
		} else if (eb.getUserName().contains(uname) && (hidname == null || hidname == "" || delete != null)) {
			// 顯示已申請人旅宿資料
			eb = es.findUserHotel(uname);
			String utel = request.getParameter("Utel");
			String uemail = request.getParameter("Uemail");
			EditBean hotelOwner = new EditBean(uname, utel, uemail);
			request.setAttribute("owner", hotelOwner);
			request.setAttribute("eb", eb);
//			System.out.println(eb.getHemail());
			System.out.println("申請旅館資料");
			if (delete != null) {
				RequestDispatcher rd = request.getRequestDispatcher("/accommodation/edit/Delete2.jsp");
				rd.forward(request, response);
			} else {
				System.out.println("up");
				RequestDispatcher rd = request.getRequestDispatcher("/accommodation/edit/Update2.jsp");
				rd.forward(request, response);
			}
			return;
		} else if (eb.getUserName().contains(hidname) && hidname != null && delete2 == null) {
			// 更新旅館資料
			System.out.println("update");
			
			String utel = request.getParameter("Utel");
			String uemail = request.getParameter("Uemail");

			String Hname = request.getParameter("Hname");
			String Htel = request.getParameter("Htel");
			String Hemail = request.getParameter("Hemail");
			String Hweb = request.getParameter("Hweb");
			System.out.println("uname: "+uname);
			String Hregion = request.getParameter("Hregion");
			String Htown = request.getParameter("Htown");
			String Haddr = request.getParameter("Haddr");
			String Hprice = request.getParameter("Hprice");
			System.out.println("hidename:"+hidname);
			EditBean hotelEditor = new EditBean(hidname, utel, uemail);
			EditBean newHotel = new EditBean(Hname, Htel, Hemail, Hweb, Hregion, Htown, Haddr, Hprice);
			String status = "update";

//			es.insertA(newHotel);
//			es.insertM(hotelEditor);
			es.insertE(newHotel, hotelEditor, status);
			es.update(newHotel);
//			request.setAttribute("user", hotelEditor);
			request.setAttribute("user", hotelEditor);
			
			request.setAttribute("Uname", hidname);
			request.setAttribute("hotel", newHotel);
			RequestDispatcher rd = request.getRequestDispatcher("/accommodation/edit/Success2.jsp");
			rd.forward(request, response);
			return;
		} else if (delete2 != null) {

			System.out.println("delete");

			String utel = request.getParameter("Utel");
			String uemail = request.getParameter("Uemail");

			String Hname = request.getParameter("Hname");
			String Htel = request.getParameter("Htel");
			String Hemail = request.getParameter("Hemail");
			String Hweb = request.getParameter("Hweb");
			String Hregion = request.getParameter("Hregion");
			String Htown = request.getParameter("Htown");
			String Haddr = request.getParameter("Haddr");
			String Hprice = request.getParameter("Hprice");
			System.out.println("hidename:"+hidname);	
			System.out.println(utel);
			EditBean hotelEditor = new EditBean(hidname, utel, uemail);
			EditBean newHotel = new EditBean(Hname, Htel, Hemail, Hweb, Hregion, Htown, Haddr, Hprice);
			String status = "delete";

			es.insertE(newHotel, hotelEditor, status);
			request.setAttribute("duser", hidname);
			request.setAttribute("dhotel", Hname);
			request.setAttribute("hotel", newHotel);
			es.delete(Hname);
			RequestDispatcher rd = request.getRequestDispatcher("/accommodation/edit/Success2.jsp");
			rd.forward(request, response);
			return;

		} else {
			System.out.println("else");
		}

	}

}
