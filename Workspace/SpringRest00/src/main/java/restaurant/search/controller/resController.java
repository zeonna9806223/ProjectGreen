package restaurant.search.controller;

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
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;

import restaurant.edit.service.ICountService;
import restaurant.model.RestaurantBean;
import restaurant.search.service.IRestaurantService;
import restaurant.validate.resValidate;

@Controller
//@RequestMapping("/resController")

public class resController {
	@Autowired
	IRestaurantService service;
	@Autowired
	IRestaurantService service1;
	@Autowired
	ICountService service2;

	public resController() {
	}

	// 回restaurant首頁
	// http://localhost:8080/SpringRest00/restaurant/restaurantHome
	@GetMapping("/restaurant/restaurantHome")
	public String restaurantHome(Model model) {
		// public String restaurantHome(Model model ,@SessionAttribute("LoginOK")
		// MemberBean memberBean,HttpServletRequest request) {
		// Integer pk = memberBean.getPKey();
		// if (pk!=null) {
		return "restaurant/resSearchLogin";
	//	return "restaurant/test";
		// }
		// return "restaurant/resSearchAdmin";
	}

	// 以城市查詢區域(Ajax 下拉式ZONE)
	@GetMapping("/restaurant/zonelist")
	public @ResponseBody String zonelist(@RequestParam(name = "cityChoosen") String city, Model m) {
		System.out.println("進resController_#zonelist");    // checkpoint
		List<String> list = service.zoneList(city);
		System.out.println("service成功，資料狀況："+list.size());    // checkpoint
		String json = new Gson().toJson(list);
		System.out.println("json狀況："+json);    // checkpoint
		return json;
	}
	// 以區域查詢餐廳類型(Ajax 下拉式ZONE)
	@GetMapping("/restaurant/typelist")
	public @ResponseBody String typeList(@RequestParam(name = "zoneChoosen") String zone, Model m) throws SQLException {
		List<String> list = service.typeList(zone);
		String json = new Gson().toJson(list);
		return json;
	}

	// 搜尋所有餐廳
	@GetMapping(value = "/restaurant/queryallRestaurant", produces = { "text/html" })
	public String queryAllrestaurant(Model model) throws SQLException {
		List<RestaurantBean> restaurants = service.getAllRestaurant();
		model.addAttribute("queryresult", restaurants);
//		return "restaurant/resSearchLogin";
		return "restaurant/RestaurantHome";

	}

	// 用條件Zone和Type搜尋餐廳
	@GetMapping(value = "/restaurant/selectRestaurant", produces = { "text/html" })
	public String selectRestauant(@RequestParam("type") String type, @RequestParam("zone") String zone,@RequestParam("city") String city, Model model)
			throws SQLException {
		List<RestaurantBean> restaurants = service.search(type,zone,city);
		model.addAttribute("queryresult", restaurants);
//		return "restaurant/resSearchLogin";
		return "restaurant/RestaurantHome";
	}

	// 刪除
	@GetMapping(value = "/restaurant/deleteRes", produces = { "text/html" })
	public String deleteRestauant(@RequestParam("id") Integer id, Model model) throws SQLException {
		service.deleteRestaurant(id);
//		return "restaurant/resSearchLogin";
		return "restaurant/RestaurantHome";
	}

	// 新增-------------------------以下兩個mapping一組 form form
	// 表單特性------------------------
	@GetMapping(value = "/restaurant/insertintoRestaurant", produces = { "text/html" })
	public String showinsertRestaurantForm(Model model) {
		RestaurantBean rb = new RestaurantBean();
		model.addAttribute("RestaurantBean", rb);
		//return "restaurant/insertInto";
		return "restaurant/NewRestaurant";
	}

	@PostMapping(value = "/restaurant/insertintoRestaurant", produces = { "text/html" })
	public String insertintoRestaurant(@ModelAttribute("RestaurantBean") RestaurantBean rb, BindingResult bindingResult)
			throws SQLException {

		System.out.println("新增餐廳: " + rb.getRestaurantName());
		new resValidate().validate(rb, bindingResult);

		if (bindingResult.hasErrors()) {
			System.out.println("======================");
			List<ObjectError> list = bindingResult.getAllErrors();
			for (ObjectError error : list) {
				System.out.println("有錯誤 : " + error);
			}
			System.out.println("======================");
			System.out.println("bean==>" + rb.getRestaurantName());
			//return "restaurant/insertInto";
			return "restaurant/NewRestaurant";
		}
//		String address= city + rb.getRestaurantZone()+rb.getRestaurantAddress();
//		rb.setRestaurantAddress(address);
		service.insertRestaurant(rb);
		
//		return "restaurant/resSearchLogin";
		return "restaurant/RestaurantHome";
	}
//  ------------------------------------------------------------

//   修改~~~~~~~~~~~~~~以下兩個mapping一組 form form 表單特性~~~~~~~~~~~~~~
	@GetMapping(value = "/restaurant/updateRestaurant")
	public String showUpdateRestaurantForm(@RequestParam("id") Integer id, Model model) throws SQLException {
		RestaurantBean rb = service.searchById(id);
		model.addAttribute("RestaurantBean1", rb);
		return "restaurant/RestaurantUpdate";
	}

	@PostMapping("/restaurant/updateRestaurant")
	// BindingResult 參數必須與@ModelAttribute修飾的參數連續編寫，中間不能夾其他參數
	public String updateRestaurant(@ModelAttribute("RestaurantBean1") RestaurantBean rb, BindingResult result,
			Model model, HttpServletRequest request) throws SQLException {
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
//		return "restaurant/resSearchLogin";
		return "restaurant/RestaurantHome";
	}

//  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	
	@GetMapping("/restaurant/moreInfo")
	public String pagedisplay(
			@RequestParam("id") Integer id,Model model) throws SQLException {
			
			RestaurantBean rb = service1.searchById(id);
			model.addAttribute("resBeselect",rb);
			//畫面時就從SQL把 COUNT資訊送給畫面
//			service2.viewCountIncOne(id);
//			CountBean cb = service2.searchById(id);
//			model.addAttribute("CountBean",cb);
//			System.out.println(cb.getViewCount());
			return "restaurant/MoreInfo";
	}
	@GetMapping("/restaurant/like")
	public String likeNumbers(
			@RequestParam("id") Integer id,Model model) throws SQLException {
			RestaurantBean rb = service1.searchById(id);
			model.addAttribute("resBeselect",rb);
//			int value = service2.viewCountIncOne(id);
//			model.addAttribute("viewValue",value);
//			System.out.println(value);
			return "restaurant/MoreInfo";
	}
	

}
