package social.bean;

import java.util.Date;

public class MatchRequestBean {
	private Integer matchID;
	private Integer memberID;
	private Integer ageTopLike;
	private Integer ageBottomLike;
	private Integer heightLike;
	private Integer weightLike;
	private Integer genderLike;
	private String interestedRestaurantType;
	private String tourTypeLike;
	private Date requestDay;
	
	public MatchRequestBean() {
		
	}

	public MatchRequestBean(int matchID, int memberID, int ageTopLike, int ageBottomLike, 
			int heightLike, int weightLike, int genderLike, String interestedRestaurantType, String tourTypeLike,
			Date requestDay) {
		super();
		this.matchID = matchID;
		this.memberID = memberID;
		this.ageTopLike = ageTopLike;
		this.ageBottomLike = ageBottomLike;
		this.heightLike = heightLike;
		this.weightLike = weightLike;
		this.genderLike = genderLike;
		this.interestedRestaurantType = interestedRestaurantType;
		this.tourTypeLike = tourTypeLike;
		this.requestDay = requestDay;
	}

	public MatchRequestBean(int memberID, int ageTopLike, int ageBottomLike,  int heightLike,
			int weightLike, int genderLike, String interestedRestaurantType, String tourTypeLike, Date requestDay) {
		super();
		this.memberID = memberID;
		this.ageTopLike = ageTopLike;
		this.ageBottomLike = ageBottomLike;
		this.heightLike = heightLike;
		this.weightLike = weightLike;
		this.genderLike = genderLike;
		this.interestedRestaurantType = interestedRestaurantType;
		this.tourTypeLike = tourTypeLike;
		this.requestDay = requestDay;
	}

	public int getMatchID() {
		return matchID;
	}

	public void setMatchID(int matchID) {
		this.matchID = matchID;
	}

	public int getMemberID() {
		return memberID;
	}

	public void setMemberID(int memberID) {
		this.memberID = memberID;
	}

	public int getAgeTopLike() {
		return ageTopLike;
	}

	public void setAgeTopLike(int ageTopLike) {
		this.ageTopLike = ageTopLike;
	}

	public int getAgeBottomLike() {
		return ageBottomLike;
	}

	public void setAgeBottomLike(int ageBottomLike) {
		this.ageBottomLike = ageBottomLike;
	}


	public int getHeightLike() {
		return heightLike;
	}

	public void setHeightLike(int heightLike) {
		this.heightLike = heightLike;
	}

	public int getWeightLike() {
		return weightLike;
	}

	public void setWeightLike(int weightLike) {
		this.weightLike = weightLike;
	}

	public int getGenderLike() {
		return genderLike;
	}

	public void setGenderLike(int genderLike) {
		this.genderLike = genderLike;
	}

	public String getInterestedRestaurantType() {
		return interestedRestaurantType;
	}

	public void setInterestedRestaurantType(String interestedRestaurantType) {
		this.interestedRestaurantType = interestedRestaurantType;
	}

	public String getTourTypeLike() {
		return tourTypeLike;
	}

	public void setTourTypeLike(String tourTypeLike) {
		this.tourTypeLike = tourTypeLike;
	}

	public Date getRequestDay() {
		return requestDay;
	}

	public void setRequestDay(Date requestDay) {
		this.requestDay = requestDay;
	}

	
}
