package member.model;

public interface MemberDetailDao {

	MemberDetailBean query(String id);
	public int insertProfile(MemberDetailBean mdb);

	
}
