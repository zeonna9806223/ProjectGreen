package member.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import member.dao.MemberDao_;
import member.model.MemberBean;
import member.service.MemberService_;

@Transactional
@Service("memberServiceImpl")
public class MemberServiceImpl_ implements MemberService_ {

	
	@Autowired
	private MemberDao_ memberDao;

	
	public MemberServiceImpl_() {
	}
	
	@Autowired
	public void setMemDao(MemberDao_ memberDao) {
		this.memberDao = memberDao;
	}////////////////////////////////////////////////////////////////////

	@Override
	public MemberBean getMem(int id) {
	
		return memberDao.getMem(id);
	}

	@Override
	public List<MemberBean> getMems() {
		return memberDao.getMems();
	}

	@Override
	public Object saveMem(MemberBean bean) {
		return memberDao.saveMem(bean);
	}

	@Override
	public void updateMem(MemberBean bean) {
		memberDao.updateMem(bean);
	}

	@Override
	public void deleteMem(int key) {
		memberDao.deleteMem(key);
	}

	@Override
	public MemberBean getMem(String memberAccount) {
		return memberDao.getMem(memberAccount);
	}


}
