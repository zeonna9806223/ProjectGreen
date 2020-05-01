package social.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import social.bean.FriendInfoBean;
import social.bean.MatchesBean;
import social.service.Match;
import social.service.MatchImpl;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;

@WebServlet("/social/mr2.do")
public class FriendInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("application/Json; charset=UTF-8");
//		response.setContentType("charset=UTF-8");

		String H = request.getParameter("H");
		System.out.println(H);
		Integer HH = Integer.valueOf(H);
		Match match = new MatchImpl();
		FriendInfoBean fInfo = match.showFriendInfo(HH);
//		RequestDispatcher rd = request.getRequestDispatcher("/social/Match.jsp");
//		rd.forward(request, response); //*****千萬不要放，放了ajax會趴路徑的資料出去
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
//		List<FriendInfoBean> fInfos = new ArrayList<>(); 
//		fInfos.add(fInfo); 
//		String jsonlist = mapper.writeValueAsString(fInfos); 
//		String noway = mapper.writeValueAsString(fInfo);
//		System.out.println(jsonlist);
//		JSONObject.fromObject(fInfo).toString();  //contains null object
//		JSONArray json = JSONArray.fromObject(fInfo);
//		String str = json.toString(); //將json物件轉換為字串
		response.getWriter().write(ff);
		response.getWriter().flush();
		response.getWriter().close();
	}
}
