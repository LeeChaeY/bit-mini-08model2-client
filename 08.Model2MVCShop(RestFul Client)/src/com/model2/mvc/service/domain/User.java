package com.model2.mvc.service.domain;

import java.sql.Date;


public class User {
	
	private String userId;
	private String userName;
	private String password;
	private String role;
	private String ssn;
	private String phone;
	private String addr;
	private String email;
	private Date regDate;
	
	private String phone1;
	private String phone2;
	private String phone3;
	
	//////////////////////////////////////////////////////////////////////////////////////////////
	// JSON ==> Domain Object  Binding을 위해 추가된 부분
	private String regDateString;
	
	public User(){
	}
	
	public User(String userId) {
		// TODO Auto-generated constructor stub
		this.userId = userId;
	}

	public User(String userId, String userName, String password, String ssn, String phone, String addr, String email) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.password = password;
		this.ssn = ssn;
		this.phone = phone;
		this.addr = addr;
		this.email = email;
	}

	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getSsn() {
		return ssn;
	}
	public void setSsn(String ssn) {
		this.ssn = ssn;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
		
		if(phone != null && phone.length() !=0 ){
			phone1 = phone.split("-")[0];
			phone2 = phone.split("-")[1];
			phone3 = phone.split("-")[2];
		}
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Date getRegDate() {
		return regDate;
	}
	//////////////////////////////////////////////////////////////////////////////////////////////
	// JSON ==> Domain Object  Binding을 위해 추가된 부분
	public void setRegDate(Date regDate) {
		this.regDate = regDate;
		
		if(regDate !=null) {
			// JSON ==> Domain Object  Binding을 위해 추가된 부분
			this.setRegDateString( regDate.toString().split("-")[0]
													+"-"+ regDate.toString().split("-")[1]
													+ "-" +regDate.toString().split("-")[2] );
		}
	}
	
	public String getPhone1() {
		return phone1;
	}
	public String getPhone2() {
		return phone2;
	}
	public String getPhone3() {
		return phone3;
	}
	
	public String getRegDateString() {
		return regDateString;
	}

	public void setRegDateString(String regDateString) {
		this.regDateString = regDateString;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "UserVO : [userId] "+userId+" [userName] "+userName+" [password] "+password+" [role] "+ role
			+" [ssn] "+ssn+" [phone] "+phone+" [email] "+email+" [regDate] "+regDate;
	}
}
