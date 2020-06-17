package accommodation.edit.model.bean;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;
//@Component
@Entity
@Table(name = "EditDetail")
public class EditDetail {
	@Id@Column(name = "editId")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int editId;
	@Column(name = "editorId")
	private int editorId;
	@Column(name = "editorName")
	private String editorName;
	@Column(name = "updateTime")
	private Timestamp updateTime;
	@Column(name = "hotelId")
	private int hotelId;
	@Column(name = "name")
	private String name;
	@Column(name = "regionId")
	private String regionId;
	@Column(name = "townId")
	private String townId;
	@Column(name = "address")
	private String address;
	@Column(name = "tel")
	private String tel;
	@Column(name = "email")
	private String email;
	@Column(name = "website")
	private String website;
	@Column(name = "lowestPrice")
	private int lowestPrice;
	@Column(name = "status")
	private String status;
	
	
	
	
	
	public EditDetail(Timestamp updateTime, String status) {
		super();
		this.updateTime = updateTime;
		this.status = status;
	}


	public EditDetail(int editorId, String editorName, int hotelId, String name, String regionId, String townId,
			String address, String tel, String email, String website, int lowestPrice, String status) {
		super();
		this.editorId = editorId;
		this.editorName = editorName;
		this.hotelId = hotelId;
		this.name = name;
		this.regionId = regionId;
		this.townId = townId;
		this.address = address;
		this.tel = tel;
		this.email = email;
		this.website = website;
		this.lowestPrice = lowestPrice;
		this.status = status;
	}


	public EditDetail() {
		super();
	}
	
	
	public int getEditId() {
		return editId;
	}
	public void setEditId(int editId) {
		this.editId = editId;
	}
	public int getEditorId() {
		return editorId;
	}
	public void setEditorId(int editorId) {
		this.editorId = editorId;
	}
	public String getEditorName() {
		return editorName;
	}
	public void setEditorName(String editorName) {
		this.editorName = editorName;
	}
	public Timestamp getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(Timestamp updateTime) {
		this.updateTime = updateTime;
	}
	public int getHotelId() {
		return hotelId;
	}
	public void setHotelId(int hotelId) {
		this.hotelId = hotelId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getRegionId() {
		return regionId;
	}
	public void setRegionId(String regionId) {
		this.regionId = regionId;
	}
	public String getTownId() {
		return townId;
	}
	public void setTownId(String townId) {
		this.townId = townId;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getWebsite() {
		return website;
	}
	public void setWebsite(String website) {
		this.website = website;
	}
	public int getLowestPrice() {
		return lowestPrice;
	}
	public void setLowestPrice(int lowestPrice) {
		this.lowestPrice = lowestPrice;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	


	

}
