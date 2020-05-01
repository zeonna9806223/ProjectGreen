package social.bean;

import java.util.Date;

public class MatchesBean {
	private Integer PairId;
	private Integer memberId1;
	private Integer memberId2;
	private Integer friends1;
	private Integer friends2;
	private Date pairDate;
	private Date friendDate;
	private Integer delete1;
	private Integer delete2;
	private Integer profileHeight;
	private Integer profileWeight;
	private String memberName;
	private Integer gender;
	private Date memberBithday;
	private String memberIntroduce;
	
	public MatchesBean() {
		super();
	}

	public MatchesBean(Integer pairId, Integer memberId1, Integer memberId2, Integer friends1, Integer friends2,
			Date pairDate, Date friendDate, Integer delete1, Integer delete2, Integer profileHeight,
			Integer profileWeight, String memberName, Integer gender, Date memberBithday, String memberIntroduce) {
		this.PairId = pairId;
		this.memberId1 = memberId1;
		this.memberId2 = memberId2;
		this.friends1 = friends1;
		this.friends2 = friends2;
		this.pairDate = pairDate;
		this.friendDate = friendDate;
		this.delete1 = delete1;
		this.delete2 = delete2;
		this.profileHeight = profileHeight;
		this.profileWeight = profileWeight;
		this.memberName = memberName;
		this.gender = gender;
		this.memberBithday = memberBithday;
		this.memberIntroduce = memberIntroduce;
	}

	public Integer getPairId() {
		return PairId;
	}

	public void setPairId(Integer pairId) {
		PairId = pairId;
	}

	public Integer getMemberId1() {
		return memberId1;
	}

	public void setMemberId1(Integer memberId1) {
		this.memberId1 = memberId1;
	}

	public Integer getMemberId2() {
		return memberId2;
	}

	public void setMemberId2(Integer memberId2) {
		this.memberId2 = memberId2;
	}

	public Integer getFriends1() {
		return friends1;
	}

	public void setFriends1(Integer friends1) {
		this.friends1 = friends1;
	}

	public Integer getFriends2() {
		return friends2;
	}

	public void setFriends2(Integer friends2) {
		this.friends2 = friends2;
	}

	public Date getPairDate() {
		return pairDate;
	}

	public void setPairDate(Date pairDate) {
		this.pairDate = pairDate;
	}

	public Date getFriendDate() {
		return friendDate;
	}

	public void setFriendDate(Date friendDate) {
		this.friendDate = friendDate;
	}

	public Integer getDelete1() {
		return delete1;
	}

	public void setDelete1(Integer delete1) {
		this.delete1 = delete1;
	}

	public Integer getDelete2() {
		return delete2;
	}

	public void setDelete2(Integer delete2) {
		this.delete2 = delete2;
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

	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	public Integer getGender() {
		return gender;
	}

	public void setGender(Integer gender) {
		this.gender = gender;
	}

	public Date getMemberBithday() {
		return memberBithday;
	}

	public void setMemberBithday(Date memberBithday) {
		this.memberBithday = memberBithday;
	}

	public String getMemberIntroduce() {
		return memberIntroduce;
	}

	public void setMemberIntroduce(String memberIntroduce) {
		this.memberIntroduce = memberIntroduce;
	}

}
