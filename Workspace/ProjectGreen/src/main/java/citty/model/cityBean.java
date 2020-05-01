package citty.model;

import java.io.Serializable;

public class cityBean implements Serializable {
	private static final long serialVersionUID = 1L;
	String Region;
	String Town;
	
	public cityBean() {
		
	}
	public cityBean(String Region, String Town) {
		
		super();
		this.Region = Region;
		this.Town = Town;
	}
	@Override
	public String toString() {
		return "cityBean [Region=" + Region + ", Town=" + Town + "]";
	}
	public String getRegion() {
		return Region;
	}
	public void setRegion(String region) {
		Region = region;
	}
	public String getTown() {
		return Town;
	}
	public void setTown(String town) {
		Town = town;
	}
	
}
