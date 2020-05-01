package accommodation.edit.model;

import java.util.List;

public class EditBean {

	List<String> hotelList;
	List<String> userName;
	
	String uname;
	String utel;
	String uemail;


	String Hname;
	String Htel;
	String Hemail;
	String Hweb;
	String HregionId;
	String Hregion;
	String HtownId;
	String Htown;
	String Haddr;
	String Hprice;
	
	String r;//region
	String rid;
	String t;//town
	int tid;
	
	int eid;
	int hid;
	int uid;
	
	public EditBean(String hname, String haddr, String hregionId, String hregion, String htownId, String htown,
			String htel, String hweb,  int price,String hemail) {
		super();
		Hname = hname;
		Htel = htel;
		Hemail = hemail;
		Hweb = hweb;
		HregionId = hregionId;
		Hregion = hregion;
		HtownId = htownId;
		Htown = htown;
		Haddr = haddr;
		this.price = price;
	}

	public String getHregionId() {
		return HregionId;
	}

	public void setHregionId(String hregionId) {
		HregionId = hregionId;
	}

	public String getHtownId() {
		return HtownId;
	}

	public void setHtownId(String htownId) {
		HtownId = htownId;
	}

	public EditBean(int hid,String hname, String hregion, String htown, String haddr,String htel, String hemail, String hweb, 
			 int price) {
		super();
		Hname = hname;
		Htel = htel;
		Hemail = hemail;
		Hweb = hweb;
		Hregion = hregion;
		Htown = htown;
		Haddr = haddr;
		this.hid = hid;
		this.price = price;
	}

	public EditBean(String r, String rid, String t, int tid) {
		super();
		this.r = r;
		this.rid = rid;
		this.t = t;
		this.tid = tid;
	}

	int price;
	
	public String getR() {
		return r;
	}

	public void setR(String r) {
		this.r = r;
	}

	public String getRid() {
		return rid;
	}

	public void setRid(String rid) {
		this.rid = rid;
	}

	public String getT() {
		return t;
	}

	public void setT(String t) {
		this.t = t;
	}

	public int getTid() {
		return tid;
	}

	public void setTid(int tid) {
		this.tid = tid;
	}


	
	 public EditBean( int hid, String hname, String haddr, String htel, String hemail, String hweb, int price
			) {
		super();
		Hname = hname;
		Htel = htel;
		Hemail = hemail;
		Hweb = hweb;
		Haddr = haddr;
		this.price = price;
		
		this.hid = hid;
	}

	public int getEid() {
		return eid;
	}

	public void setEid(int eid) {
		this.eid = eid;
	}

	public int getHid() {
		return hid;
	}

	public void setHid(int hid) {
		this.hid = hid;
	}

	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	public String getUtel() {
		return utel;
	}

	public List<String> getUserName() {
		return userName;
	}

	public void setUserName(List<String> userName) {
		this.userName = userName;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public void setUtel(String utel) {
		this.utel = utel;
	}

	public String getUemail() {
		return uemail;
	}

	public void setUemail(String uemail) {
		this.uemail = uemail;
	}

	public String getHname() {
		return Hname;
	}

	public void setHname(String hname) {
		Hname = hname;
	}

	public String getHtel() {
		return Htel;
	}

	public void setHtel(String htel) {
		Htel = htel;
	}

	public String getHemail() {
		return Hemail;
	}

	public void setHemail(String hemail) {
		Hemail = hemail;
	}

	public String getHweb() {
		return Hweb;
	}

	public void setHweb(String hweb) {
		Hweb = hweb;
	}

	public String getHregion() {
		return Hregion;
	}

	public void setHregion(String hregion) {
		Hregion = hregion;
	}

	public String getHtown() {
		return Htown;
	}

	public void setHtown(String htown) {
		Htown = htown;
	}

	public String getHaddr() {
		return Haddr;
	}

	public void setHaddr(String haddr) {
		Haddr = haddr;
	}

	public String getHprice() {
		return Hprice;
	}

	public void setHprice(String hprice) {
		Hprice = hprice;
	}


	

	public List<String> getHotelList() {
		return hotelList;
	}

	public void setHotelList(List<String> hotelList) {
		this.hotelList = hotelList;
	}

	public EditBean() {

	}

	public EditBean(String uname, String utel, String uemail, String hname, String htel, String hemail, String hweb,
			String hregion, String htown, String haddr, String hprice) {
		super();
		this.uname = uname;
		this.utel = utel;
		this.uemail = uemail;
		Hname = hname;
		Htel = htel;
		Hemail = hemail;
		Hweb = hweb;
		Hregion = hregion;
		Htown = htown;
		Haddr = haddr;
		Hprice = hprice;
	}



	public int getPrice() {
		return price;
	}

	public EditBean(String hname, String htel, String hemail, String hweb, String hregion, String htown, String haddr,
			String hprice) {
		super();

		Hname = hname;
		Htel = htel;
		Hemail = hemail;
		Hweb = hweb;
		Hregion = hregion;
		Htown = htown;
		Haddr = haddr;
		Hprice = hprice;
	}
	
	public EditBean(String uname, String utel, String uemail) {
		super();
		this.uname = uname;
		this.utel = utel;
		this.uemail = uemail;

	}
}
