package social.DAO;

import java.sql.Connection;

import social.model.MemberBean;


public interface MemberDao {
	
	public boolean idExists(String id);

	public int saveMember(MemberBean mb) ;
	
	public MemberBean queryMember(String id);
	
	public MemberBean checkIDPassword(String userId, String password);	
	
	public void setConnection(Connection con);
}