package social.model.DAO;

import java.util.List;
import java.util.Map;

import social.model.bean.FriendInfoBean;
import social.model.bean.MatchRequestBean;
import social.model.bean.MatchesBean;
import social.model.bean.MatchingBean;
import social.model.bean.MessageBean;


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
	
	void saveMessage(Integer pairId, Integer id1, Integer id2, String text);
	
	List showMessage(Integer pair, Integer i);
	
}
