package restaurant.search.controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.google.gson.Gson;

import restaurant.model.RestaurantBean;
import restaurant.search.service.IMapService;
import restaurant.search.service.IRestaurantService;
@Controller
@SessionAttributes
public class mapController {

	@Autowired
	IRestaurantService restaurantService;
	@Autowired
	IMapService mapService;

	public mapController() {
	}
	//  http://localhost:8080/SpringRest00/restaurant/home
	@GetMapping("/restaurant/home")
	public String home(Model model){
	return "restaurant/RestaurantHome";
	}
	
	
	//導入首頁     http://localhost:8080/SpringRest00/restaurant/map
	@GetMapping("/restaurant/map")
		public String pagedisplay(Model model) throws SQLException{
		List<RestaurantBean> restaurants = restaurantService.search("南洋","信義區","台北市");
		model.addAttribute("queryresult", restaurants);
		System.out.println(restaurants.get(0).getRestaurantPx()+"+"+restaurants.get(0).getRestaurantPy());
		System.out.println(restaurants.get(1).getRestaurantPx()+"+"+restaurants.get(1).getRestaurantPy());
		System.out.println(restaurants.get(2).getRestaurantPx()+"+"+restaurants.get(2).getRestaurantPy());
		return "restaurant/mapTest";
			
	}

	//因為很重要所以要說三遍  跟連線有關的東西不能new 不能new 不能new要交給SPRING自己找
	//因為很重要所以要說三遍  跟連線有關的東西不能new 不能new 不能new要交給SPRING自己找
	//因為很重要所以要說三遍  跟連線有關的東西不能new 不能new 不能new要交給SPRING自己找
	@GetMapping(value="/restaurant/tpYoubike",produces= {"application/json"})
	public @ResponseBody String tpyoubike() throws SQLException {
		List<String> listTP = new ArrayList<String>();
//		IMapDao dao=new MapDAO();
//		list=dao.mapRestaurants();
		listTP=mapService.mapYoubikeTP();
		String jsonTp = new Gson().toJson(listTP);
		System.out.println("台北市json狀況："+jsonTp);    // checkpoint
		return jsonTp;
	}
	@GetMapping(value="/restaurant/ntpYoubike",produces= {"application/json"})
	public @ResponseBody String ntpyoubike() throws SQLException {
		List<String> listNTP = new ArrayList<String>();
//		IMapDao dao=new MapDAO();
//		list=dao.mapRestaurants();
		listNTP=mapService.mapYoubikeNTP();
		String jsonNtp = new Gson().toJson(listNTP);
		System.out.println("新北市json狀況："+jsonNtp);    // checkpoint
		return jsonNtp;
	}
	
	@GetMapping(value="/restaurant/tpmrt",produces= {"application/json"})
	public @ResponseBody String tpmrt() throws SQLException {
		List<String> list = new ArrayList<String>();
		list=mapService.mapMRT();
		String json = new Gson().toJson(list);
		System.out.println("json狀況："+json);    // checkpoint
		return json;
	}
}
