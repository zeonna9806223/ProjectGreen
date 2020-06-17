package accommodation.search.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;

import accommodation.search.service.IAccommodationNumService;
import accommodation.search.service.IAccommodationService;
import accommodation.search.service.IAccommodationTownService;

@Controller
//@EnableTransactionManagement
public class SearchController {
	@Autowired
	IAccommodationService aService;
	@Autowired
	IAccommodationTownService atService;
	@Autowired
	IAccommodationNumService anService;

	@GetMapping("/index")
	public String toIndex() {
		return "index";
	}
	
	@GetMapping("/searchRegion")
	protected @ResponseBody String processSearch(@RequestParam String region, Model m) {
		String json = "";
		if (region != null) {
			List<Map> list = atService.townChoice(region);
			Gson gson = new Gson();
			json = gson.toJson(list);
			
		}
		System.out.println(region);
		System.out.println(json);
		return json;
	}

	@PostMapping("/search")
	protected  String processSearchHotel(@RequestParam String region,
			@RequestParam(name = "town") String townId, Model m) {
		String town = atService.getTownName(townId);
		System.out.println(region + " " + town + " " + townId);
		if (town != null) {
			List<Map> list = aService.hotelChoice(town);
			m.addAttribute("hmap", list);
			String result = region + "  " + town + " 旅宿查詢結果:";
			m.addAttribute("show", result);
		}
		return "accommodation/search/Search2";
	}
	
	@GetMapping("/show")
	protected  String processShowHotel(@RequestParam String hotel, Model m) {
//		String hotel = request.getParameter("h");
		System.out.println(hotel);
		int hotelId = aService.getHotelId(hotel);
		anService.updateViewNum(hotelId);

		 List<Map>  list = aService.hotelInfo(hotel);
		m.addAttribute("name", hotel);
		m.addAttribute("hInfo", list);
		
		return "accommodation/search/Show2";
	}
	
	@PostMapping("/bookUpdate")
	protected  void processBookUpdate(@RequestParam String booking,@RequestParam String hname, Model m) {
		if (booking != null) {
			int hotelId = aService.getHotelId(hname);
			anService.updateBookNum(hotelId);
		}
	}
	
}
