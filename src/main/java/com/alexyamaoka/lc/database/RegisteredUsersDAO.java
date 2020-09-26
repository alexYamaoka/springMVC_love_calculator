package com.alexyamaoka.lc.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
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
		
	}
	
	
	public void destroy() throws SQLException {
		
		
		
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
		
		statement.execute(query);
		
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
