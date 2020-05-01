package social.DAO;

import java.text.ParseException;
import java.util.List;

import social.bean.FriendInfoBean;
import social.bean.MatchRequestBean;
import social.bean.MatchesBean;
import social.bean.MatchingBean;

public interface MatchDAO {

	void insertMatchRequest(MatchRequestBean mrb);

	List<MatchingBean> todayRequest();

	void insertMatchResult(List<List<Integer>> matchResult);

	void markMatch(Integer i);
	
	void markPairDate(Integer i);
	
	List<MatchesBean> showMatch();
	
	FriendInfoBean showFriendInfo(Integer i);
	
	void deleteFriend(Integer i);
}
