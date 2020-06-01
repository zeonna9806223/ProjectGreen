package restaurant.orderController;


import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import restaurant.resBean.RestaurantBean;
import restaurant.resService.IRestaurantService;
@Controller
@SessionAttributes(names = {"resBeselect"})
public class bookingJavaController {

	@Autowired
	IRestaurantService service;
	public bookingJavaController() {
	}
	@GetMapping("/restaurant/showBookingHome")
	public String pagedisplay(
			@RequestParam("id") Integer id,Model model) throws SQLException {
			RestaurantBean rb = service.searchById(id);
			model.addAttribute("resBeselect",rb);
			return "bookingRes";
	}
	
	
}
