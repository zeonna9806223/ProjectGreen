package social.model.bean;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="MatchRequest")
public class MatchRequestBean {
	@Id @Column(name="MatchID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer matchID;
	@Column(name="MemberID")
	private Integer memberID;
	@Column(name="AgeTopLike")
	private Integer ageTopLike;
	@Column(name="AgeBottomLike")
	private Integer ageBottomLike;
	@Column(name="HeightLike")
	private Integer heightLike;
	@Column(name="WeightLike")
	private Integer weightLike;
	@Column(name="GenderLike")
	private Integer genderLike;
	@Column(name="InterestedRestaurantType")
	private String interestedRestaurantType;
	@Column(name="TourTypeLike")
	private String tourTypeLike;
	@Column(name="RequestDay")
	private java.sql.Date requestDay;
	@Column(name="GetMatch")
	private Integer getMatch;
	@Column(name="Everyday")
	private Integer everyday;
	
	public MatchRequestBean() {
		
	}

	public MatchRequestBean(int matchID, int memberID, int ageTopLike, int ageBottomLike, 
			int heightLike, int weightLike, int genderLike, String interestedRestaurantType, String tourTypeLike,
			java.sql.Date requestDay) {
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
			int weightLike, int genderLike, String interestedRestaurantType, String tourTypeLike, java.sql.Date requestDay) {
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

	public void setRequestDay(java.sql.Date requestDay) {
		this.requestDay = requestDay;
	}

	
}
