package social.DAO;

import java.util.List;
import social.bean.FriendInfoBean;
import social.bean.MatchRequestBean;
import social.bean.MatchesBean;
import social.bean.MatchingBean;

public interface MatchDAO {

	void insertMatchRequest(MatchRequestBean mrb);

	List<MatchingBean> todayRequest(int time);

	void insertMatchResult(List<List<Integer>> matchResult);

	void markMatch(Integer i, Integer ii);
	
	void markPairDate(Integer i, Integer ii);
	
	List<MatchesBean> showMatch(Integer i);
	
	FriendInfoBean showFriendInfo(Integer i);
	
	void deleteFriend(Integer i, Integer ii);
}
