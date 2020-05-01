package social.service;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

import social.bean.FriendInfoBean;
import social.bean.MatchRequestBean;
import social.bean.MatchesBean;
import social.bean.MatchingBean;

public interface Match {

	void insertMatchRequest(MatchRequestBean mrb);

	List<MatchingBean> todayRequest();
	
	List getMatch(List<MatchingBean> todayRequest);

	void insertMatchResult(List<List<Integer>> matchResult);
	
	void markMatch(Integer i);
	
	public void markPairDate(Integer i);
	
	List<MatchesBean> showMatch();
	
	List<MatchesBean> showFriends();
	
	List<MatchesBean> showTodayMatch();
	
	FriendInfoBean showFriendInfo(Integer i);
	
	int getAge(Date birthday);
	
	public void deleteFriend(Integer i);	
}
