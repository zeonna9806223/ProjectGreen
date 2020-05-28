package social.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import member.model.MemberBean;
import social.model.bean.FriendInfoBean;
import social.model.bean.MatchRequestBean;
import social.model.bean.MatchesBean;
import social.model.bean.MatchingBean;
import social.model.bean.MessageBean;
import social.service.Match;
import social.service.RestaurantType;
import social.service.TravelType;

@Controller
@SessionAttributes({ "listt", "list", "already", "showFriends", "showTodayMatch" })

public class MatchPageController {
	@Autowired
	RestaurantType rst;
	@Autowired
	TravelType tst;
	@Autowired
	Match match;
	@Autowired
	ServletContext ctx;

	public MatchPageController() {
	}

	@RequestMapping("/")
	public String showIndex() {
		return "redirect:index";
	}

	@RequestMapping(value = "/social/match")
	public String showPage(Model model, HttpServletRequest request,
			@SessionAttribute("LoginOK") MemberBean memberBean) {
		Integer pk = memberBean.getPKey();
		System.out.println(pk);
		System.out.println("第二次交易要開始");
		List<String> listt = rst.queryRestaurantTypes();
		model.addAttribute("resTypes", listt);
		List<String> list = tst.queryTravelTypes();
		model.addAttribute("tTypes", list);
		List<MatchesBean> mt = match.showTodayMatch(pk);
		List<MatchesBean> mb = match.showFriends(pk);
		List<MatchingBean> td = match.todayRequest(0);
		model.addAttribute("already", 0);
		for (MatchingBean m : td) {
			if (m.getMemberID() == pk) {
				model.addAttribute("already", 1);
			}
		}
		model.addAttribute("showTodayMatch", mt);
		model.addAttribute("showFriends", mb);
		return "/social/Match";
		// ***** redirect: return 映射到另一个 Controller 方法的字符串
	}

	@PostMapping(value = "/mr8.do")
	public String matchOperation(Model model, @SessionAttribute("LoginOK") MemberBean memberBean,
			HttpServletRequest request) {
//		request.setCharacterEncoding("utf-8");
		Integer pk = memberBean.getPKey();
		System.out.println(pk);
		String delete1 = nullFix(request.getParameter("delete"));
		System.out.println(delete1);
		String new1 = nullFix(request.getParameter("new"));
		Integer delete2 = Integer.valueOf(delete1);
		Integer new2 = Integer.valueOf(new1);
		if (delete1 != null) {
			match.deleteFriend(delete2, pk);
		}
		if (new1 != null) {
			match.markMatch(new2, pk);
			match.markPairDate(new2, pk);
		}
		return "redirect:" + "/social/match";
//		return "/social/match";
	}

	@PostMapping(value = "/mr.do")
	public String matchRequest(Model model, @SessionAttribute("LoginOK") MemberBean memberBean,
			HttpServletRequest request, @RequestParam(value = "aTLike", required = false) String ageTopLike,
			@RequestParam(value = "aBLike", required = false) String ageBottomLike,
			@RequestParam(value = "hLike", required = false) String heightLike,
			@RequestParam(value = "wLike", required = false) String weightLike,
			@RequestParam(value = "gLike", required = false) String genderLike,
			@RequestParam(value = "fLike", required = false) String interestedRestaurantType,
			@RequestParam(value = "tLike", required = false) String tourTypeLike) {
		Integer pk = memberBean.getPKey();
		String interestedRestaurantType2 = nullFix("fLike");
		String tourTypeLike2 = nullFix("tLike");
		java.sql.Date requestDay = new java.sql.Date(new Date().getTime());
		Integer ageTopLike2 = Integer.valueOf(nullFix(ageTopLike));
		Integer ageBottomLike2 = Integer.valueOf(nullFix(ageBottomLike));
		Integer heightLike2 = Integer.valueOf(nullFix(heightLike));
		Integer weightLike2 = Integer.valueOf(nullFix(weightLike));
		Integer genderLike2 = Integer.valueOf(nullFix(genderLike));
		// 檢查輸入資料
		Map<String, String> error = new HashMap<String, String>();
		request.setAttribute("error", error);
		if (ageTopLike2 < ageBottomLike2) {
			error.put("over", "年齡上限小於下限");
		}
		if (request.getParameter("aTLike") == null && request.getParameter("aBLike") == null
				&& request.getParameter("hLike") == null && request.getParameter("wLike") == null
				&& request.getParameter("gLike") == null && request.getParameter("fLike") == null
				&& request.getParameter("tLike") == null) {
			error.put("noFill", "至少需填一項配對條件");
		}
		if (!error.isEmpty()) {
			return "forward:" + "/social/match";
		} else {
			MatchRequestBean mrb = new MatchRequestBean(pk, ageTopLike2, ageBottomLike2, heightLike2, weightLike2,
					genderLike2, interestedRestaurantType2, tourTypeLike2, requestDay);
			match.insertMatchRequest(mrb);
			return "redirect:" + "/social/match";
			
		}
	}

	public String nullFix(String string) {
		if (string == null) {
			return new String("-1");
		} else {
			return string;
		}
	}

//	public ResponseEntity<List<BookBeanWithImageData>>  allBooksWithImageData()  {
//		List<BookBeanWithImageData> list = service.getAllBooksWithImageData();
//		ResponseEntity<List<BookBeanWithImageData>> re = new ResponseEntity<>(list, HttpStatus.OK);
//		return re;
//	}
	@RequestMapping(value = "/mr2.do")
	public ResponseEntity<List<Map<String, String>>> friendInfo(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
//		response.setContentType("application/Json; charset=UTF-8");
		String H = request.getParameter("H");
		System.out.println(H);
		Integer HH = Integer.valueOf(H);
		FriendInfoBean fInfo = null;
		fInfo = match.showFriendInfo(HH);
//		ObjectMapper mapper = new ObjectMapper();
		Map<String, String> formatData = new LinkedHashMap<>();
		formatData.put("memberId", String.valueOf(fInfo.getMemberId()));
		formatData.put("memberName", fInfo.getMemberName());
		String gender;
		gender = (fInfo.getGender() == 1) ? "男" : "女";
		formatData.put("gender", gender);
		int age = match.getAge(fInfo.getMemberBithday());
		formatData.put("memberBithday", String.valueOf(age));
		formatData.put("memberName", String.valueOf(fInfo.getMemberName()));
		String si;
		si = (fInfo.getMemberIntroduce() == null) ? "竟然沒填" : fInfo.getMemberIntroduce();
		formatData.put("memberIntroduce", si);
		String h;
		String g = fInfo.getImageToJason();
		if (fInfo.getProfileHeight() == 3) {
			h = "高挑";
		} else if (fInfo.getProfileHeight() == 2) {
			h = "中等";
		} else {
			h = "小隻";
		}
		formatData.put("profileHeight", h);
		String w;
		if (fInfo.getProfileHeight() == 3) {
			w = "肉肉";
		} else if (fInfo.getProfileHeight() == 2) {
			w = "中等";
		} else {
			w = "偏瘦";
		}
		formatData.put("profileWeight", w);
		formatData.put("profile", g);
		List<Map<String, String>> jBraket = new ArrayList<>();
		jBraket.add(formatData);
//		String ff = mapper.writeValueAsString(jBraket);
		ResponseEntity<List<Map<String, String>>> re = new ResponseEntity<>(jBraket, HttpStatus.OK);
		return re;
	}

	@RequestMapping(value = "/mr3.do")
	public ResponseEntity<List<MessageBean>> showMessage(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String H = request.getParameter("H");
		String Z = request.getParameter("Z");
		Integer HH = Integer.valueOf(H);
		Integer ZZ = Integer.valueOf(Z);
		List<MessageBean> showMessage = match.showMessage(ZZ, 0);
		System.out.println("ssssize"+showMessage.size());
		ResponseEntity<List<MessageBean>> re = new ResponseEntity<>(showMessage, HttpStatus.OK);
		return re;
	}
	
	@RequestMapping(value = "/mr4.do")
	public ResponseEntity<List<MessageBean>> showMore(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		System.out.println("有近來");
		String H = request.getParameter("H");
		String Z = request.getParameter("Z");
		String C = request.getParameter("C");
		Integer HH = Integer.valueOf(H);
		Integer ZZ = Integer.valueOf(Z);
		Integer CC = Integer.valueOf(C);
		List<MessageBean> showMessage = match.showMessage(ZZ, CC);
		System.out.println("ssssize"+showMessage.size());
		ResponseEntity<List<MessageBean>> re = new ResponseEntity<>(showMessage, HttpStatus.OK);
		return re;
	}
}
