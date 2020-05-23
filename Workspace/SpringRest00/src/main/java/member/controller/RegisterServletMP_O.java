
package member.controller;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.Timestamp;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import member.util.GlobalService;
import member.util.SystemUtils2018;
import member.model.MemberBean;
import member.service.MemberService_;
import member.service.impl.MemberServiceImpl_;

@MultipartConfig(location = "", fileSizeThreshold = 5 * 1024 * 1024, maxFileSize = 1024 * 1024
		* 500, maxRequestSize = 1024 * 1024 * 500 * 5)

@Controller
@SessionAttributes(names= {"Member"})
public class RegisterServletMP_O{

	@Autowired
	private MemberService_ memService;
	private MemberBean mem;
	
	@RequestMapping(path = "/SignUp", method = RequestMethod.GET)	
	public String showSignUp() {
		return "SignUp";
	}
	
	@RequestMapping(path ="/SignUpCheck", method = RequestMethod.POST)
	public  String processSignUpCheck(MemberBean bean,HttpServletRequest request, HttpServletResponse response,
			@RequestParam("memberAccount") String memberAccount,
			@RequestParam("memberEmail") String memberEmail,
			@RequestParam("memberPWD") String memberPWD,
			@RequestParam("gender") Integer gender,
			@RequestParam("memberAddress") String memberAddress,
			@RequestParam("memberCellPhone") String memberCellPhone,
			@RequestParam("repassword") String repassword,
			@RequestParam("memberName") String memberName, Model m) throws IOException, ServletException {
		Map<String, String> errMsg = new HashMap<>();
		
//		String fileName = "";
//		long sizeInBytes = 0;
//		InputStream is = null;
//		
//		Collection<Part> parts = request.getParts();
//		GlobalService.exploreParts(parts, request);
//		
//		if (parts != null) { 
//			for (Part p : parts) {
//				String fldName = p.getName();
//				String value = request.getParameter(fldName);
//
//				
//				if (p.getContentType() == null) {
//					// 取出圖片檔的檔名
//					fileName = GlobalService.getFileName(p);
//					// 調整圖片檔檔名的長度，需要檔名中的附檔名，所以調整主檔名以免檔名太長無法寫入表格
//					fileName = GlobalService.adjustFileName(fileName, GlobalService.IMAGE_FILENAME_LENGTH);
//					if (fileName != null && fileName.trim().length() > 0) {
//						sizeInBytes = p.getSize();
//						is = p.getInputStream();
//					} else {
//						errMsg.put("errPicture", "必須挑選圖片檔");
//					}
//				}
//			}
//		}
		

		if (memberAccount == null || memberAccount.trim().length() == 0) {
			errMsg.put("errmemberAccount", "帳號不得為空");
		} else {
			try {
				MemberBean mem = memService.getMem(memberAccount);
				if (mem != null) {
					errMsg.put("errmemberAccount", "帳號已經註冊過");
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		if (memberEmail == null || memberEmail.trim().length() == 0) {
			errMsg.put("errEmail", "電子信箱不得為空");
		} else {
			try {
				MemberBean mem = memService.getMem(memberAccount);
				if (mem != null) {
					errMsg.put("errEmail", "電子信箱已經註冊過");
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		if (memberPWD == null || memberPWD.trim().length() == 0) {
			errMsg.put("errPassword", "密碼不得為空");
		} else if (!memberPWD.equals(repassword)) {
			errMsg.put("errPassword", "兩次密碼不一致");
		}

		if (memberName == null || memberName.trim().length() == 0) {
			errMsg.put("errName", "姓名不得為空");
		}
		if (memberAddress == null || memberAddress.trim().length() == 0) {
			errMsg.put("errAddr", "地址欄必須輸入");
		}
		if (memberCellPhone == null || memberCellPhone.trim().length() == 0) {
			errMsg.put("errTel", "電話號碼欄必須輸入");
		}

		if (!errMsg.isEmpty()) {
			m.addAttribute("memberEmail", memberEmail);
			m.addAttribute("memberName", memberName);
			m.addAttribute("errMsg", errMsg);

			return"/SignUp";
		}else{
			try {
			bean.setRegisterTime(new Timestamp(System.currentTimeMillis()));//註冊時間
			bean.setMemberPWD(GlobalService.getMD5Endocing(
				GlobalService.encryptString(memberPWD)));//加密
			memService.saveMem(bean);
			
			} catch (org.hibernate.exception.ConstraintViolationException e) {
				return "index";
			} catch (Exception ex) {
				System.out.println(ex.getClass().getName() + ", ex.getMessage()=" + ex.getMessage());

				return "index";
			}
			
			return "index";
	}
		
		
		



	}
}