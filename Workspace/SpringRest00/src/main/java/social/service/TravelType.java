package social.service;


import java.util.List;

import org.springframework.stereotype.Service;
@Service
public interface TravelType {

	List<String> queryTravelTypes();

}