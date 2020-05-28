package social.service;

import java.util.Date;
import java.util.List;
import java.util.Map;

import social.model.bean.FriendInfoBean;
import social.model.bean.MatchRequestBean;
import social.model.bean.MatchesBean;
import social.model.bean.MatchingBean;
import social.model.bean.MessageBean;

public interface Match {

	void insertMatchRequest(MatchRequestBean mrb);

	List<MatchingBean> todayRequest(int time);
	
	List getMatch(List<MatchingBean> todayRequest);

	void insertMatchResult(List<List<Integer>> matchResult);
	
	void markMatch(Integer i, Integer ii);
	
	void markPairDate(Integer i, Integer ii);
	
	List<MatchesBean> showMatch(Integer ii);
	
	List<MatchesBean> showFriends(Integer ii);
	
	List<MatchesBean> showTodayMatch(Integer ii);
	
	FriendInfoBean showFriendInfo(Integer i);
	
	int getAge(Date birthday);
	
	void deleteFriend(Integer i, Integer ii);
	
	void saveMessage(Integer pairId, Integer id1, Integer id2, String text);
	
	List showMessage(Integer pair, Integer i);
}
