package social.model.bean;

import java.sql.Blob;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Member3")
public class MemberBean2 {
	@Id @Column(name="MemberID")
	private Integer memberID;
	@Column(name="MemberName")
	private String memberName;
	@Column(name="Gender")
	private Integer gender;
	@Column(name="MemberImage")
	private java.sql.Blob image;
	
	public MemberBean2() {

	}

	public MemberBean2(Integer memberID, String memberName, Integer gender) {
		this.memberID = memberID;
		this.memberName = memberName;
		this.gender = gender;
	}

	public MemberBean2(Integer memberID, String memberName, Integer gender, Blob image) {
		this.memberID = memberID;
		this.memberName = memberName;
		this.gender = gender;
		this.image = image;
	}

	public Integer getMemberID() {
		return memberID;
	}

	public void setMemberID(Integer memberID) {
		this.memberID = memberID;
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

	public Blob getImage() {
		return image;
	}

	public void setImage(Blob image) {
		this.image = image;
	}

}
