package attractions.Controller;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import attractions.Bean.AttractionEdited;
import attractions.Service.AttractionService;

@Controller
public class AttractionController {
	@Autowired
	AttractionService service;
	
	public AttractionController() {
	}
	//回首頁
	@GetMapping(value = "/Attraction/Attractionme", produces = { "text/html" })
	public String AttractionHome(Model model) {
		return "Attraction/Attraction";
	}
	
	//搜尋所有
	@GetMapping(value = "/Attraction/queryallAttraction", produces = { "text/html" })
	public String queryAllAttraction(Model model) throws SQLException {
		List<AttractionEdited> attractions = service.getAllAttraction();
		System.out.println(attractions.size());
		model.addAttribute("queryresult", attractions);
		return "Attraction/Attraction";
	}
	
	//用條件Zone和Type搜尋
		@GetMapping(value = "/Attraction/selectAttraction", produces = { "text/html" })
		public String selectAttraction(@RequestParam("region") String region, @RequestParam("town") String town, Model model)throws SQLException {
			List<AttractionEdited> attractions = service.search(region, town);
			model.addAttribute("queryresult", attractions);
			return "Attraction/Attraction";
		}
		
		//刪除
		@GetMapping(value = "/Attraction/deleteAttraction", produces = { "text/html" })
		public String deleteRestauant(@RequestParam("id")Integer id,Model model) throws SQLException {
			service.deleteAttraction(id);
			return "Attraction/Attraction";
		}
	
	

}
