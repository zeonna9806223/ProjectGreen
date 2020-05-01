package citty.model;

import java.io.Serializable;

public class showBean implements Serializable {
	private static final long serialVersionUID = 1L;
	private String name;
	private String tel;
	private String add;
	
	public showBean() {
		
	}
	public showBean(String Name, String Tel, String Add) {
		
		super();
		this.name = Name;
		this.tel = Tel;
		this.add = Add;
	}
	@Override
	public String toString() {
		return "showBean [Name=" + name + ", Tel=" + tel + ", Add="+ add + "]";
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getAdd() {
		return add;
	}
	public void setAdd(String add) {
		this.add = add;
	}
	
}