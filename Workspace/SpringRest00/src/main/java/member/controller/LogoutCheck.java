package member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import member.util.SessionService;


@Controller
public class LogoutCheck {
//	private static final long serialVersionUID = 1L;

//	protected void doGet(HttpServletRequest request, HttpServletResponse response)
//	        throws ServletException, IOException {
//		doPost(request, response);
//	}
//
	@RequestMapping(path = "/Logout", method = RequestMethod.GET)
	protected String doPost(HttpServletRequest request, HttpServletResponse response)
	        throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		if (SessionService.isLogined(session)) {
			session.invalidate();			
		}
		return "index";
		

	}
}
