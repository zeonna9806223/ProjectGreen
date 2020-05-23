package member.dao;

import member.model.MemberBean;

public interface LoginDao {

	public MemberBean getLogin(String email, String password);
	public MemberBean checkIDPassword(String memberAccount, String password);	
}
