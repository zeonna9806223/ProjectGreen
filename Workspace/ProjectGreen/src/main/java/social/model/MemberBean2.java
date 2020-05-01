package social.model; 

import java.io.Serializable; 
import java.sql.Date;
import java.sql.Timestamp;
import java.sql.Blob;
import java.sql.Clob;
import java.sql.Timestamp;

public class MemberBean2 implements Serializable {
	private static final long serialVersionUID = 1L;

//	 Integer pk; //ID
//	 String memberAccount;// 帳號
//	 String memberPWD;// 密碼
//	 String memberName;// 姓名
	 Integer gender; // 性別
//	 Date memberBirthday;	// 生日
//	 String memberPhone;     			// 電話
//	 String memberEmail;
//	 String memberAddress;
	 Timestamp memberJoinDate;	// 會員登錄日期
	 Integer isVIP;
	 String fitLook;// 體態
	


	
	
	public MemberBean2(Integer pk, String memberAccount,String memberName, 
						String memberPWD,Integer gender, Date memberBirthday,
						String memberPhone,String fitLook ,String memberAddress,
						Timestamp memberJoinDate,Integer isVIP,String memberEmail) {
//		this.pk = pk;
//		this.memberAccount = memberAccount;
//		this.memberName = memberName;
//		this.memberPWD = memberPWD;
//		this.memberPhone = memberPhone;
//		this.memberBirthday = memberBirthday;
		this.gender = gender;
		this.memberJoinDate = memberJoinDate;
		this.fitLook = fitLook;
		this.isVIP = isVIP;
//		this.memberEmail = memberEmail;
//		this.memberAddress =memberAddress;
		
				
	}
	
	
	public MemberBean2() {
	} 
	//
	
//	public Integer getPk() {
//		return pk;
//	}
//
//	public void setPk(Integer pk) {
//		this.pk = pk;
//	}
	
	

//	public String getMemberEmail() {
//		return memberEmail;
//	}
//
//	public void setMemberEmail(String memberEmail) {
//		this.memberEmail = memberEmail;
//	}
//
//	public String getMemberAddress() {
//		return memberAddress;
//	}
//
//	public void setMemberAddress(String memberAddress) {
//		this.memberAddress = memberAddress;
//	}

	public Integer getIsVIP() {
		return isVIP;
	}

	public void setIsVIP(Integer isVIP) {
		this.isVIP = isVIP;
	}

	public Timestamp getMmemberJoinDate() {
		return memberJoinDate;
	}

		
	public void setMemberJoinDate(java.sql.Timestamp memberJoinDate) {
		this.memberJoinDate = memberJoinDate;
	}
	

	
	
//	@Override
//	public String toString() {
//		return "MemberBean2 [pk=" + pk + ", memberAccount=" + memberAccount + ", memberPWD=" + memberPWD + ", memberName=" + memberName
//				+ ", memberPhone=" + memberPhone + ", memberBirthday=" + memberBirthday + ", memberJoinDate" + memberJoinDate + ", fitLook="
//				+ fitLook + "]";
//	}

	
	public String toString() {
		return "VIP="+isVIP+"meberJoinDate="+memberJoinDate+"gender="+gender+"fitLook="+fitLook;
	}
	
	
//	public String getMemberAccount() {
//		return memberAccount;
//	}
//
//	public void setMemberAccount(String memberAccount) {
//		this.memberAccount = memberAccount;
//	}
//
//	public String getMemberPWD() {
//		return memberPWD;
//	}
//
//	public void setMemberPWD(String memberPWD) {
//		this.memberPWD = memberPWD;
//	}
//
//	public String getMemberName() {
//		return memberName;
//	}
//
//	public void setMemberName(String memberName) {
//		this.memberName = memberName;
//	}
//
//	public String getMemberPhone() {
//		return memberPhone;
//	}
//
//	public void setMemberPhone(String memberPhone) {
//		this.memberPhone = memberPhone;
//	}
//
//	public Date getMemberBirthday() {
//		return memberBirthday;
//	}
//
//	public void setMemberBirthday(Date memberBirthday) {
//		this.memberBirthday = memberBirthday;
//	}

	public Integer getGender() {
		return gender;
	}

	public void setGender(Integer gender) {
		this.gender = gender;
	}

	public String getFitLook() {
		return fitLook;
	}

	public void setFitLook(String fitLook) {
		this.fitLook = fitLook;
	}



	
}