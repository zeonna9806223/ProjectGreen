//package member.controller;
//
//import java.io.IOException;
//import java.io.InputStream;
//import java.sql.Blob;
//import java.sql.Clob;
//import java.sql.Date;
//import java.sql.Timestamp;
//import java.util.Collection;
//import java.util.HashMap;
//import java.util.Map;
//
//import javax.servlet.RequestDispatcher;
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;
//import javax.servlet.http.Part;
//
//import member.model.MemberBean;
//import member.service.GlobalService;
//import member.service.MemberService;
//import member.service.SystemUtils2018;
//import member.service.impl.MemberServiceImpl;
//
//@WebServlet("/member/memberDetail.do")
//public class MemberDetailMP extends HttpServlet {
//
//		private static final long serialVersionUID = 1L;
//	 
//		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		       doPost(request, response);
//			}
//		
//		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//			request.setCharacterEncoding("UTF-8");
//			// 只要舊的Session物件，如果找不到，不要建立新的Session物件，直接傳回 null
//			HttpSession session = request.getSession(false); 
//			
//			if (session == null) {
//				// 請使用者登入
//				response.sendRedirect(response.encodeRedirectURL(
//						request.getContextPath() + "/_02_login/login.jsp"));
//				return;
//			}
//		
//			
//			
//		}
//	

