package social.service;

import java.util.List;

import social.DAO.UserDao;
import social.model.MemberBean2;
//控制器呼叫service , service 呼叫DAO
//此為UserDao的Service

public class UserServiceImpl {
	UserDao uDao;
	
	//產生預設建構子
	public UserServiceImpl() {
		uDao= new UserDao();
		
	}
////產生帶有參數建構子
//public UserServiceImpl(UserDao uDao) {
//	super();
//	this.uDao = uDao;
//}

//產生與Dao之中相同名字的方法；
public List<MemberBean2> queryUsers() {
	//service 呼叫DAO
	return uDao.queryUsers();
}
}
