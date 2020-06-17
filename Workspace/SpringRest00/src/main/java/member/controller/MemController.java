package member.controller;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.WebRequest;

import member.model.Mem;
import member.service.MemService;
import member.validate.MemValidator;

@Controller
@RequestMapping("/_02_mem")
public class MemController {

	ServletContext context;
	@Autowired
	public void setContext(ServletContext context) {
		this.context = context;
	}

	MemService service;
	
	@Autowired
	public void setService(MemService service) {
		this.service = service;
	}

	@GetMapping("/mems")
	public String getCustomers(Model model) {
		List<Mem> beans = service.getMems();
		model.addAttribute(beans);      
		// 若屬性物件為CustomerBean型別的物件，則預設的識別字串 ==> customerBean
		// 若屬性物件為List<CustomerBean>型別的物件，則預設的識別字串 ==> customerBeanList
		System.out.println(" getMems...01-15");
		return "_02_mem/ShowMems";
	}
	
	
	@GetMapping("/modifyMem/{id}")
	public String editMemForm(Model model, @PathVariable Integer id) {
		Mem bean = service.getMem(id);
		bean.setPassword1(bean.getPassword());
		model.addAttribute("mem", bean);
		return "_02_mem/EditMemForm";
	}
	@PostMapping("/modifyMem/{id2}")
//	@RequestMapping(value="/modifyCustomer/{id2}", method=RequestMethod.PUT)
//	public String editCustomer(
//			  @ModelAttribute("customerBean") CustomerBean bean,
//			  @PathVariable Integer id2, 
//			  BindingResult bindingResult 
//			) {
//		new CustomerValidator().validate(bean, bindingResult);
//		System.out.println("bean(PUT, 11-05)=" + bean);
//		if (bean.getCustomerId() == null) {
//			bean.setCustomerId(id2); 
//		}
//		
//	    
//		if (bindingResult.hasErrors()) {
//			List<ObjectError> list = bindingResult.getAllErrors();
//			for(ObjectError error : list) {
//				System.out.println("Error(PUT, 11-05): " + error);
//			}
//			System.out.println(44455566);
//			return "01_customer/CustomerForm";
//		}
//		
//		service.updateCustomer(bean);
//		String contextPath = context.getContextPath();
//		
//		return "redirect: " + contextPath + "/customers";
//	}
	
	public String modifyMemData2(
			@ModelAttribute("Mem") Mem bean 
			, BindingResult bindingResult 
			) {
			new MemValidator().validate(bean, bindingResult);
			System.out.println("修改會員(PUT, 11-05): " + bean);
			    
			if (bindingResult.hasErrors()) {
//				List<ObjectError> list = bindingResult.getAllErrors();
//				for(ObjectError error : list) {
//					System.out.println(error);
//				}
//				System.out.println("當表單資料有誤時，bean==>" + bean);
				
				return "_02_mem/EditMemForm";

			}
			System.out.println("12345 bean==>" + bean);
			service.updateMem(bean);	
			return "redirect: ../mems";
		}
	
	
	@GetMapping("/insertMem")
	public String showMemForm(Model model) {
		System.out.println("1. 本方法送出新增Mem資料的空白表單");
		Mem bean = new Mem();
//		bean.setPassword("Do!ng456");
//		bean.setPassword1("Do!ng456");
//		bean.setBirthday(java.sql.Date.valueOf("1980-5-4"));
//		bean.setLastPostTime(java.sql.Timestamp.valueOf("2019-10-14 17:50:24"));
		model.addAttribute("Mem", bean);
		return "_02_mem/MemForm";
	}
	// 
	@PostMapping("/insertMem")
	public String insertMemData(
		@ModelAttribute Mem bean 
		, BindingResult bindingResult 
		) {
		new MemValidator().validate(bean, bindingResult);
		System.out.println("新增會員: " + bean);
		    
		if (bindingResult.hasErrors()) {
			System.out.println("======================");
			List<ObjectError> list = bindingResult.getAllErrors();
			for(ObjectError error : list) {
				System.out.println("有錯誤：" + error);
			}
			System.out.println("======================");
			return "_02_mem/MemForm";
		}

		System.out.println("bean==>" + bean);
		if (bean.getMemId() != null ) {
			service.updateMem(bean);	
		} 
		bean.setRegisterTime(new Timestamp(System.currentTimeMillis()));
		service.saveMem(bean);
		return "redirect:mems";
	}
	
	@DeleteMapping(value="/modifyMem/{id}")
	public String deleteMemData(@PathVariable Integer id) {
		System.out.println(11122233);
		service.deleteMem(id);	
		return "redirect:../mems";
	}
	
	@InitBinder
	public void initBinder(WebDataBinder binder, WebRequest request) {
		// java.util.Date
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss SSS");
		dateFormat.setLenient(false);
		CustomDateEditor ce = new CustomDateEditor(dateFormat, true); 
		binder.registerCustomEditor(Date.class, ce);
		// java.sql.Date		
		DateFormat dateFormat2 = new SimpleDateFormat("yyyy-MM-dd");
		dateFormat2.setLenient(false);
		CustomDateEditor ce2 = new CustomDateEditor(dateFormat2, true); 
		binder.registerCustomEditor(java.sql.Date.class, ce2);
	}
	@RequestMapping("/index")
	public String home() {
		return "_02_mem/index";
	}
	
	@ModelAttribute
	public Mem editMem(@RequestParam(value="memId", required = false) Integer id) {
		Mem mbean = new Mem();
		if (id != null) {
			mbean = service.getMem(id);
			System.out.println("在@ModelAttribute修飾的方法 getMem()中，讀到物件:" + mbean);
		} else {
			System.out.println("在@ModelAttribute修飾的方法 getMem()中，無法讀取物件:" + mbean);
		}
		return mbean;
	}
}
