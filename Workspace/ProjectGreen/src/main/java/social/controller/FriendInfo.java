package social.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import social.bean.FriendInfoBean;
import social.service.Match;
import social.service.MatchImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import _00_init.util.HibernateUtil;

@WebServlet("/social/mr2.do")
public class FriendInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("application/Json; charset=UTF-8");
		String H = request.getParameter("H");
		System.out.println(H);
		Integer HH = Integer.valueOf(H);
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session hSession = factory.getCurrentSession();
		FriendInfoBean fInfo=null;
//		try {
//			Transaction ts = hSession.beginTransaction();
			Match match = new MatchImpl(HibernateUtil.getSessionFactory().getCurrentSession());
			fInfo = match.showFriendInfo(HH);
			ObjectMapper mapper = new ObjectMapper();
			Map<String,String> formatData = new LinkedHashMap<>();
			formatData.put("memberId", String.valueOf(fInfo.getMemberId()));
			formatData.put("memberName",fInfo.getMemberName());
			String gender;
			gender = (fInfo.getGender() ==1) ? "男" : "女";
			formatData.put("gender",gender);
			int age = match.getAge(fInfo.getMemberBithday());
			formatData.put("memberBithday",String.valueOf(age));
			formatData.put("memberName",String.valueOf(fInfo.getMemberName()));
			String si;
			si = (fInfo.getMemberIntroduce()==null) ? "竟然沒填":fInfo.getMemberIntroduce();
			formatData.put("memberIntroduce",si);
			String h;
			if(fInfo.getProfileHeight()==3) {
				h="高挑";
			}else if(fInfo.getProfileHeight()==2){
				h="中等";
			}else{
				h="小隻";
			}
			formatData.put("profileHeight",h);
			String w;
			if(fInfo.getProfileHeight()==3) {
				w="肉肉";
			}else if(fInfo.getProfileHeight()==2){
				w="中等";
			}else{
				w="偏瘦";
			}
			formatData.put("profileWeight",w);
			List<Map<String, String>> jBraket = new ArrayList<>(); 
			jBraket.add(formatData); 
			String ff = mapper.writeValueAsString(jBraket);
			response.getWriter().write(ff);
			response.getWriter().flush();
			response.getWriter().close();
//			ts.commit();
//		} catch (Exception e) {
//			hSession.getTransaction().rollback();
//			e.printStackTrace();
//		}
	}
}
