package restaurant.edit.service;

import restaurant.model.CountBean;

public interface ICountService {
	int viewCountDecOne(Integer id);
	int viewCountIncOne(Integer id);
	int likeCountDecOne(Integer id);
	int likeCountIncOne(Integer id);
	int disLikeCountDecOne(Integer id);
	int disLikeCountIncOne(Integer id);
	int bookingCountDecOne(Integer id);
	int bookingCountIncOne(Integer id);
	CountBean searchById(Integer id);
}