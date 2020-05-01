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

import social.bean.MatchRequestBean;
import social.service.MatchImpl;

@WebServlet("/social/mr.do")
public class MatchRequest extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		// 讀取輸入資料
//		  int matchID                    =request.getParameter(matchID);
//		  int memberID                   =request.getParameter(memberID);
		Integer memeberID = 1;
		String ageTopLike = nullFix(request.getParameter("aTLike"));
		String ageBottomLike = nullFix(request.getParameter("aBLike"));
		String heightLike = nullFix(request.getParameter("hLike"));
		String weightLike = nullFix(request.getParameter("wLike"));
		String genderLike = nullFix(request.getParameter("gLike"));
		String interestedRestaurantType = nullFix(request.getParameter("fLike"));
		String tourTypeLike = nullFix(request.getParameter("tLike"));
		Date requestDay = new Date();
		// 進行必要的型態轉換，
		
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
		if (request.getParameter("aTlike")==null && request.getParameter("aBLike") == null
				&& request.getParameter("hLike") == null && request.getParameter("wLike") == null
				&& request.getParameter("gLike") == null && request.getParameter("fLike") == null
				&& request.getParameter("tLike") == null) {
			error.put("noFill", "至少需填一項配對條件");
		}
		if (!error.isEmpty()) {
			RequestDispatcher rd = request.getRequestDispatcher("/social/Match.jsp");
			rd.forward(request, response);
		}else {

		MatchRequestBean mrb = new MatchRequestBean(memeberID, ageTopLike2, ageBottomLike2, heightLike2, weightLike2,
				genderLike2, interestedRestaurantType, tourTypeLike, requestDay);
		MatchImpl mri = new MatchImpl();
		mri.insertMatchRequest(mrb);
		
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
