package accommodation.search.model.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "accommodation")
public class Accommodation {
	
	
	private int id;
	private String name;
	private String address;
	private String regionId;
	private String region;
	private String townId;
	private String town;
	private String tel;
	private String website;
	private String picture1;
	private String picdescribe1;
	private String picture2;
	private String picdescribe2;
	private String Picture3;
	private String Picdescribe3;
	private int LowestPrice;
	private String IndustryEmail;

	
	
	public Accommodation() {
	}
	
	@Id@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	@Column(name = "Name")
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Column(name = "Address")
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	@Column(name = "RegionId")
	public String getRegionId() {
		return regionId;
	}
	public void setRegionId(String regionId) {
		this.regionId = regionId;
	}
	@Column(name = "Region")
	public String getRegion() {
		return region;
	}
	public void setRegion(String region) {
		this.region = region;
	}
	@Column(name = "TownId")
	public String getTownId() {
		return townId;
	}
	public void setTownId(String townId) {
		this.townId = townId;
	}
	@Column(name = "Town")
	public String getTown() {
		return town;
	}
	public void setTown(String town) {
		this.town = town;
	}
	@Column(name = "Tel")
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	@Column(name = "Website")
	public String getWebsite() {
		return website;
	}
	public void setWebsite(String website) {
		this.website = website;
	}
	@Column(name = "Picture1")
	public String getPicture1() {
		return picture1;
	}
	public void setPicture1(String picture1) {
		this.picture1 = picture1;
	}
	@Column(name = "Picdescribe1")
	public String getPicdescribe1() {
		return picdescribe1;
	}
	public void setPicdescribe1(String picdescribe1) {
		this.picdescribe1 = picdescribe1;
	}
	@Column(name = "Picture2")
	public String getPicture2() {
		return picture2;
	}
	public void setPicture2(String picture2) {
		this.picture2 = picture2;
	}
	@Column(name = "Picdescribe2")
	public String getPicdescribe2() {
		return picdescribe2;
	}
	public void setPicdescribe2(String picdescribe2) {
		this.picdescribe2 = picdescribe2;
	}
	@Column(name = "Picture3")
	public String getPicture3() {
		return Picture3;
	}
	public void setPicture3(String picture3) {
		Picture3 = picture3;
	}
	@Column(name = "Picdescribe3")
	public String getPicdescribe3() {
		return Picdescribe3;
	}
	public void setPicdescribe3(String picdescribe3) {
		Picdescribe3 = picdescribe3;
	}
	@Column(name = "LowestPrice")
	public int getLowestPrice() {
		return LowestPrice;
	}
	public void setLowestPrice(int lowestPrice) {
		LowestPrice = lowestPrice;
	}
	@Column(name = "IndustryEmail")
	public String getIndustryEmail() {
		return IndustryEmail;
	}
	public void setIndustryEmail(String industryEmail) {
		IndustryEmail = industryEmail;
	}
	
}
