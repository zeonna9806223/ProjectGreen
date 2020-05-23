package member.dao;

import java.util.List;

import member.model.MemberBean;



public interface MemberDao_ {
	
	MemberBean getMem(int id);
	
	List<MemberBean> getMems();

	Object saveMem(MemberBean bean);
	
	void updateMem(MemberBean bean); 

	void deleteMem(int key);

	MemberBean getMem(String memberAccount);
	
	


}