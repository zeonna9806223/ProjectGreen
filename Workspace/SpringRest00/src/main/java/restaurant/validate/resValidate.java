package restaurant.validate;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import restaurant.model.RestaurantBean;

public class resValidate implements Validator{

	@Override
	public boolean supports(Class<?> clazz) {
		return RestaurantBean.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors,"restaurantName","", "餐廳名子不能空白");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors,"restaurantType", "", "餐廳類型不能空白");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors,"restaurantZone", "", "餐廳區域不能空白");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors,"restaurantAddress", "", "餐廳地址不能空白");
		
		RestaurantBean restaurant = (RestaurantBean) target;
		
		if(restaurant.getRestaurantName() != null && restaurant.getRestaurantName().length() < 2 || restaurant.getRestaurantName().length() > 20) {
			errors.rejectValue("restaurantName","","字的長度不符合規定");
		}
		if(restaurant.getRestaurantType() != null && restaurant.getRestaurantType().length() < 2 || restaurant.getRestaurantType().length() > 8) {
			errors.rejectValue("restaurantType","", "字的長度不符合規定");
		}
		if(restaurant.getRestaurantZone() != null && restaurant.getRestaurantZone().length() !=3) {
			errors.rejectValue("restaurantZone","", "字的長度不符合規定");
		}
		if(restaurant.getRestaurantAddress() != null && restaurant.getRestaurantAddress().length() <2 || restaurant.getRestaurantAddress().length() >25) {
			errors.rejectValue("restaurantAddress","","字的長度不符合規定");
		}
		
	}

}
