package social.bean;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="Matches")
public class MatchesBean {
	@Id @Column(name="PairId")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer pairId;
	@Column(name="MemberId1")
	private Integer memberId1;
	@Column(name="MemberId2")
	private Integer memberId2;
	@Column(name="Friends1")
	private Integer friends1;
	@Column(name="Friends2")
	private Integer friends2;
	@Column(name="PairDate")	
	private java.sql.Date pairDate;
	@Column(name="FriendDate")	
	private java.sql.Date friendDate;
	@Column(name="Delete1")
	private Integer delete1;
	@Column(name="Delete2")
	private Integer delete2;
	@Transient
	private Integer profileHeight;
	@Transient
	private Integer profileWeight;
	@Transient
	private String memberName;
	@Transient
	private Integer gender;
	@Transient
	private java.sql.Date memberBithday;
	@Transient
	private String memberIntroduce;
	
	public MatchesBean() {
		
	}
	
	//insert配對用建構子
	public MatchesBean(Integer memberId1, Integer memberId2, java.sql.Date pairDate, Integer delete1, Integer delete2) {
		this.memberId1 = memberId1;
		this.memberId2 = memberId2;
		this.pairDate = pairDate;
		this.delete1 = delete1;
		this.delete2 = delete2;
	}

	public MatchesBean(Integer pairId, Integer memberId1, Integer memberId2, Integer friends1, Integer friends2,
			java.sql.Date pairDate, java.sql.Date friendDate, Integer delete1, Integer delete2) {
		this.pairId = pairId;
		this.memberId1 = memberId1;
		this.memberId2 = memberId2;
		this.friends1 = friends1;
		this.friends2 = friends2;
		this.pairDate = pairDate;
		this.friendDate = friendDate;
		this.delete1 = delete1;
		this.delete2 = delete2;
	}

	public MatchesBean(Integer pairId, Integer memberId1, Integer memberId2, Integer friends1, Integer friends2,
			java.sql.Date pairDate, java.sql.Date friendDate, Integer delete1, Integer delete2, Integer profileHeight,
			Integer profileWeight, String memberName, Integer gender, java.sql.Date memberBithday, String memberIntroduce) {
		this.pairId = pairId;
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
		return pairId;
	}

	public void setPairId(Integer pairId) {
		this.pairId = pairId;
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

	public void setPairDate(java.sql.Date pairDate) {
		this.pairDate = pairDate;
	}

	public Date getFriendDate() {
		return friendDate;
	}

	public void setFriendDate(java.sql.Date friendDate) {
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

	public void setMemberBithday(java.sql.Date memberBithday) {
		this.memberBithday = memberBithday;
	}

	public String getMemberIntroduce() {
		return memberIntroduce;
	}

	public void setMemberIntroduce(String memberIntroduce) {
		this.memberIntroduce = memberIntroduce;
	}

}
