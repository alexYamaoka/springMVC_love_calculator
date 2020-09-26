package com.alexyamaoka.lc.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

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
		
		statement.executeQuery(query);
		
		
		String query2 = "INSERT INTO lcAppDb.Communication(username, email, phone) VALUES("
						+ "\'" + userRegistrationDTO.getUsername() + "\',"
						+ "\'" + userRegistrationDTO.getCommunicationDTO().getEmail() + "\',"
						+ "\'" + userRegistrationDTO.getCommunicationDTO().getPhone().toString() + "\')";
		
		statement.executeQuery(query2);
						
						
		
		closeDBConnection();
	}
	
	
	public void viewAllRegisteredUsers() throws SQLException, ClassNotFoundException {
		
		connectToDB();
		
		Statement statement = connection.createStatement();
		
		String query = "SELECT * FROM lcAppDb.RegisteredUsers";
				
		ResultSet resultSet = statement.executeQuery(query);
		
		
		while (resultSet.next()) {
			String username = resultSet.getString(1);
			String password = resultSet.getString(2);
			String country = resultSet.getString(3);
			String hobbies = resultSet.getString(4);
			String gender = resultSet.getString(5);
			int age = resultSet.getInt(6);
			
			System.out.println("username: " + username);
			System.out.println("password: " + password);
			System.out.println("country: " + country);
			System.out.println("hobbies: " + hobbies);
			System.out.println("gender: " + gender);
			System.out.println("age: " + age);
		}
		
		
		
		
		
		
		closeDBConnection();
	
	}
	
	
	public void deleteUserByName(String name) throws ClassNotFoundException, SQLException {
		connectToDB();
		
		Statement statement = connection.createStatement();
		
		String query = "DELETE FROM lcAppDb.RegisteredUsers WHERE username = " + name;
		
		statement.executeQuery(query);
		
		String query2 = "DELETE FROM lcAppDb.Communication WHERE username = " + name;
		
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
	
}
