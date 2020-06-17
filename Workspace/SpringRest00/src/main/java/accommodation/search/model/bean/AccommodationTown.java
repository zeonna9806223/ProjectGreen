package accommodation.search.model.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;
@Component
@Entity
@Table(name = "AccommodationTown")
public class AccommodationTown {
	@Id@Column(name = "townId")
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private short townId;
	@Column(name = "town")
	private String town;
	@Column(name = "zipcode")
	private String zipcode;
	@Column(name = "regionId")
	private String regionId;
	@Column(name = "region")
	private String region;
	public short getTownId() {
		return townId;
	}
	public void setTownId(short townId) {
		this.townId = townId;
	}
	public String getTown() {
		return town;
	}
	public void setTown(String town) {
		this.town = town;
	}
	public String getZipcode() {
		return zipcode;
	}
	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}
	public String getRegionId() {
		return regionId;
	}
	public void setRegionId(String regionId) {
		this.regionId = regionId;
	}
	public String getRegion() {
		return region;
	}
	public void setRegion(String region) {
		this.region = region;
	}
	
	
}
