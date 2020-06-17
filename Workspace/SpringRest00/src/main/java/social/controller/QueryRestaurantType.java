package social.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import social.model.bean.RestaurantTypeBean;
import social.service.Match;
import social.service.RestaurantType;
import social.service.RestaurantTypeImpl;
@Controller
@RequestMapping(value = "/social/match/2.do")
@WebServlet(urlPatterns = {"/social/match/2.do"})
public class QueryRestaurantType extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Autowired 
	RestaurantType rst;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//	RestaurantType rst = new RestaurantTypeImpl();
	List<String> list = rst.queryRestaurantTypes();
	ServletContext servletContext =this.getServletContext();//*****
	request.setAttribute("reTypes",servletContext.getAttribute("resTypes"));
	RequestDispatcher rd = request.getRequestDispatcher("/social/matchrequest/matchrequest.jsp");
	rd.forward(request,response);
	return;
	}

}
