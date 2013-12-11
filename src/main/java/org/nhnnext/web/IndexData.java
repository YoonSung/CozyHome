package org.nhnnext.web;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class IndexData {

	@Id
	//@GeneratedValue(strategy=GenerationType.AUTO)
	private String id;
	
	@Column(length=20, nullable=false)
	private String password;
	
	@Column(length=20, nullable=false)
	private String nickname;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getNickname() {
		return nickname;
	}
	
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	@Override
	public String toString() {
		return "IndexData [id=" + id + ", password=" + password + ", nickname="
				+ nickname + "]";
	}
}
