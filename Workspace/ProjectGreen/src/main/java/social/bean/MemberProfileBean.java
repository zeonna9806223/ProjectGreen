package social.bean;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="MemberProfile")
public class MemberProfileBean {
	@Id @Column(name="ProfileId")
	private Integer memberID;
	@Column(name="ProfileHeight")
	private Integer profileHeight;
	@Column(name="ProfileWeight")
	private Integer profileWeight;
	@Column(name="MemberBirthday")
	private java.sql.Date memberBirthday;
	@Column(name="MemberIntroduce")
	private String memberIntroduce;
	
	public MemberProfileBean() {

	}

	public MemberProfileBean(Integer memberID, Integer profileHeight, Integer profileWeight) {
		this.memberID = memberID;
		this.profileHeight = profileHeight;
		this.profileWeight = profileWeight;
	}

	public MemberProfileBean(Integer memberID, Integer profileHeight, Integer profileWeight, Date memberBirthday,
			String memberIntroduce) {
		super();
		this.memberID = memberID;
		this.profileHeight = profileHeight;
		this.profileWeight = profileWeight;
		this.memberBirthday = memberBirthday;
		this.memberIntroduce = memberIntroduce;
	}

	public Integer getMemberID() {
		return memberID;
	}

	public void setMemberID(Integer memberID) {
		this.memberID = memberID;
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

	public java.sql.Date getMemberBirthday() {
		return memberBirthday;
	}

	public void setMemberBirthday(java.sql.Date memberBirthday) {
		this.memberBirthday = memberBirthday;
	}

	public String getMemberIntroduce() {
		return memberIntroduce;
	}

	public void setMemberIntroduce(String memberIntroduce) {
		this.memberIntroduce = memberIntroduce;
	}

}
