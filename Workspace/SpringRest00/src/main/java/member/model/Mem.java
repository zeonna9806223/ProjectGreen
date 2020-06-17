package member.model;

import java.sql.Blob;
import java.sql.Date;
import java.sql.Timestamp;

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
@Table(name = "Mem")
@Component("mem")
@DynamicUpdate
@Scope("prototype")
public class Mem {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer memId;
	private String name;
	private String password;
	@Transient
	private String password1;
	private String email;
	private Date birthday;
	private java.util.Date lastPostTime;
	private Timestamp registerTime;
	private String memberAccount;
	private String memberAddress;
	private String memberCellPhone;
	private Integer gender;
	private String fileName;
	private Integer login;
	
	public String getMemberAddress() {
		return memberAddress;
	}

	public void setMemberAddress(String memberAddress) {
		this.memberAddress = memberAddress;
	}

	public String getMemberCellPhone() {
		return memberCellPhone;
	}

	public void setMemberCellPhone(String memberCellPhone) {
		this.memberCellPhone = memberCellPhone;
	}

	public Integer getGender() {
		return gender;
	}

	public void setGender(Integer gender) {
		this.gender = gender;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public Integer getLogin() {
		return login;
	}

	public void setLogin(Integer login) {
		this.login = login;
	}



	//	private Double totalPayment;
	private Blob photo;
	
	public Mem(Integer memId, String name) {
		this.memId = memId;
		this.name = name;
	}

	public Mem() {  
	}



	public Integer getMemId() {
		return memId;
	}

	public void setMemId(Integer memId) {
		this.memId = memId;
	}
	
	public String getMemberAccount() {
		return memberAccount;
	}

	public void setMemberAccount(String memberAccount) {
		this.memberAccount = memberAccount;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPassword1() {
		return password1;
	}

	public void setPassword1(String password1) {
		this.password1 = password1;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public java.util.Date getLastPostTime() {
		return lastPostTime;
	}

	public void setLastPostTime(java.util.Date lastPostTime) {
		this.lastPostTime = lastPostTime;
	}

	public Timestamp getRegisterTime() {
		return registerTime;
	}

	public void setRegisterTime(Timestamp registerTime) {
		this.registerTime = registerTime;
	}

//	public Double getTotalPayment() {
//		return totalPayment;
//	}
//
//	public void setTotalPayment(Double totalPayment) {
//		this.totalPayment = totalPayment;
//	}

	public Blob getPhoto() {
		return photo;
	}

	public void setPhoto(Blob photo) {
		this.photo = photo;
	}



	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("CustomerBean [stomerId=");
		builder.append(memId);
		builder.append(", memberAccount=");
		builder.append(memberAccount);
		builder.append(", name=");
		builder.append(name);
		builder.append(", password=");
		builder.append(password);
		builder.append(", password1=");
		builder.append(password1);
		builder.append(", email=");
		builder.append(email);
		builder.append(", birthday=");
		builder.append(birthday);
		builder.append(", lastPostTime=");
		builder.append(lastPostTime);
		builder.append(", registerTime=");
		builder.append(registerTime);
		builder.append(", totalPayment=");
//		builder.append(totalPayment);
		builder.append(", photo=");
		builder.append(photo);
		builder.append("]");
		return builder.toString();
	}

}
