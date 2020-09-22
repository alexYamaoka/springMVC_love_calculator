package com.alexyamaoka.lc.api;

public class UserRegistrationDTO {
	
	private String name;
	private String username;
	private char[] password;
	private String  country;
	private String[] hobbies;
	private String gender;
	
	//@AgeValidator(lower = 18, upper = 60, message = "the age should be between 18 - 60")
	private int age;
	
	

	private CommunicationDTO communicationDTO;
	
	

	public String getName() {
		return name;
	}
	
	public String getUsername() {
		return username;
	}
	
	public char[] getPassword() {
		return password;
	}
	
	public String getCountry() {
		return country;
	}
	
	public String[] getHobbies() {
		return hobbies;
	}
	
	public String getGender() {
		return gender;
	}
	
	public int getAge() {
		return age;
	}

	public CommunicationDTO getCommunicationDTO() {
		return communicationDTO;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public void setPassword(char[] password) {
		this.password = password;
	}

	public void setCountry(String country) {
		this.country = country;
	}
	
	public void setHobbies(String[] hobbies) {
		this.hobbies = hobbies;
	}
	
	public void setGender(String gender) {
		this.gender = gender;
	}
	
	public void setAge(int age) {
		this.age = age;
	}

	public void setCommunicationDTO(CommunicationDTO communicationDTO) {
		this.communicationDTO = communicationDTO;
	}
	
	// look up why char array is best for password.  
		// Since Strings are immutable if you store the password as a String it will be available in memory 
		// 		until the garbage collector clears it and since String are used in String pool for re-usability there is a 
		// 		pretty high chance that it will remain in memory for long duration. Since anyone who has accesss to memory dump 
		// 		can find the password in clear text.
		// Since Strings are immutable there are no way contents of Strings can be changed because any change will produce a new String.
		// 
		// With an array, the data can be wiped explicitly after its work is complete.  The array can be overwritten and the password
		// 		won't be present anywhere in the system, even before garbage collection.  
	
	
	
}
