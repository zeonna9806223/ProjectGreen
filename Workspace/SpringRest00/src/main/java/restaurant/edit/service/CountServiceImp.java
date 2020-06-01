package restaurant.edit.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import restaurant.edit.dao.ICountDAO;
import restaurant.model.CountBean;

@Service
@Transactional
@EnableTransactionManagement
public class CountServiceImp implements ICountService{
	@Autowired
	ICountDAO dao;
	
	public CountServiceImp() {
	}

	@Override
	public int viewCountDecOne(Integer id) {
		
		return dao.viewCountDecOne(id);
	}

	@Override
	public int viewCountIncOne(Integer id) {
		return dao.viewCountIncOne(id);
	}

	@Override
	public int likeCountDecOne(Integer id) {
		return dao.likeCountDecOne(id);
	}

	@Override
	public int likeCountIncOne(Integer id) {
		return dao.likeCountIncOne(id);
	}

	@Override
	public int disLikeCountDecOne(Integer id) {
		return dao.disLikeCountDecOne(id);
	}

	@Override
	public int disLikeCountIncOne(Integer id) {
		return dao.disLikeCountIncOne(id);
	}

	@Override
	public int bookingCountDecOne(Integer id) {
		return dao.bookingCountDecOne(id);
	}

	@Override
	public int bookingCountIncOne(Integer id) {
		return dao.bookingCountIncOne(id);
	}

	@Override
	public CountBean searchById(Integer id) {
		return dao.searchById(id);
	}

}
