package social.bean;

import java.util.Date;

public class FriendInfoBean {
	private Integer memberId;
	private String memberName;
	private Integer gender;
	private Date memberBithday;
	private String memberIntroduce;
	private Integer profileHeight;
	private Integer profileWeight;
	
	public FriendInfoBean() {
		super();
	}

	public FriendInfoBean(Integer memberId, String memberName, Integer gender, Date memberBithday,
			String memberIntroduce, Integer profileHeight, Integer profileWeight) {
		this.memberId = memberId;
		this.memberName = memberName;
		this.gender = gender;
		this.memberBithday = memberBithday;
		this.memberIntroduce = memberIntroduce;
		this.profileHeight = profileHeight;
		this.profileWeight = profileWeight;
	}

	public Integer getMemberId() {
		return memberId;
	}

	public void setMemberId(Integer memberId) {
		this.memberId = memberId;
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
	
}
