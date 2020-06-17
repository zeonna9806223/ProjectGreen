package attractions.Bean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "AttractionsEdited")
public class AttractionEdited implements Serializable {
	private static final long serialVersionUID = 1L;
	private int id;
	private String name;
	private String location;
	private String tel;
	private String region;
	private String town;
	
	public AttractionEdited () {
	}
	public AttractionEdited (int id, String name, String location, String tel, String region, String town) {
		super();
		this.id = id;
		this.name = name;
		this.location = location;
		this.tel = tel;
		this.region = region;
		this.town = town;
	}
	
	@Id @Column(name="id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	@Column(name = "name")
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Column(name = "location")
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	@Column(name = "tel")
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	@Column(name = "region")
	public String getRegion() {
		return region;
	}
	public void setRegion(String region) {
		this.region = region;
	}
	@Column(name = "town")
	public String getTown() {
		return town;
	}
	public void setTown(String town) {
		this.town = town;
	}
}
	
	
	
	
