package com.alexyamaoka.lc.api;

public class UserInfoDTO {
	
	private String username;
	private String crushName;
	
	
	
	
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
