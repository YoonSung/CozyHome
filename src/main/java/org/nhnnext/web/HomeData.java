package org.nhnnext.web;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class HomeData {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long rowId;
	private String id;
	private String password;
	public Long getRowId() {
		return rowId;
	}
	public void setRowId(Long id) {
		rowId = id;
	}
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
	@Override
	public String toString() {
		return "HomeData [rowId=" + rowId + ", id=" + id + ", password="
				+ password + "]";
	}
}
