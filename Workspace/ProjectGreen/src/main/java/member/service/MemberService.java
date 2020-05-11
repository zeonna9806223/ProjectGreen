package member.service;

import member.model.MemberBean;
import member.model.MemberDetailBean;

public interface MemberService {
	boolean idExists(String id);
	int saveMember(MemberBean mb);
	MemberBean queryMember(String id);
	public MemberBean checkIDPassword(String userId, String password) ;
	MemberDetailBean query(String id);
	MemberDetailBean insertProfile(MemberDetailBean mdb);
}
