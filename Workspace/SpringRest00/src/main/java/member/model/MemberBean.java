package member.model;

import java.sql.Blob;
import java.sql.Date;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.DynamicUpdate;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Entity
@Table(name="Member3")
@Component("memb")
@DynamicUpdate
@Scope("prototype")
public class MemberBean{
	Integer pKey;
	String memberAccount;
	String memberName;
	String memberPWD;
	//
	String password1;
	//
	String memberAddress;
	String memberEmail;
	String memberCellPhone;
	Timestamp memberJoinDate;
	Blob memberImage;
	String gender;
	String fileName;
	//
	Integer login;
	Timestamp registerTime;
	java.util.Date lastPostTime;
	Date birthday;
	//
//	 Integer isVIP;
//	 String fitLook;// 體態
	 
	public MemberBean(Integer pKey,
					  String memberAccount, String memberName,String memberPWD, 
					  String memberAddress, String memberEmail,String memberCellPhone,
					  Timestamp memberJoinDate,Blob memberImage,String gender,String fileName) {
		this.pKey = pKey;
		this.memberAccount = memberAccount;
		this.memberName = memberName;
		this.memberPWD = memberPWD;
		this.memberAddress = memberAddress;
		this.memberEmail = memberEmail;
		this.memberCellPhone = memberCellPhone;
		this.memberJoinDate = memberJoinDate;
		this.memberImage = memberImage;
		this.gender = gender;
		this.fileName = fileName;
	}

	public MemberBean() {
	}

	@Id @Column(name="MemberID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getPKey() {
		return pKey;
	}
	public void setPKey(Integer pKey) {
		this.pKey = pKey;
	}

	@Column(name="MemberAccount")
	public String getMemberAccount() {
		return memberAccount;
	}
	public void setMemberAccount(String memberAccount) {
		this.memberAccount = memberAccount;
	}

	@Column(name="MemberName")
	public String getMemberName() {
		return memberName;
	}
	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}



	@Column(name="MemberPWD")
	public String getMemberPWD() {
		return memberPWD;
	}
	public void setMemberPWD(String memberPWD) {
		this.memberPWD = memberPWD;
	}



	@Transient
	public String getPassword1() {
		return password1;
	}
	public void setPassword1(String password1) {
		this.password1 = password1;
	}



	@Column(name="MemberAddress")
	public String getMemberAddress() {
		return memberAddress;
	}
	public void setMemberAddress(String memberAddress) {
		this.memberAddress = memberAddress;
	}



	@Column(name = "MemberEmail")
	public String getMemberEmail() {
		return memberEmail;
	}
	public void setMemberEmail(String memberEmail) {
		this.memberEmail = memberEmail;
	}



	@Column(name = "MemberCellPhone")
	public String getMemberCellPhone() {
		return memberCellPhone;
	}
	public void setMemberCellPhone(String memberCellPhone) {
		this.memberCellPhone = memberCellPhone;
	}



	@Transient
	public Timestamp getMemberJoinDate() {
		return memberJoinDate;
	}
	public void setMemberJoinDate(Timestamp memberJoinDate) {
		this.memberJoinDate = memberJoinDate;
	}



	@Column(name = "MemberImage")
	public Blob getMemberImage() {
		return memberImage;
	}
	public void setMemberImage(Blob memberImage) {
		this.memberImage = memberImage;
	}



	@Column(name = "Gender")
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}



	@Column(name = "FileName")
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}



	@Column(name = "Login")
	public Integer getLogin() {
		return login;
	}
	public void setLogin(Integer login) {
		this.login = login;
	}



	@Column(name = "MemberJoinDate")
	public Timestamp getRegisterTime() {
		return registerTime;
	}
	public void setRegisterTime(Timestamp registerTime) {
		this.registerTime = registerTime;
	}


	@Column(name = "LastPostTime")
	public java.util.Date getLastPostTime() {
		return lastPostTime;
	}
	public void setLastPostTime(java.util.Date lastPostTime) {
		this.lastPostTime = lastPostTime;
	}



	@Column(name = "Birthday")
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	
}
