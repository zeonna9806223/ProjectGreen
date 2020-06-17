package accommodation.edit.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.google.gson.Gson;

import accommodation.edit.model.bean.EditDetail;
import accommodation.edit.service.IEditDetailService;
import accommodation.search.service.IAccommodationNumService;
import accommodation.search.service.IAccommodationService;
import accommodation.search.service.IAccommodationTownService;
import member.model.MemberBean;

@Controller
//@EnableTransactionManagement
@RequestMapping("/edit")
@SessionAttributes(names = { "LoginOK" })
public class EditController {
	@Autowired
	IAccommodationTownService atService;
	@Autowired
	IAccommodationService aService;
	@Autowired
	IAccommodationNumService anService;
	@Autowired
	IEditDetailService editService;

	@GetMapping("/insert")
	public String toHotelInsert() {
//		EditDetail eBean = new EditDetail();
//		m.addAttribute("eBean", eBean);
		return "accommodation/edit/Insert2";
	}

	@GetMapping("/update")
	public String toHotelUpdate() {
		return "accommodation/edit/Update2";
	}

	@GetMapping("/delete")
	public String toHotelDelete() {
		return "accommodation/edit/Delete2";
	}

	@GetMapping("/getTown")
	public @ResponseBody String getTown(@RequestParam("Hregion") String regionId, Model m) {

		System.out.println(regionId);
		String region = atService.getRegionName(regionId);
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

	@Autowired
	HttpSession session;
	
	@PostMapping("/edit.do")
	protected String insertHotel(@RequestParam Map<String, String> hoteldata, Model m) {

		MemberBean mb = (MemberBean) session.getAttribute("LoginOK");
		String memberName=mb.getMemberName();
		int memberId=mb.getPKey();
		
		System.out.println(memberId);
		
		//////////////////////////////////////////////////////////
		
		
		String status = hoteldata.get("status");
		String status2 = hoteldata.get("status2");
//		MemberBean mBean = (MemberBean) session.getAttribute("LoginOK");
//		int memberId = mBean.getPKey();

		String oidHotelName = "";

		// 顯示會員的旅館資料
		if (status2 != null) {
			if (status2.equals("update") || status2.equals("delete")) {
				int memberHotelId = editService.findHotelId(memberId);
				System.out.println(memberHotelId);
				List<Map> list = aService.hotelShow(memberHotelId);
				String region = atService.getRegionName((String) list.get(0).get("regionId"));
				String town = atService.getTownName((String) list.get(0).get("townId"));
				oidHotelName = (String) list.get(0).get("name");
				System.out.println(oidHotelName + "================");
				m.addAttribute("hotel", list.get(0));
				m.addAttribute("region", region);
				m.addAttribute("town", town);
				if (status2.equals("update")) {
					return "accommodation/edit/Update2";
				} else if (status2.equals("delete")) {
					return "accommodation/edit/Delete2";
				}
			}
		}

		if (status != null) {
//			session.getAttribute("LoginOK");
//			String Uname = hoteldata.get("Uname");
			String Hname = hoteldata.get("Hname");
			String Htel = hoteldata.get("Htel");
			String Hemail = hoteldata.get("Hemail");
			String Hweb = hoteldata.get("Hweb");
			String Hregion = hoteldata.get("Hregion");
			String Htown = hoteldata.get("Htown");
			String Haddr = hoteldata.get("Haddr");
			int Hprice = Integer.parseInt(hoteldata.get("Hprice").trim());
			String region = atService.getRegionName(Hregion);
			System.out.println(region);
			String town = atService.getTownName(Htown);
			System.out.println(town);
			System.out.println(Hname);

			switch (status) {
			case "insert":
				EditDetail eBean = new EditDetail(memberId, memberName, 0, Hname, Hregion, Htown, Haddr, Htel, Hemail, Hweb,
						Hprice, status);
				int memberHoteld = aService.insert(eBean, region, town);
				int editIdInsert = editService.insert(eBean, memberHoteld);
				m.addAttribute("hotel", eBean);
				m.addAttribute("insert", "insert");
				anService.insertNewHotel(memberHoteld, Hname);

				return "accommodation/edit/Success2";
//				break;
			case "update":
				int hotelId = editService.findHotelId(memberId);
				EditDetail eBean2 = new EditDetail(memberId, memberName, hotelId, Hname, Hregion, Htown, Haddr, Htel, Hemail, Hweb,
						Hprice, status);
//				EditDetail eBean2 = new EditDetail(memberId, mBean.getMemberName(), hotelId, Hname,
//						Hregion, Htown, Haddr, Htel, Hemail, Hweb, Hprice, status);
				aService.update(eBean2, region, town);
				int editIdUpdate = editService.insert(eBean2);
				if (!oidHotelName.equals("Hname")) {
					anService.updateHotelName(hotelId, Hname);
				}
				m.addAttribute("hotel", eBean2);
				m.addAttribute("update", "update");
				return "accommodation/edit/Success2";
//				break;
			case "delete":
				EditDetail eBean3 = new EditDetail(memberId, memberName, editService.findHotelId(memberId), Hname, Hregion, Htown, Haddr, Htel, Hemail, Hweb,
						Hprice, status);
//				EditDetail eBean3 = new EditDetail(memberId, mBean.getMemberName(), eService.findHotelId(memberId), Hname,
//						Hregion, Htown, Haddr, Htel, Hemail, Hweb, Hprice, status);
				aService.delete(eBean3);
				System.out.println("delete");
				int editIdDelete = editService.insert(eBean3);
				m.addAttribute("hotel", eBean3);
				m.addAttribute("delete", "delete");
				return "accommodation/edit/Success2";
//				break;
			}
		}
		return null;
	}

//		String status = hoteldata.get("status");
//		String Uname = hoteldata.get("Uname");
//		String Hname = hoteldata.get("Hname");
//		String Htel = hoteldata.get("Htel");
//		String Hemail = hoteldata.get("Hemail");
//		String Hweb = hoteldata.get("Hweb");
//		String Hregion = hoteldata.get("Hregion");
//		String Htown = hoteldata.get("Htown");
//		String Haddr = hoteldata.get("Haddr");
//		int Hprice = Integer.parseInt(hoteldata.get("Hprice").trim());
//		String region = atService.getRegionName(Hregion);
//		System.out.println(region);
//		String town = atService.getTownName(Htown);
//		System.out.println(town);
//		System.out.println(Hname);
//		
//		EditDetail eBean = new EditDetail(99, "火星人", 0, Hname, Hregion, Htown, Haddr,
//				Htel, Hemail, Hweb, Hprice, status);
//		int memberHoteld = aService.insert(eBean, region, town);
//		int editIdInsert = editService.insert(eBean, memberHoteld);
//		m.addAttribute("hotel", eBean);
//		m.addAttribute("insert", "insert");
//		anService.insertNewHotel(memberHoteld, Hname);
//
//		return "accommodation/edit/Success2";

}
