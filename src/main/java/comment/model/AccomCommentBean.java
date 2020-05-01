package comment.model;

import java.sql.Timestamp;

public class AccomCommentBean {
	Integer commId;
	String mId;
	Integer accId;
	Timestamp visitday;
	Integer star;
	Timestamp commday;
	String comment;

	public AccomCommentBean(Integer commId, String mId, Integer accId, Timestamp visitday, Integer star,
			Timestamp commday, String comment) {
		super();
		this.commId = commId;
		this.mId = mId;
		this.accId = accId;
		this.visitday = visitday;
		this.star = star;
		this.commday = commday;
		this.comment = comment;
	}
	
	public AccomCommentBean() {
	}
	
	
	// getter and setter
	public Integer getCommId() {
		return commId;
	}
	public void setCommId(Integer commId) {
		this.commId = commId;
	}

	public String getmId() {
		return mId;
	}
	public void setmId(String mId) {
		this.mId = mId;
	}

	public Integer getAccId() {
		return accId;
	}
	public void setAccId(Integer accId) {
		this.accId = accId;
	}

	public Timestamp getVisitday() {
		return visitday;
	}
	public void setVisitday(Timestamp visitday) {
		this.visitday = visitday;
	}

	public Integer getStar() {
		return star;
	}
	public void setStar(Integer star) {
		this.star = star;
	}

	public Timestamp getCommday() {
		return commday;
	}
	public void setCommday(Timestamp commday) {
		this.commday = commday;
	}

	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}

	
	
	
	
}
