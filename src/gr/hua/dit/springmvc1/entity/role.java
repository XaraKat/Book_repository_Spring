package gr.hua.dit.springmvc1.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "user_roles")
public class role {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_role_id")
	private String user_role_id;

	@Column(name = "username")
	private String username;

	@Column(name = "role")
	private String role;

	public String getRole() {
		return role;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setRole(String role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "role [user_role_id=" + user_role_id + ", username=" + username + ", role=" + role + "]";
	}

}
