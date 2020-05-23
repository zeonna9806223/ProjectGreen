package social.controller;

import java.io.IOException;
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
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import member.model.MemberBean;
import social.service.Match;
import social.service.MatchImpl;
@Controller
@RequestMapping(value = "/social/mr8.do")
@WebServlet("/social/mr8.do")
public class MatchOperation extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Autowired
	Match match;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		HttpSession session = ((HttpServletRequest) request).getSession();
		MemberBean memberBean = (MemberBean) session.getAttribute("LoginOK");
		Integer pk = memberBean.getPKey();
		System.out.println(pk);
		String delete1 = nullFix(request.getParameter("delete"));
		System.out.println(delete1);
		String new1 = nullFix(request.getParameter("new"));
		Integer delete2 = Integer.valueOf(delete1);
		Integer new2 = Integer.valueOf(new1);

//		SessionFactory factory = HibernateUtil.getSessionFactory();
//		Session hSession = factory.getCurrentSession();
//		Match match = new MatchImpl(HibernateUtil.getSessionFactory().getCurrentSession());
//		try {
//			Transaction ts = hSession.beginTransaction();
			if (delete1 != null) {
				match.deleteFriend(delete2, pk);
			}
			if (new1 != null) {
				match.markMatch(new2, pk);
				match.markPairDate(new2, pk);
			}
//			ts.commit();
//		} catch (Exception e) {
//			hSession.getTransaction().rollback();
//			e.printStackTrace();
//		}

		String url = request.getContextPath() + "/social/Match.jsp";
		String targetURL = response.encodeRedirectURL(url);
		response.sendRedirect(targetURL);
	}

	public String nullFix(String string) {
		if (string == null) {
			return new String("-1");
		} else {
			return string;
		}
	}
}
