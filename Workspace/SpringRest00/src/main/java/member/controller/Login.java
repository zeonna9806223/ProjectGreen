package member.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import member.model.MemberBean;
import member.service.MemberService_;
import member.service.impl.LoginServiceImpl;
import member.service.impl.MemberServiceImpl_;
import member.service.LoginService;


@Controller
@SessionAttributes(names = { "Member" })
public class Login {

	@Autowired
	private LoginServiceImpl loginServiceImpl;
		
	
	@GetMapping("/Login")
	public String showLoginCheckp() {
		return "Login";
	}

	@RequestMapping(path = "/LoginCheck", method = RequestMethod.POST)
	public String processLoginCheck(@RequestParam("memberAccount") String memberAccount, @RequestParam("password") String password,
			Model m, HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		HttpSession session = request.getSession();
		Map<String, String> errMsg = new HashMap<String, String>();
		
		if (memberAccount == null || memberAccount.trim().length() == 0) {
			errMsg.put("eptAcc", "帳號不得為空");
		}

		if (password == null || password.trim().length() == 0) {
			errMsg.put("eptPwd", "密碼不得為空");
		}
		m.addAttribute("errMsg", errMsg);
		if (!errMsg.isEmpty()) {

			return "Login";
		}
		///////////////////////////////////////////////////////
		
		LoginService loginService = new LoginServiceImpl(); 
//		password = GlobalService.getMD5Endocing(GlobalService.encryptString(password));
		MemberBean mem =null;
		try {
			mem = loginServiceImpl.checkIDPassword(memberAccount, password);
			m.addAttribute("memberAccount", memberAccount);
			m.addAttribute("password", password);
			if (mem!= null) {
				// OK, 登入成功, 將mb物件放入Session範圍內，識別字串為"LoginOK"
				session.setAttribute("LoginOK", mem);
				m.addAttribute("Member", mem);
				System.out.println(mem);
				return "index";
			}else {errMsg.put("errLogin", "電子信箱或密碼錯誤");
				return "Login";	
				}
		} catch (RuntimeException ex) {
			System.out.println("wrong");;
		}
	
		return "finish";
		
	

	
	//////////////////////////////////////////////

//	// 5.依照 Business Logic 運算結果來挑選適當的畫面
//	// 如果 errorMsgMap 是空的，表示沒有任何錯誤，交棒給下一棒
//	if (errorMsgMap.isEmpty()) {
//		if (requestURI != null) {
//			requestURI = (requestURI.length() == 0 ? request.getContextPath() : requestURI);
//			response.sendRedirect(response.encodeRedirectURL(requestURI));
//			return;
//		} else {
//			response.sendRedirect(response.encodeRedirectURL(request.getContextPath()));
//			return;
//		}
//	} else {
//		// 如果errorMsgMap不是空的，表示有錯誤，交棒給login.jsp
//		RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
//		rd.forward(request, response);
//		return;
//	}
//}

	}}
