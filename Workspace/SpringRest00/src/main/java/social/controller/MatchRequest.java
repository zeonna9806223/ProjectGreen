package social.controller;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
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
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import member.model.MemberBean;
import social.model.bean.MatchRequestBean;
import social.service.Match;
import social.service.MatchImpl;
@Controller
@RequestMapping(value = "/social/mr.do")
@WebServlet("/social/mr.do")
public class MatchRequest extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Autowired 
	Match mri;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		HttpSession session = ((HttpServletRequest) request).getSession();
		MemberBean memberBean = (MemberBean) session.getAttribute("LoginOK");
		Integer pk = memberBean.getPKey();
		System.out.println(pk);
//		MemberBean memberBean = (MemberBean) session.getAttribute("LoginOK");
//		Integer pk = memberBean.getPKey();
		String ageTopLike = nullFix(request.getParameter("aTLike"));
		String ageBottomLike = nullFix(request.getParameter("aBLike"));
		System.out.println("atileke"+request.getParameter("aTLike"));
		String heightLike = nullFix(request.getParameter("hLike"));
		String weightLike = nullFix(request.getParameter("wLike"));
		String genderLike = nullFix(request.getParameter("gLike"));
		String interestedRestaurantType = nullFix(request.getParameter("fLike"));
		String tourTypeLike = nullFix(request.getParameter("tLike"));
		java.sql.Date requestDay = new java.sql.Date(new Date().getTime()) ;
		// 進行必要的型態轉換，
//		Integer ii = 1;
		Integer ageTopLike2 = Integer.valueOf(ageTopLike);
		Integer ageBottomLike2 = Integer.valueOf(ageBottomLike);
		Integer heightLike2 = Integer.valueOf(heightLike);
		Integer weightLike2 = Integer.valueOf(weightLike);
		Integer genderLike2 = Integer.valueOf(genderLike);
		// 檢查輸入資料
		Map<String, String> error = new HashMap<String, String>();
		request.setAttribute("error", error);
		if (ageTopLike2 < ageBottomLike2) {
			error.put("over", "年齡上限小於下限");
		}
		if (request.getParameter("aTLike")==null && request.getParameter("aBLike") == null
				&& request.getParameter("hLike") == null && request.getParameter("wLike") == null
				&& request.getParameter("gLike") == null && request.getParameter("fLike") == null
				&& request.getParameter("tLike") == null) 
		{
			error.put("noFill", "至少需填一項配對條件");
		}
		if (!error.isEmpty()) {
			RequestDispatcher rd = request.getRequestDispatcher("/social/Match.jsp");
			rd.forward(request, response);
		}else {

//			SessionFactory factory = HibernateUtil.getSessionFactory();
//			Session hSession = factory.getCurrentSession();
//			MatchImpl mri = new MatchImpl(HibernateUtil.getSessionFactory().getCurrentSession());
//			try {
//				Transaction ts = hSession.beginTransaction();
				MatchRequestBean mrb = new MatchRequestBean(pk, ageTopLike2, ageBottomLike2, heightLike2, weightLike2,
						genderLike2, interestedRestaurantType, tourTypeLike, requestDay);
				mri.insertMatchRequest(mrb);
//				ts.commit();
//			} catch (Exception e) {
//				hSession.getTransaction().rollback();
//				e.printStackTrace();
//			}	
		
		String url = request.getContextPath() + "/social/Match.jsp";
		String targetURL = response.encodeRedirectURL(url);
		response.sendRedirect(targetURL);
		}
	}

	public String nullFix(String string) {
		if (string == null) {
			return new String("-1");
		} else {
			return string;
		}
	}
}
