package restaurant.resController;


import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import restaurant.resBean.RestaurantBean;
import restaurant.resService.IRestaurantService;
import restaurant.validate.resValidate;

@Controller

public class resJavaController {
	@Autowired
	IRestaurantService service;

	public resJavaController() {
	}
	//回restaurant首頁
	@GetMapping(value = "/restaurant/restaurantHome", produces = { "text/html" })
	public String restaurantHome(Model model) {
		return "restaurant/rSearchResult";
	}
	
	//搜尋所有餐廳
	@GetMapping(value = "/restaurant/queryallRestaurant", produces = { "text/html" })
	public String queryAllrestaurant(Model model) throws SQLException {
		List<RestaurantBean> restaurants = service.getAllRestaurant();
		model.addAttribute("queryresult", restaurants);
		return "restaurant/rSearchResult";
	}
	
	//用條件Zone和Type搜尋餐廳
	@GetMapping(value = "/restaurant/selectRestaurant", produces = { "text/html" })
	public String selectRestauant(@RequestParam("type") String type, @RequestParam("zone") String zone, Model model)throws SQLException {
		List<RestaurantBean> restaurants = service.search(type, zone);
		model.addAttribute("queryresult", restaurants);
		return "restaurant/rSearchResult";
	}
	
	//刪除
	@GetMapping(value = "/restaurant/deleteRes", produces = { "text/html" })
	public String deleteRestauant(@RequestParam("id")Integer id,Model model) throws SQLException {
		service.deleteRestaurant(id);
		return "restaurant/rSearchResult";
	}
	
	//   新增-------------------------以下兩個mapping一組 form form 表單特性------------------------
	@GetMapping(value="/restaurant/insertintoRestaurant", produces = { "text/html" })
	public String showinsertRestaurantForm(Model model){
		RestaurantBean rb=new RestaurantBean();
		model.addAttribute("RestaurantBean",rb);
		return "restaurant/insertInto";
	}
	@PostMapping(value="/restaurant/insertintoRestaurant", produces = { "text/html" })
	public String insertintoRestaurant (
			@ModelAttribute("RestaurantBean") RestaurantBean rb
			, BindingResult bindingResult
			) throws SQLException{
		
		System.out.println("新增餐廳: " + rb.getRestaurantName());
		new resValidate().validate(rb,bindingResult);
		
		 if (bindingResult.hasErrors()) {
			 System.out.println("======================");
			 List<ObjectError>list = bindingResult.getAllErrors();
			 for(ObjectError error:list) {
				 System.out.println("有錯誤 : "+error);
			 }
			 System.out.println("======================");
			 System.out.println("bean==>"+rb.getRestaurantName());
			 return "restaurant/insertInto";
		 }
		 service.insertRestaurant(rb);		 
		 return "restaurant/rSearchResult";
	}
//  ------------------------------------------------------------
	
//   修改~~~~~~~~~~~~~~以下兩個mapping一組 form form 表單特性~~~~~~~~~~~~~~
	@GetMapping(value = "/restaurant/updateRestaurant")
	public String showUpdateRestaurantForm(
			@RequestParam("id") Integer id, Model model) throws SQLException {
		RestaurantBean rb = service.searchById(id);
		model.addAttribute("RestaurantBean1",rb);
		return "restaurant/RestaurantUpdate";
	}
	
	@PostMapping("/restaurant/updateRestaurant")
	// BindingResult 參數必須與@ModelAttribute修飾的參數連續編寫，中間不能夾其他參數
	public String updateRestaurant(
			@ModelAttribute("RestaurantBean1") RestaurantBean rb, 
			BindingResult result, 
			Model model,
			HttpServletRequest request) throws SQLException {
		resValidate validator = new resValidate();
		validator.validate(rb, result);
		if (result.hasErrors()) {
			System.out.println("result hasErrors(), member=" + rb);
			List<ObjectError> list = result.getAllErrors();
			for (ObjectError error : list) {
				System.out.println("有錯誤：" + error);
			}
			return "restaurant/RestaurantUpdate";
		}
		System.out.println(rb.getRestaurantID());
		service.updateRestaurant(rb);
		return "restaurant/rSearchResult";
	}

//  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	
	
}
