package member.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import member.dao.LoginDao;
import member.model.MemberBean;
import member.service.LoginService;

@Service("loginServiceImpl")
public class LoginServiceImpl implements LoginService {

	
	@Autowired
	private LoginDao loginDao;
	
	
	public LoginServiceImpl() {
	}
	
	@Override
	public MemberBean getLogin(String email, String password) {
		MemberBean mem = null;

		try {
			mem = this.loginDao.getLogin(email, password);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return mem;
	}
	@Override
	public MemberBean checkIDPassword(String memberAccount, String password) {
		MemberBean mem = null;

		try {
			mem = this.loginDao.checkIDPassword(memberAccount, password);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return mem;
	}
}
