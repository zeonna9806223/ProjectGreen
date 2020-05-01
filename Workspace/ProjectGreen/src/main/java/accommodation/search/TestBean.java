package accommodation.search;

import java.util.List;
import java.util.Map;

public class TestBean implements java.io.Serializable {
	private static final long serialVersionUID = 1L;

	SearchJdbcDao3 s = new SearchJdbcDao3();

	List<String> list1 = s.regionChoice();
	String region;
	List<String> list2 = s.townChoice(region);
	String town;
	Map<Integer, TestBean> map = s.hotelChoice(town);

	
	String name;
	String tel;
	String addr;
	String price;
	
	
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
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public TestBean(String name, String tel, String addr, String price) {
		super();
		this.name = name;
		this.tel = tel;
		this.addr = addr;
		this.price = price;
	}
	public TestBean() {
		super();
	}
	
	
	public String getRegoin() {
		return region;
	}

	public void setRegoin(String region) {
		this.region = region;
	}

	public String getTown() {
		return town;
	}

	public void setTown(String town) {
		this.town = town;
	}

	public List<String> getList1() {
		return list1;
	}

	public void setList1(List<String> list1) {

		this.list1 = list1;
	}

	public List<String> getList2() {
		return list2;
	}

	public void setList2(List<String> list2) {
		this.list2 = list2;
	}

	public Map<Integer, TestBean> getMap() {
		return map;
	}


	public void setMap(Map<Integer, TestBean> map) {
		this.map = map;
	}

}
