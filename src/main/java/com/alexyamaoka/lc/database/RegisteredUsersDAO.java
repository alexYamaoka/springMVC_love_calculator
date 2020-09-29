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
		saveRegisterdUsers(userRegistrationDTO);
		saveCommunication(userRegistrationDTO);
	}
	
	public void saveRegisterdUsers(UserRegistrationDTO userRegistrationDTO) throws ClassNotFoundException, SQLException {
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
		
		statement.executeUpdate(query);
		
		closeDBConnection();
	}
	
	public void saveCommunication(UserRegistrationDTO userRegistrationDTO) throws ClassNotFoundException, SQLException {
		connectToDB();
		
		Statement statement = connection.createStatement();
		
		String hobbyAsString = getCSVFormatHobby(userRegistrationDTO.getHobbies());
		
		String query = "INSERT INTO lcAppDb.Communication(username, email, phone) VALUES("
						+ "\'" + userRegistrationDTO.getUsername() + "\',"
						+ "\'" + userRegistrationDTO.getCommunicationDTO().getEmail() + "\',"
						+ "\'" + userRegistrationDTO.getCommunicationDTO().getPhone().toString() + "\')";
		
		statement.executeUpdate(query);
			
		closeDBConnection();
	}
	
	
	public List<UserRegistrationDTO> viewAllRegisteredUsers() throws SQLException, ClassNotFoundException {
		
		List<UserRegistrationDTO> usersList = new ArrayList<UserRegistrationDTO>();
		
		connectToDB();
		
		Statement statement = connection.createStatement();
		
		String query = "SELECT * FROM lcAppDb.RegisteredUsers AS RU, lcAppDb.Communication AS C WHERE RU.username = C.username";
		
		ResultSet resultSet = statement.executeQuery(query);
		
		while (resultSet.next()) {
			String username = resultSet.getString(1);
			String password = resultSet.getString(2);
			String country = resultSet.getString(3);
			String hobbies = resultSet.getString(4);
			String gender = resultSet.getString(5);
			int age = resultSet.getInt(6);

			String email = resultSet.getString(8);
			String number = resultSet.getString(9);
		
			
			String[] hobbyList = parseHobbiesToArray(hobbies);
			
			Phone phone = getPhoneFromString(number);
			CommunicationDTO communicationDTO = new CommunicationDTO();
			communicationDTO.setEmail(email);
			communicationDTO.setPhone(phone);
			
			UserRegistrationDTO userRegistrationDTO = new UserRegistrationDTO();
			userRegistrationDTO.setUsername(username);
			userRegistrationDTO.setPassword(password.toCharArray());
			userRegistrationDTO.setCountry(country);
			userRegistrationDTO.setHobbies(hobbyList);
			userRegistrationDTO.setGender(gender);
			userRegistrationDTO.setAge(age);
			userRegistrationDTO.setCommunicationDTO(communicationDTO);
			
			usersList.add(userRegistrationDTO);
		}
		
	
		closeDBConnection();
		
		return usersList;
	}
	
	
	public String deleteUserByName(String name) throws ClassNotFoundException, SQLException {
		int result1 = deleteFromRegisteredUsers(name);
		int result2 = deleteFromCommunications(name);
		
		if (result1 == 0 && result2 == 0) {
			return "User: " + name + " Not Found In Database";
		}
		
		return "Successfully Delted User: " + name;
	}
	
	public int deleteFromRegisteredUsers(String name) throws ClassNotFoundException, SQLException {
		connectToDB();
		Statement statement = connection.createStatement();
		String query = "DELETE FROM lcAppDb.RegisteredUsers WHERE username = " + "\'" + name + "\'";
		int result = statement.executeUpdate(query);
		
		if (result == 0) {
			System.out.println("User Not Found");
		}
		
		closeDBConnection();
		
		return result;
	}
	
	public int deleteFromCommunications(String name) throws SQLException, ClassNotFoundException {
		connectToDB();
		Statement statement = connection.createStatement();
		String query = "DELETE FROM lcAppDb.Communication WHERE username = " + "\'" + name + "\'";
		int result = statement.executeUpdate(query);
		
		if (result == 0) {
			System.out.println("User Not Found");
		}
		closeDBConnection();
		
		return result;
	}
	
	private void connectToDB() throws ClassNotFoundException, SQLException {
		this.driver = environment.getProperty("db.driver");
		this.url = environment.getProperty("db.url");
		this.username = environment.getProperty("db.username");
		this.password = environment.getProperty("db.password");
		
		Class.forName(driver);
		connection = DriverManager.getConnection(url, username, password);
	}
	
	
	private void closeDBConnection() throws SQLException {
		connection.close();
	}
	
	
	private String getCSVFormatHobby(String[] list) {
		String hobbyAsString = "";
		for (String s: list) {
			hobbyAsString = hobbyAsString + s + ", ";
		}
		int length = hobbyAsString.length();
		hobbyAsString = hobbyAsString.substring(0, length - 2);
		
		return hobbyAsString;
	}
	
	private String[] parseHobbiesToArray(String hobbies) {
		String[] list = hobbies.split(",");
		
		return list;
	}
	
	private Phone getPhoneFromString(String number) {
		Phone phone = new Phone();
		
		System.out.println("number" + number);
		
		String[] numberList = number.split("-");
		phone.setCountryCode(numberList[0]);
		phone.setUserNumber(numberList[1]);
		
		return phone;
	}
	
	
	
}
