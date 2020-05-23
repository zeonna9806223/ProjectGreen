//package member.controller;
//
//import java.io.IOException;
//import java.io.InputStream;
//import java.sql.Blob;
//import java.sql.Timestamp;
//import java.util.Collection;
//import java.util.HashMap;
//import java.util.Map;
//import java.util.regex.Matcher;
//import java.util.regex.Pattern;
//
//import javax.servlet.RequestDispatcher;
//import javax.servlet.ServletException;
//import javax.servlet.annotation.MultipartConfig;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;
//import javax.servlet.http.Part;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.validation.BindingResult;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.SessionAttributes;
//import member.util.GlobalService;
//import member.util.SystemUtils2018;
//import member.model.Mem;
//import member.service.MemService;
//import member.service.impl.MemServiceImpl;
//
//@MultipartConfig(location = "", fileSizeThreshold = 5 * 1024 * 1024, maxFileSize = 1024 * 1024
//		* 500, maxRequestSize = 1024 * 1024 * 500 * 5)
//
//@Controller
//@SessionAttributes(names= {"Member"})
//public class RegisterServletMP{
//
//	@Autowired
//	private MemService memService;
//	private Mem mem;
//	
//	@RequestMapping(path = "/SignUp", method = RequestMethod.GET)	
//	public String showSignUp() {
//		return "SignUp";
//	}
//	
//	@RequestMapping(path ="/SignUpCheck", method = RequestMethod.POST)
//	public  String processSignUpCheck(Mem bean,HttpServletRequest request, HttpServletResponse response,
//			@RequestParam("memberAccount") String memberAccount,
//			@RequestParam("email") String email,
//			@RequestParam("password") String password,
//			@RequestParam("gender") Integer gender,
//			@RequestParam("memberAddress") String memberAddress,
//			@RequestParam("memberCellPhone") String memberCellPhone,
//			@RequestParam("repassword") String repassword,
//			@RequestParam("name") String name, Model m) throws IOException, ServletException {
//		Map<String, String> errMsg = new HashMap<>();
//		
//		
//		
//		
//		if (memberAccount == null || memberAccount.trim().length() == 0) {
//			errMsg.put("errmemberAccount", "帳號不得為空");
//		} else {
//			try {
//				Mem mem = memService.getMem(memberAccount);
//				if (mem != null) {
//					errMsg.put("errmemberAccount", "帳號已經註冊過");
//				}
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
//		}
//		if (email == null || email.trim().length() == 0) {
//			errMsg.put("errEmail", "電子信箱不得為空");
//		} else {
//			try {
//				Mem mem = memService.getMem(memberAccount);
//				if (mem != null) {
//					errMsg.put("errEmail", "電子信箱已經註冊過");
//				}
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
//		}
//		
//		if (password == null || password.trim().length() == 0) {
//			errMsg.put("errPassword", "密碼不得為空");
//		} else if (!password.equals(repassword)) {
//			errMsg.put("errPassword", "兩次密碼不一致");
//		}
//
//		if (name == null || name.trim().length() == 0) {
//			errMsg.put("errName", "姓名不得為空");
//		}
//		if (memberAddress == null || memberAddress.trim().length() == 0) {
//			errMsg.put("errAddr", "地址欄必須輸入");
//		}
//		if (memberCellPhone == null || memberCellPhone.trim().length() == 0) {
//			errMsg.put("errTel", "電話號碼欄必須輸入");
//		}
//
//		if (!errMsg.isEmpty()) {
//			m.addAttribute("email", email);
//			m.addAttribute("name", name);
//			m.addAttribute("errMsg", errMsg);
//
//			return"/SignUp";
//		}else{
//			try {
//			bean.setRegisterTime(new Timestamp(System.currentTimeMillis()));
//			memService.saveMem(bean);
//			
//			} catch (org.hibernate.exception.ConstraintViolationException e) {
//				return "index";
//			} catch (Exception ex) {
//				System.out.println(ex.getClass().getName() + ", ex.getMessage()=" + ex.getMessage());
//
//				return "index";
//			}
//			
//			return "index";
//	}
//		
//		
//		
//
//
//
//	}
//}