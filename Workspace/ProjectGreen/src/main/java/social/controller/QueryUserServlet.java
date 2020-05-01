package social.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import social.model.MemberBean2;
//新增do post ;查詢用 do get & send redirect
//控制器步驟 1.讀取使用者輸入資料 2.進行必要的型態轉換 3.檢查使用者輸入的資料；4.呼叫model元件(UserServiceImpl)
import social.service.UserServiceImpl;

@WebServlet("/QueryUserServlet")
public class QueryUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//控制器準備要呼叫service
		UserServiceImpl uService =new UserServiceImpl();
		List<MemberBean2> list = uService.queryUsers();
		//做成屬性物件 <"識別字串",屬性物件>
		request.setAttribute("memberList", list);
		//交棒至指定JSP>>request.getRequestDispatcher("path")
		RequestDispatcher rd =request.getRequestDispatcher("/social/ListMembers.jsp");
		rd.forward(request, response);
		return;
	}

}
