package transportation.controller;

import java.net.MalformedURLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.google.gson.Gson;

import transportation.mrt.model.TaipeiMRTExit;
import transportation.mrt.service.TaipeiMRTService;
import transportation.ubike.model.YouBikeNTPC;
import transportation.ubike.model.YouBikeTPC;
import transportation.ubike.service.YouBikeService;

@Controller
@RequestMapping("/transportation")
@SessionAttributes({"stations"})
public class TransportationController {
	
	@Autowired
	YouBikeService ybService;
	@Autowired
	TaipeiMRTService mrtService;
	
// （一）雙北YouBike
	// 1. 間接導向頁面
	// 網址：http://localhost:8080/ChuMeProject/transportation/YouBike/YouBike.do
	@GetMapping("/YouBike/YouBike.do")
	public String showYouBikePage(Model model) {
		return "transportation/YouBike";
	}
	
	// 2. 以城市查詢區域
	@GetMapping("/YouBike/searchYBDis")
	public @ResponseBody String processSearchYBDistrict(@RequestParam(name = "ybCityChoosen") String ybcity ,Model m) {
//		System.out.println("進controller_processSearchYBDistrict");
//		System.out.println("傳入資料："+ybcity);
		List<String> ybDisResult = ybService.searchYBDistrict(ybcity);
		String ybd = new Gson().toJson(ybDisResult);
		System.out.println(ybd);
		return ybd;
	}
	
	// 3. 查詢：以區域查詢站點
	@PostMapping("/YouBike/searchYB")
	public String processSearchYB(
			@RequestParam(name = "ybCity") String ybcity,
			@RequestParam(name = "ybDistrict") String ybdist,
			Model model,
			HttpServletRequest request) throws MalformedURLException {
//		System.out.println("進controller_processSearchYB");
//		System.out.println("傳入資料："+ybcity+"／"+ybdist);
		if (ybcity.equals("台北市")) {
			List<YouBikeTPC> stations = ybService.ybStationTPC(ybdist);
//			System.out.println("回到controller_#processSearchYB的台北市");
			model.addAttribute("stations", stations);
			request.setAttribute("city", ybcity);
			request.setAttribute("district", ybdist);
//			System.out.println("準備返回jsp");
			return "transportation/YouBike";
		} else if(ybcity.equals("新北市")){
			List<YouBikeNTPC> stations = ybService.ybStationNTPC(ybdist);
//			System.out.println("回到controller_#processSearchYB的新北市");
			model.addAttribute("stations", stations);
			request.setAttribute("city", ybcity);
			request.setAttribute("district", ybdist);
//			System.out.println("準備返回jsp");
			return "transportation/YouBike";
		}
		else {
			request.setAttribute("errorMessage", "請輸入搜尋條件");
			return "transportation/YouBike";
		}
	}
	
	
//	（二）台北捷運
	// 1. 間接導向頁面
	// 網址：http://localhost:8080/ChuMeProject/transportation/TaipeiMRT/TaipeiMRT.do
	@GetMapping("/TaipeiMRT/TaipeiMRT.do")
	public String showTaipeiMRTPages(Model model) {
		return "transportation/TaipeiMRT";
	}
	
	 // 2. 用路線查詢車站
	@GetMapping("/TaipeiMRT/searchMRTStation")
	public @ResponseBody String processsearchMRTStation(
			@RequestParam(name = "mrtLineChoosen")String line,
			Model model) {
//		System.out.println("進controller_#processsearchMRTStation");
		List<String> lineList = mrtService.queryMRTStationsByLine(line);
		String lines = new Gson().toJson(lineList);
//		System.out.println(lines);
		return lines;
	}
	
	// 3. 用車站查詢出口
	@PostMapping("/TaipeiMRT/searchMRTStationExit")
	public String processSearchMRTStationExit(
			@RequestParam(name = "mrtStation") String station,
			@RequestParam(name = "mrtLine") String lineId,
			HttpServletRequest request,
			Model model) {
//		System.out.println("傳入資料狀況："+lineId+"／"+station);
//		System.out.println("阿到底是怎樣啦？"+station.equals("0"));
		if( ! station.equals("0")) {
//			System.out.println("進processSearchMRTStationExit的［if］判斷式");
			List<TaipeiMRTExit> exits = mrtService.queryMRTExits(station);
			String lineName = mrtService.queryMRTLineName(lineId);
			request.setAttribute("station", station);
			request.setAttribute("lineName", lineName);
			model.addAttribute("exits", exits);
			return "transportation/TaipeiMRT";
		} else {
//			System.out.println("進processSearchMRTStationExit的［else］判斷式");
			request.setAttribute("errorMessage", "請輸入搜尋條件");
			return "transportation/TaipeiMRT";
		}
	}
	
}
