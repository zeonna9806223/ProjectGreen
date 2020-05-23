package social.model.bean;

import java.sql.Blob;
import java.util.Date;

public class FriendInfoBean {
	private Integer memberId;
	private String memberName;
	private Integer gender;
	private java.sql.Date memberBithday;
	private String memberIntroduce;
	private Integer profileHeight;
	private Integer profileWeight;
	private Blob image;
	private String imageToJason;
	
	public FriendInfoBean() {
	}

	
	public FriendInfoBean(Integer memberId, String memberName, Integer gender, java.sql.Date memberBithday,
			String memberIntroduce, Integer profileHeight, Integer profileWeight, Blob image, String imageToJason) {
		this.memberId = memberId;
		this.memberName = memberName;
		this.gender = gender;
		this.memberBithday = memberBithday;
		this.memberIntroduce = memberIntroduce;
		this.profileHeight = profileHeight;
		this.profileWeight = profileWeight;
		this.image = image;
		this.imageToJason = imageToJason;
	}

	public FriendInfoBean(Integer memberId, String memberName, Integer gender, java.sql.Date memberBithday,
			String memberIntroduce, Integer profileHeight, Integer profileWeight, String imageToJason) {
		this.memberId = memberId;
		this.memberName = memberName;
		this.gender = gender;
		this.memberBithday = memberBithday;
		this.memberIntroduce = memberIntroduce;
		this.profileHeight = profileHeight;
		this.profileWeight = profileWeight;
		this.imageToJason = imageToJason;
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

	public void setMemberBithday(java.sql.Date memberBithday) {
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

	public Blob getImage() {
		return image;
	}

	public void setImage(Blob image) {
		this.image = image;
	}
	public String getImageToJason() {
		return imageToJason;
	}

	public void setImageToJason(String imageToJason) {
		this.imageToJason = imageToJason;
	}
}
