package member.controller;
//package _02.controller;
//
//import java.sql.Blob;
//import java.sql.Timestamp;
//
//import javax.servlet.ServletContext;
//import javax.servlet.http.HttpServletRequest;
//import javax.sql.rowset.serial.SerialBlob;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.validation.BindingResult;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.SessionAttributes;
//import org.springframework.web.multipart.MultipartFile;
//
//import _02.service.MemService;
//import crm.model.Category;
//import crm.model.Hobby;
//import crm.model.Member;
//import crm.service.MemberService;
//import crm.validators.MemberValidator;
//
//
//@Controller
//@SessionAttributes(names= {"Member"})
//public class SignUpCheck {
//
//@Autowired
//MemService memService;
//
//@Autowired
//ServletContext context;
//
//
//@RequestMapping(path = "/SignUp", method = RequestMethod.GET)	
//public String add(
//			@ModelAttribute("member") /* @Valid */ Member member, 
//			BindingResult result, Model model,
//			HttpServletRequest request) {
//		MemberValidator validator = new MemberValidator();
//		// 呼叫Validate進行資料檢查
//		validator.validate(member, result);
//		if (result.hasErrors()) {
////          下列敘述可以理解Spring MVC如何處理錯誤			
////			List<ObjectError> list = result.getAllErrors();
////			for (ObjectError error : list) {
////				System.out.println("有錯誤：" + error);
////			}
//			return "crm/insertMember";
//		}
//		MultipartFile picture = member.getProductImage();
//		String originalFilename = picture.getOriginalFilename();
//		if (originalFilename.length() > 0 && originalFilename.lastIndexOf(".") > -1) {
//			member.setFileName(originalFilename);
//		}
//		// 建立Blob物件，交由 Hibernate 寫入資料庫
//		if (picture != null && !picture.isEmpty()) {
//			try {
//				byte[] b = picture.getBytes();
//				Blob blob = new SerialBlob(b);
//				member.setImage(blob);
//			} catch (Exception e) {
//				e.printStackTrace();
//				throw new RuntimeException("檔案上傳發生異常: " + e.getMessage());
//			}
//		}
//
//
//		Timestamp adminTime = new Timestamp(System.currentTimeMillis());
//		member.setAdmissionTime(adminTime);
//		
//		try {
//			memberService.save(member);
//		} catch (org.hibernate.exception.ConstraintViolationException e) {
//			result.rejectValue("account", "", "帳號已存在，請重新輸入");
//			return "crm/insertMember";
//		} catch (Exception ex) {
//			System.out.println(ex.getClass().getName() + ", ex.getMessage()=" + ex.getMessage());
//			result.rejectValue("account", "", "請通知系統人員...");
//			return "crm/insertMember";
//		}
//
//
//
//
//
//
//
//
//
//
////package _02.controller;
////
////import java.util.HashMap;
////import java.util.Map;
////
////import org.springframework.beans.factory.annotation.Autowired;
////import org.springframework.stereotype.Controller;
////import org.springframework.ui.Model;
////import org.springframework.web.bind.annotation.RequestMapping;
////import org.springframework.web.bind.annotation.RequestMethod;
////import org.springframework.web.bind.annotation.RequestParam;
////import org.springframework.web.bind.annotation.SessionAttributes;
////
////import _02.model.Mem;
////import _02.service.MemService;
////
////
//////@WebServlet("/SignUpCheck")
////@Controller
////@SessionAttributes(names= {"Member"})
////public class SignUpCheck  {
////	@Autowired
////	private MemService memService;
////	private Mem mem;
////
////	
////	@RequestMapping(path = "/SignUp", method = RequestMethod.GET)	
////	public String showSignUp() {
////		return "SignUp";
////	}
////		@RequestMapping(path ="/SignUpCheck", method = RequestMethod.POST)
////		public String processSignUpCheck(
////				@RequestParam("email") String email,
////				@RequestParam("password") String password,
////				@RequestParam("repassword") String repassword,
////				@RequestParam("repassword") String name, Model m) {
////			Map<String, String> errMsg = new HashMap<>();
////			
////			if (email == null || email.trim().length() == 0) {
////				errMsg.put("errEmail", "電子信箱不得為空");
////			} else {
////				try {
////					Mem mem = memService.getMem(id);
////					if (mem != null) {
////						errMsg.put("errEmail", "電子信箱已經註冊過");
////					}
////				} catch (Exception e) {
////					e.printStackTrace();
////				}
////			}
////			if (password == null || password.trim().length() == 0) {
////				errMsg.put("errPassword", "密碼不得為空");
////			} else if (!password.equals(repassword)) {
////				errMsg.put("errPassword", "兩次密碼不一致");
////			}
////
////			if (name == null || name.trim().length() == 0) {
////				errMsg.put("errName", "姓名不得為空");
////			}
////
////			if (!errMsg.isEmpty()) {
////				m.addAttribute("email", email);
////				m.addAttribute("name", name);
////				m.addAttribute("errMsg", errMsg);
////
////				return"/SignUp";
////			}
////			try {
////				Mem member=SpringUtil.getBean(MemberBean.class);
////				member.setEmail(email);
////				member.setPassword(password);
////				member.setName(name);
////				if( memberService.create(member)) {		
////						member = memberService.getByEmail(email);
////						m.addAttribute("Member", member);
////					}
////			} catch (Exception e) {
////				e.printStackTrace();
////			}
////
////			return "HomePage";
////		}
////
////}
