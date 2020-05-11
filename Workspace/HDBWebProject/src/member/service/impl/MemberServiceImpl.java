package member.service.impl;

import member.model.MemberBean;
import member.model.MemberDao;
import member.model.MemberDetailBean;
import member.service.MemberService;

public class MemberServiceImpl implements MemberService {

	MemberDao  dao ;
	
	public MemberServiceImpl() {
		this.dao = new MemberDaoImpl_Jdbc();
	}

	@Override
	public int saveMember(MemberBean mb) {
		return dao.saveMember(mb);
	}

	@Override
	public boolean idExists(String id) {
		return dao.idExists(id);
	}

	@Override
	public MemberBean queryMember(String id) {
		return dao.queryMember(id);
	}


	public MemberBean checkIDPassword(String userId, String password) {
		MemberBean mb = dao.checkIDPassword(userId, password);
		return mb;
	}

	@Override
	public MemberDetailBean query(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MemberDetailBean insertProfile(MemberDetailBean mdb) {
		// TODO Auto-generated method stub
		return null;
	}
}
