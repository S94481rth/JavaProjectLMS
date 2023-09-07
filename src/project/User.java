package project;

import java.util.UUID;

import Database.DatabaseUtil;

import java.util.ArrayList;
import java.util.List;
import java.sql.*;
//import java.sql.Connection;

public class User {
	private String userID;
	public String name;
	public int age;
	public UserTypes usertype;
	static List<User> users = new ArrayList<>();
	
	public void addUserToDatabase() {
        try (Connection connection = DatabaseUtil.getConnection()) {
            String sql = "INSERT INTO User (name, id, age, userType) VALUES (?, ?, ?, ?)";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setString(1, this.name);
                preparedStatement.setString(2, this.userID);
                preparedStatement.setInt(3, this.age);
                preparedStatement.setString(4, this.usertype.toString());

                preparedStatement.executeUpdate();
                System.out.println("User added to the database.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
	
	
	
	public User(String userID, String name, int age, UserTypes usertype) {
		this.userID = userID;
		this.name = name;
		this.age = age;
		this.usertype = usertype;
	}



	//creates a new r4cord in the db
	User(String name,int age,UserTypes usertype){
		this.name = name;
		this.age = age;
		this.usertype = usertype;
		this.userID = UUID.randomUUID().toString();
		
		//fix this
		//this.addUserToDatabase();
		users.add(this);
		
	}
	
	public static List<User> getUsers() {
	    List<User> users = new ArrayList<>();
	    String sql = "SELECT * FROM User";

	    try (Connection connection = DatabaseUtil.getConnection();
	         PreparedStatement preparedStatement = connection.prepareStatement(sql);
	         ResultSet resultSet = preparedStatement.executeQuery()) {

	        while (resultSet.next()) {
	            String name = resultSet.getString("name");
	            int age = resultSet.getInt("age");
	            UserTypes userType = UserTypes.valueOf(resultSet.getString("userType"));
	            String userID = resultSet.getString("id");

	            User user = new User(userID, name, age, userType);
	            user.userID = userID;
	            users.add(user);
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }

	    return users;
	}

	
	public String getUser() {
		System.out.println(this.toString());
		return this.toString();
	}
	
	public static String getUserIDFromName(String userName) {
	    String sql = "SELECT id FROM User WHERE name = ?";
	    String userID = "No such user exists";

	    try (Connection connection = DatabaseUtil.getConnection();
	         PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

	        preparedStatement.setString(1, userName);
	        try (ResultSet resultSet = preparedStatement.executeQuery()) {
	            if (resultSet.next()) {
	                userID = resultSet.getString("id");
	            }
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }

	    return userID;
	}

	
	public static String getUserNameFromUserID(String userID) {
	    String sql = "SELECT name FROM User WHERE id = ?";
	    String userName = "Anonymous";

	    try (Connection connection = DatabaseUtil.getConnection();
	         PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

	        preparedStatement.setString(1, userID);
	        try (ResultSet resultSet = preparedStatement.executeQuery()) {
	            if (resultSet.next()) {
	                userName = resultSet.getString("name");
	            }
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }

	    return userName;
	}

	
	@Override
	public String toString() {
		return "User id : "+ this.userID + "\nname : " + this.name + "\nage : " + this.age + 
				"\nRole : " + this.usertype + "\n\n"; 
	}
	
}
