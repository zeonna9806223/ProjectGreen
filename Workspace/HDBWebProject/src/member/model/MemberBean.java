package member.model;

import java.io.Serializable;
import java.sql.Blob;
import java.sql.Timestamp;

public class MemberBean implements Serializable {
	private static final long serialVersionUID = 1L;
	Integer pKey;
	String memberAccount;
	String memberName;
	String memberPWD;
	String memberAddress;
	String memberEmail;
	String memberCellPhone;
	Timestamp memberJoinDate;
	Blob memberImage;
	String gender;
	String fileName;
	
	
	 Integer isVIP;
	 String fitLook;// 體態
	 
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


	public String getFileName() {
		return fileName;
	}


	public void setFileName(String fileName) {
		this.fileName = fileName;
	}


	//default constructor
	public MemberBean() {
	}


	public Integer getPKey() {
		return pKey;
	}


	public void setPKey(Integer pKey) {
		this.pKey = pKey;
	}


	public String getMemberAccount() {
		return memberAccount;
	}


	public void setMemberAccount(String memberAccount) {
		this.memberAccount = memberAccount;
	}


	public String getMemberName() {
		return memberName;
	}


	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}


	public String getMemberPWD() {
		return memberPWD;
	}


	public void setMemberPWD(String memberPWD) {
		this.memberPWD = memberPWD;
	}


	public String getMemberAddress() {
		return memberAddress;
	}


	public void setMemberAddress(String memberAddress) {
		this.memberAddress = memberAddress;
	}


	public String getMemberEmail() {
		return memberEmail;
	}


	public void setMemberEmail(String memberEmail) {
		this.memberEmail = memberEmail;
	}


	public String getMemberCellPhone() {
		return memberCellPhone;
	}


	public void setMemberCellPhone(String memberCellPhone) {
		this.memberCellPhone = memberCellPhone;
	}


	public Timestamp getMemberJoinDate() {
		return memberJoinDate;
	}


	public void setMemberJoinDate(Timestamp memberJoinDate) {
		this.memberJoinDate = memberJoinDate;
	}


	public Blob getMemberImage() {
		return memberImage;
	}


	public void setMemberImage(Blob memberImage) {
		this.memberImage = memberImage;
	}


	public String getGender() {
		return gender;
	}


	public void setGender(String gender) {
		this.gender = gender;
	}
	
	
}
