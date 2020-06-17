package social.model.DAO;

import java.util.List;
import social.model.bean.FriendInfoBean;
import social.model.bean.MatchRequestBean;
import social.model.bean.MatchesBean;
import social.model.bean.MatchingBean;


public interface MatchDAO {

	void insertMatchRequest(MatchRequestBean mrb);

	List<MatchingBean> todayRequest(int time);

	void insertMatchResult(List<List<Integer>> matchResult);

	void markMatch(Integer i, Integer ii);
	
	void markPairDate(Integer i, Integer ii);
	
	List<MatchesBean> showMatch(Integer i);
	
	FriendInfoBean showFriendInfo(Integer i);
	
	String friendProfileJson(java.sql.Blob image);
	
	void deleteFriend(Integer i, Integer ii);
	
}
