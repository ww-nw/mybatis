package com.kaishengit.entity;

import java.io.Serializable;
import java.util.List;

public class Dept implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String daptName;
	private List<User> userList;
	
	
	public List<User> getUserList() {
		return userList;
	}
	public void setUserList(List<User> userList) {
		this.userList = userList;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getDaptName() {
		return daptName;
	}
	public void setDaptName(String daptName) {
		this.daptName = daptName;
	}
	
	
}
