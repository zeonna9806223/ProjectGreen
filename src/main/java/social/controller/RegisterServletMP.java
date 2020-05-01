package social.controller;

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

import social.service.GlobalService;
import social.service.SystemUtils2018;
import social.model.MemberBean;
import social.service.MemberService;
import social.service.impl.MemberServiceImpl;


@MultipartConfig(location = "", fileSizeThreshold = 5 * 1024 * 1024, maxFileSize = 1024 * 1024
		* 500, maxRequestSize = 1024 * 1024 * 500 * 5)

@WebServlet("/social/register/register.do")
public class RegisterServletMP extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		request.setCharacterEncoding("UTF-8"); 

		Map<String, String> errorMsg = new HashMap<String, String>();
	
		Map<String, String> msgOK = new HashMap<String, String>();

		HttpSession session = request.getSession();
		request.setAttribute("MsgMap", errorMsg); 
		session.setAttribute("MsgOK", msgOK);      

		String memberID = "";
		String password = "";
		String password2 = "";
		String name = "";
		String email = "";
		String addr = "";
		String tel = "";
		String fileName = "";
		long sizeInBytes = 0;
		InputStream is = null;
		String gender = "";/////
		
		Collection<Part> parts = request.getParts();
		GlobalService.exploreParts(parts, request);
		
		if (parts != null) { 
			for (Part p : parts) {
				String fldName = p.getName();
				String value = request.getParameter(fldName);

				
				if (p.getContentType() == null) {
					if (fldName.equals("mid")) {
						memberID = value;
					} else if (fldName.equals("password")) {
						password = value;
					} else if (fldName.equalsIgnoreCase("password2")) {
						password2 = value;
					} else if (fldName.equalsIgnoreCase("name")) {
						name = value;
					} else if (fldName.equalsIgnoreCase("eMail")) {
						email = value;
					} else if (fldName.equalsIgnoreCase("address")) {
						addr = value;
					} else if (fldName.equalsIgnoreCase("tel")) {
						tel = value;
					}
				} else {
					// 取出圖片檔的檔名
					fileName = GlobalService.getFileName(p);
					// 調整圖片檔檔名的長度，需要檔名中的附檔名，所以調整主檔名以免檔名太長無法寫入表格
					fileName = GlobalService.adjustFileName(fileName, GlobalService.IMAGE_FILENAME_LENGTH);
					if (fileName != null && fileName.trim().length() > 0) {
						sizeInBytes = p.getSize();
						is = p.getInputStream();
					} else {
						errorMsg.put("errPicture", "必須挑選圖片檔");
					}
				}
			}

			if (memberID == null || memberID.trim().length() == 0) {
				errorMsg.put("errorIDEmpty", "帳號欄必須輸入");
			}
			if (password == null || password.trim().length() == 0) {
				errorMsg.put("errorPasswordEmpty", "密碼欄必須輸入");
			}
			if (password2 == null || password2.trim().length() == 0) {
				errorMsg.put("errorPassword2Empty", "密碼確認欄必須輸入");
			}
			if (password.trim().length() > 0 && password2.trim().length() > 0) {
				if (!password.trim().equals(password2.trim())) {
					errorMsg.put("errorPassword2Empty", "密碼欄必須與確認欄一致");
					errorMsg.put("errorPasswordEmpty", "*");
				}
			}

			if (name == null || name.trim().length() == 0) {
				errorMsg.put("errorName", "姓名欄必須輸入");
			}
			if (addr == null || addr.trim().length() == 0) {
				errorMsg.put("errorAddr", "地址欄必須輸入");
			}
			if (email == null || email.trim().length() == 0) {
				errorMsg.put("errorEmail", "電子郵件欄必須輸入");
			}
			if (tel == null || tel.trim().length() == 0) {
				errorMsg.put("errorTel", "電話號碼欄必須輸入");
			}

		} else {
			errorMsg.put("errTitle", "此表單不是上傳檔案的表單");
		}

		if (!errorMsg.isEmpty()) {

			RequestDispatcher rd = request.getRequestDispatcher("register.jsp");
			rd.forward(request, response);
			return;
		}
		try {

			MemberService service = new MemberServiceImpl();
			if (service.idExists(memberID)) {
				errorMsg.put("errorIDDup", "此帳號已存在，請換新帳號");
			} else {

				password = GlobalService.getMD5Endocing(
						GlobalService.encryptString(password));
				Timestamp ts = new java.sql.Timestamp(System.currentTimeMillis());
				Blob blob = SystemUtils2018.fileToBlob(is, sizeInBytes);
				
				MemberBean mem = new MemberBean(null, memberID, name, password, addr, email, 
						tel, "M", ts, 0.0, 0.0,	blob, fileName,gender);
				
				int n = service.saveMember(mem);
				if (n == 1) {
					msgOK.put("InsertOK", "<Font color='red'>新增成功，請開始使用本系統</Font>");
					response.sendRedirect("../../index.jsp");
					return;
				} else {
					errorMsg.put("errorIDDup", "新增此筆資料有誤(RegisterServlet)");
				}
			}
			
			if (!errorMsg.isEmpty()) {
				
				RequestDispatcher rd = request.getRequestDispatcher("register.jsp");
				rd.forward(request, response);
				return;
			}
		} catch (Exception e) {
			e.printStackTrace();
			errorMsg.put("errorIDDup", e.getMessage());
			RequestDispatcher rd = request.getRequestDispatcher("register.jsp");
			rd.forward(request, response);
		}
	}
}