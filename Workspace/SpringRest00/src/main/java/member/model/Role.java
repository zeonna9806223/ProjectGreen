package member.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "role")
public class Role {

	@Id
	@Column(name = "role_seq")
	private Integer roleSeq;

	@Column(name = "user_seq")
	private Integer userSeq;

	@Column(name = "role_name")
	private String roleName;

	public Integer getRoleSeq() {
		return roleSeq;
	}

	public void setRoleSeq(Integer roleSeq) {
		this.roleSeq = roleSeq;
	}

	public Integer getUserSeq() {
		return userSeq;
	}

	public void setUserSeq(Integer userSeq) {
		this.userSeq = userSeq;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

}