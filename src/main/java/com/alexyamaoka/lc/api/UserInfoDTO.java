package com.alexyamaoka.lc.api;

public class UserInfoDTO {
	
	// data transfer object 
	
	
	private String username;
	private String crushName;
	
	
	public UserInfoDTO() {
		this.username = "user name demo";
		this.crushName = "crush name demo";
		System.out.println("User Info DTO constructor called");
	}
	
	public String getUsername() {
		return username;
	}
	
	public String getCrushName() {
		return crushName;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public void setCrushName(String crushName) {
		this.crushName = crushName;
	}
	
	@Override
	public String toString() {
		return "UserInfoDTO [username=" + username + ", crushName=" + crushName + "]";
	}
}