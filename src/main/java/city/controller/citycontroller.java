package city.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import citty.model.cityBean;
import citty.model.showBean;
import city.service.cityservice;


@WebServlet("/citycontroller")
public class citycontroller extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		proccessRequest(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		proccessRequest(request, response);
	}
	protected void proccessRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String yourLocation = (String)request.getParameter("YourLocation");
		if( yourLocation == null) {
		  
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		
		cityservice service= new cityservice();
		List<cityBean> citylist = service.city();
		
		for(cityBean cBean : citylist) {
			System.out.println(cBean.getTown());
		}
		
		session.setAttribute("city", citylist);
		session.setAttribute("show", new ArrayList<showBean>());
		}
		else {
			request.setCharacterEncoding("UTF-8");
			HttpSession session = request.getSession();
			
			cityservice service= new cityservice();
			List<showBean> showlist = service.show(yourLocation);
			
			for(showBean sBean : showlist) {
				System.out.printf(sBean.getName(),sBean.getTel(),sBean.getAdd());
			}
			
			session.setAttribute("show", showlist);
		}
		
		response.sendRedirect("/ProjectGreen/Attraction/view.jsp");
		//service()→city()
		//city()→dao()
		//dao return citybean
		
	}
}
