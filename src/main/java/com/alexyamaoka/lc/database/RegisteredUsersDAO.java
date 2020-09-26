package com.alexyamaoka.lc.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import javax.annotation.PostConstruct;

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
	
	public RegisteredUsersDAO() {
		
	}
	
	
	
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
		
		connection.close();
		
	}
	
	
	public void saveUser(UserRegistrationDTO userRegistrationDTO) throws SQLException, ClassNotFoundException {
		
	
		System.out.println("inside save user of Registered Users DAO");
		
		
		
		this.driver = environment.getProperty("db.driver");
		this.url = environment.getProperty("db.url");
		this.username = environment.getProperty("db.username");
		this.password = environment.getProperty("db.password");
		
		System.out.println("driver: " + environment.getProperty("db.driver"));
		System.out.println("url: " + environment.getProperty("db.url"));
		System.out.println("username: " + environment.getProperty("db.username"));
		System.out.println("password: " + environment.getProperty("db.password"));
	
		
		
		Class.forName(driver);
		connection = DriverManager.getConnection(url, username, password);
		
		
		
		
		
		System.out.println("username: " + userRegistrationDTO.getUsername());
		System.out.println("password: " + String.valueOf(userRegistrationDTO.getPassword()));
		System.out.println("country: " + userRegistrationDTO.getCountry());
		
		
		System.out.print("hobbies: ");
		for (String s: userRegistrationDTO.getHobbies()) {
			System.out.print(s + " ");
		}
		System.out.println();
		
		System.out.println("gender: " + userRegistrationDTO.getGender());
		System.out.println("age: " + userRegistrationDTO.getAge());
		
		
		
		String hobbyAsString = null;
		for (String s: userRegistrationDTO.getHobbies()) {
			hobbyAsString = hobbyAsString + s + ", ";
		}
		
		
		
		
		
		Statement statement = connection.createStatement();
		
		String query = "INSERT INTO lcAppDb.RegisteredUsers(username, password, country, hobbies, gender, age) VALUES(" 
				+ "\'" + userRegistrationDTO.getUsername() + "\', " 
				+ "\'" + String.valueOf(userRegistrationDTO.getPassword()) + "\', " 
				+ "\'" + userRegistrationDTO.getCountry() + "\', " 
				+ "\'" + hobbyAsString + "\', " 
				+ "\'" + userRegistrationDTO.getGender() + "\', " 
				+ "\'" + userRegistrationDTO.getAge() + "\')";
		
		statement.execute(query);
	}
	
	
	
	
}
