package social.service;

import java.util.List;

import org.springframework.stereotype.Service;
@Service
public interface RestaurantType {

	List<String> queryRestaurantTypes();

}