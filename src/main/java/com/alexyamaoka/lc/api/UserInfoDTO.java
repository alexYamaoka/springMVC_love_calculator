package com.alexyamaoka.lc.api;


import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class UserInfoDTO {
	
	// data transfer object 
	
	@NotBlank(message = " * Your name cannot be blank")	
	@Size(min = 3, max = 15, message = "{username.size}")
	private String username;
	
	@NotBlank(message = " * Crush name cannot be blank")	
	@Size(min = 3, max = 15, message = " * Crush name should have between 3-15 characters")
	private String crushName;
	
	@AssertTrue(message = " * You have to agree to use our app")
	private boolean agreedToTermsAndCondition;
	
	
	private String result;
	

	

	public UserInfoDTO() {
		System.out.println("User Info DTO constructor called");
	}
	
	public String getUsername() {
		return username;
	}
	
	public String getCrushName() {
		return crushName;
	}
	
	public boolean isAgreedToTermsAndCondition() {
		return agreedToTermsAndCondition;
	}
	
	public String getResult() {
		return result;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	
	public void setCrushName(String crushName) {
		this.crushName = crushName;
	}
	
	public void setAgreedToTermsAndCondition(boolean agreedToTermsAndCondition) {
		this.agreedToTermsAndCondition = agreedToTermsAndCondition;
	}
	
	public void setResult(String result) {
		this.result = result;
	}
	
	@Override
	public String toString() {
		return "UserInfoDTO [username=" + username + ", crushName=" + crushName + "]";
	}
}
