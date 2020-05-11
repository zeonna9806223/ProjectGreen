package member.model;

import java.io.Serializable;
import java.sql.Clob;
import java.sql.Date;

public class MemberDetailBean implements Serializable {

		private static final long serialVersionUID = 1L;
		private Integer pId;
		private Date birthday;
		private Float height;
		private Float weight;
		private Integer fitlook;
		private Clob	introducing;
		private Integer isMemberAvailable;
		private Integer userType;
		private Integer isVip;
		

		public MemberDetailBean(Integer pId, Date birthday,
						  Float height , Float weight ,Integer fitlook, Clob introducing,
						  Integer isMemberAvailable, Integer userType,Integer isVip) {
			this.pId = pId;
			this.birthday = birthday;
			this.height = height;
			this.weight = weight;
			this.fitlook = fitlook;
			this.introducing = introducing;
			this.isMemberAvailable = isMemberAvailable;
			this.userType = userType;
			this.isVip = isVip;
		}
		

		public Integer getpId() {
			return pId;
		}

		public void setpId(Integer pId) {
			this.pId = pId;
		}

		
		public Date getBirthday() {
			return birthday;
		}


		public void setBirthday(Date memberBirthday) {
			this.birthday = memberBirthday;
		}


		public Float getHeight() {
			return height;
		}

		public void setHeight(Float height) {
			this.height = height;
		}

		public Float getWeight() {
			return weight;
		}

		public void setWeight(Float weight) {
			this.weight = weight;
		}

		public Integer getFitlook() {
			return fitlook;
		}

		public void setFitlook(Integer fitlook) {
			this.fitlook = fitlook;
		}
		

		public Clob getIntroducing() {
			return introducing;
		}


		public void setIntroducing(Clob introducing) {
			this.introducing = introducing;
		}


		public Integer getIsMemberAvailable() {
			return isMemberAvailable;
		}

		public void setIsMemberAvailable(Integer isMemberAvailable) {
			this.isMemberAvailable = isMemberAvailable;
		}

		public Integer getUserType() {
			return userType;
		}

		public void setUserType(Integer userType) {
			this.userType = userType;
		}

		public Integer getIsVip() {
			return isVip;
		}

		public void setIsVip(Integer isVip) {
			this.isVip = isVip;
		}


		

}
