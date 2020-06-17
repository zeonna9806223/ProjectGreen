package member.service;

import member.model.MemberBean;

public interface LoginService {
	
	public MemberBean getLogin(String email, String password);
	public MemberBean checkIDPassword(String memberAccount, String password) ;
}
