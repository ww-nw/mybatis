package com.kaishengit.entity;

public class User {
	private Integer id;
	private String address;
	private String password;
	private String userName;
	public Dept getDept() {
		return dept;
	}


	public void setDept(Dept dept) {
		this.dept = dept;
	}
	private Dept dept;
	
	
	@Override
	public String toString() {
		return "User [id=" + id + ", address=" + address + ", password=" + password + ", userName=" + userName + "]";
	}
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}

}