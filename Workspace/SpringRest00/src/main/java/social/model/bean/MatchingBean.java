package social.model.bean;

import java.util.Date;

public class MatchingBean {
	private Integer matchID;
	private Integer memberID;
	private Integer ageTopLike;
	private Integer ageBottomLike;
	private Integer heightLike;
	private Integer weightLike;
	private Integer genderLike;
	private String interestedRestaurantType;
	private String tourTypeLike;
	private java.sql.Date requestDay;
	private Integer everyday;
	private Integer getMatch;
	private String memberName;
	private java.sql.Date memberBirthday;
	private Integer profileHeight;
	private Integer profileWeight;
	private Integer gender;

	public MatchingBean() {

	}

	public MatchingBean(Integer matchID, Integer memberID, Integer ageTopLike, Integer ageBottomLike,
			Integer heightLike, Integer weightLike, Integer genderLike, String interestedRestaurantType,
			String tourTypeLike, java.sql.Date requestDay, Integer everyday, Integer getMatch, String memberName,
			java.sql.Date memberBirthday, Integer profileHeight, Integer profileWeight, Integer gender) {
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
		this.everyday = everyday;
		this.getMatch = getMatch;
		this.memberName = memberName;
		this.memberBirthday = memberBirthday;
		this.profileHeight = profileHeight;
		this.profileWeight = profileWeight;
		this.gender = gender;
	}

	public Integer getMatchID() {
		return matchID;
	}

	public void setMatchID(Integer matchID) {
		this.matchID = matchID;
	}

	public Integer getMemberID() {
		return memberID;
	}

	public void setMemberID(Integer memberID) {
		this.memberID = memberID;
	}

	public Integer getAgeTopLike() {
		return ageTopLike;
	}

	public void setAgeTopLike(Integer ageTopLike) {
		this.ageTopLike = ageTopLike;
	}

	public Integer getAgeBottomLike() {
		return ageBottomLike;
	}

	public void setAgeBottomLike(Integer ageBottomLike) {
		this.ageBottomLike = ageBottomLike;
	}

	public Integer getHeightLike() {
		return heightLike;
	}

	public void setHeightLike(Integer heightLike) {
		this.heightLike = heightLike;
	}

	public Integer getWeightLike() {
		return weightLike;
	}

	public void setWeightLike(Integer weightLike) {
		this.weightLike = weightLike;
	}

	public Integer getGenderLike() {
		return genderLike;
	}

	public void setGenderLike(Integer genderLike) {
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

	public void setRequestDay(java.sql.Date requestDay) {
		this.requestDay = requestDay;
	}

	public Integer getEveryday() {
		return everyday;
	}

	public void setEveryday(Integer everyday) {
		this.everyday = everyday;
	}

	public Integer getGetMatch() {
		return getMatch;
	}

	public void setGetMatch(Integer getMatch) {
		this.getMatch = getMatch;
	}

	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	public Date getMemberBirthday() {
		return memberBirthday;
	}

	public void setMemberBirthday(java.sql.Date memberBirthday) {
		this.memberBirthday = memberBirthday;
	}

	public Integer getProfileHeight() {
		return profileHeight;
	}

	public void setProfileHeight(Integer profileHeight) {
		this.profileHeight = profileHeight;
	}

	public Integer getProfileWeight() {
		return profileWeight;
	}

	public void setProfileWeight(Integer profileWeight) {
		this.profileWeight = profileWeight;
	}

	public Integer getGender() {
		return gender;
	}

	public void setGender(Integer gender) {
		this.gender = gender;
	}


}
