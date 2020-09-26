package com.alexyamaoka.lc.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import com.alexyamaoka.lc.api.CommunicationDTO;
import com.alexyamaoka.lc.api.Phone;
import com.alexyamaoka.lc.api.UserRegistrationDTO;

@Service
@PropertySource("classpath:registeredUsersDb.properties")
public class RegisteredUsersDAO {

	private String driver;
	private String url;
	private String username;
	private String password;
	
	private Connection connection;
	
	@Autowired
	private Environment environment;
	
	
	public void setDriver(String driver) {
		this.driver = driver;
	}
	
	public void setUrl(String url) {
		this.url = url;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	@PostConstruct
	public void init() throws ClassNotFoundException, SQLException {
		System.out.println("inside init of RegisterUsersDAO");
	}
	
	@PreDestroy
	public void destroy() throws SQLException {
		
		System.out.println("inside destroy of RegisterUsersDAO");
		
	}
	
	
	public void saveUser(UserRegistrationDTO userRegistrationDTO) throws SQLException, ClassNotFoundException {
		connectToDB();
		
		Statement statement = connection.createStatement();
		
		String hobbyAsString = getCSVFormatHobby(userRegistrationDTO.getHobbies());
		
		String query = "INSERT INTO lcAppDb.RegisteredUsers(username, password, country, hobbies, gender, age) VALUES(" 
				+ "\'" + userRegistrationDTO.getUsername() + "\', " 
				+ "\'" + String.valueOf(userRegistrationDTO.getPassword()) + "\', " 
				+ "\'" + userRegistrationDTO.getCountry() + "\', " 
				+ "\'" + hobbyAsString + "\', " 
				+ "\'" + userRegistrationDTO.getGender() + "\', " 
				+ "\'" + userRegistrationDTO.getAge() + "\')";
		
		String query2 = "INSERT INTO lcAppDb.Communication(username, email, phone) VALUES("
						+ "\'" + userRegistrationDTO.getUsername() + "\',"
						+ "\'" + userRegistrationDTO.getCommunicationDTO().getEmail() + "\',"
						+ "\'" + userRegistrationDTO.getCommunicationDTO().getPhone().toString() + "\')";
		
		
		statement.executeQuery(query);
		statement.executeQuery(query2);
						
		closeDBConnection();
	}
	
	
	public List<UserRegistrationDTO> viewAllRegisteredUsers() throws SQLException, ClassNotFoundException {
		
		List<UserRegistrationDTO> usersList = new ArrayList<UserRegistrationDTO>();
		
		connectToDB();
		
		Statement statement = connection.createStatement();
		
		String query = "SELECT * FROM lcAppDb.RegisteredUsers";
		String query2 = "SELECT * FROM lcAppDb.Communication";
				
		ResultSet resultSet = statement.executeQuery(query);
		ResultSet resultSet2 = statement.executeQuery(query2);
		
		
		while (resultSet.next() && resultSet2.next()) {
			String username = resultSet.getString(1);
			String password = resultSet.getString(2);
			String country = resultSet.getString(3);
			String hobbies = resultSet.getString(4);
			String gender = resultSet.getString(5);
			int age = resultSet.getInt(6);

			String email = resultSet2.getString(2);
			String number = resultSet2.getString(3);
			
			
			Phone phone = getPhoneFromString(number);
			CommunicationDTO communicationDTO = new CommunicationDTO();
			communicationDTO.setEmail(email);
			communicationDTO.setPhone(phone);
			
			UserRegistrationDTO userRegistrationDTO = new UserRegistrationDTO();
			userRegistrationDTO.setUsername(username);
			userRegistrationDTO.setPassword(password);
			userRegistrationDTO.setCountry(country);
			userRegistrationDTO.setHobbies(hobbies);
			userRegistrationDTO.setGender(gender);
			userRegistrationDTO.setCommunicationDTO(communicationDTO);
			
			usersList.add(userRegistrationDTO));
			
		}
		
	
		closeDBConnection();
		
		return usersList;
	}
	
	
	public void deleteUserByName(String name) throws ClassNotFoundException, SQLException {
		connectToDB();
		
		Statement statement = connection.createStatement();
		
		String query = "DELETE FROM lcAppDb.RegisteredUsers WHERE username = " + name;
		String query2 = "DELETE FROM lcAppDb.Communication WHERE username = " + name;
		
		statement.executeQuery(query);
		statement.executeQuery(query2);
		
		closeDBConnection();
	}
	
	
	public void connectToDB() throws ClassNotFoundException, SQLException {
		this.driver = environment.getProperty("db.driver");
		this.url = environment.getProperty("db.url");
		this.username = environment.getProperty("db.username");
		this.password = environment.getProperty("db.password");
		
		Class.forName(driver);
		connection = DriverManager.getConnection(url, username, password);
	}
	
	
	public void closeDBConnection() throws SQLException {
		connection.close();
	}
	
	
	public String getCSVFormatHobby(String[] list) {
		String hobbyAsString = "";
		for (String s: list) {
			hobbyAsString = hobbyAsString + s + ", ";
		}
		int length = hobbyAsString.length();
		hobbyAsString = hobbyAsString.substring(0, length - 2);
		
		return hobbyAsString;
	}
	
	
	public Phone getPhoneFromString(String number) {
		Phone phone = new Phone();
		
		String[] numberList = number.split("-");
		phone.setCountryCode(numberList[0]);
		phone.setUserNumber(numberList[1]);
		
		return phone;
	}
	
	
	
}
