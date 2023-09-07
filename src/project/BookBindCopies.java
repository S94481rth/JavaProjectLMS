package project;
import java.util.UUID;

import Enumerations.BindingEnum;

import java.util.List;
import java.util.ArrayList;
import java.sql.*;
import Database.DatabaseUtil;


public class BookBindCopies {
	private String copyID;
	public String bookID;
	public BindingEnum binding;
	public int copies;
	public static List<BookBindCopies> bookBindCopies = new ArrayList<>();
	
	
	public String getCopyID() {
		return this.copyID;
	}
	
	private void insertCopiesInfoDatabase(){
		try(Connection connection = DatabaseUtil.getConnection()){
			String sql = "INSERT INTO BookBindCopies(copyID, copies, binding, bookID) VALUES (?, ?, ?, ?)";
			
			try(PreparedStatement preparedStatement = connection.prepareStatement(sql)){
				preparedStatement.setString(1, this.copyID);
				preparedStatement.setInt(2, this.copies);
				preparedStatement.setString(3, this.binding.toString());
				preparedStatement.setString(4, this.bookID);
				
				preparedStatement.executeUpdate();
			}
		}catch(SQLException e) {
			System.out.println(e);
		}
	}
	
	BookBindCopies(String bookName, BindingEnum binding, int copies){
		this.copyID = UUID.randomUUID().toString();
		this.binding = binding;
		this.copies = copies;
		this.bookID = Book.getBookIDFromName(bookName);
		
		this.insertCopiesInfoDatabase();
		bookBindCopies.add(this);	
	}
	
	public static void getBookBindCopies() {
		for (BookBindCopies bbc : bookBindCopies) {
			System.out.println(bbc.toString());
		}
	}
	
	public static String getCopiesIDFromBookIDAndBinding(String bookID, BindingEnum binding) {
		try(Connection connection = DatabaseUtil.getConnection()){
			String sql = "Select * from BookBindCopies";
			
			try(PreparedStatement preparedStatement = connection.prepareStatement(sql)){
				ResultSet resultSet = preparedStatement.executeQuery();
				
				while(resultSet.next()) {
					String rowsCopyID = resultSet.getString("copyID");
					String rowsBookID = resultSet.getString("bookID");
					String rowsBinding = resultSet.getString("binding");
					//String inputCategory = name;
					
					if(rowsBookID.equals(bookID) && rowsBinding.equals(binding.toString())) {
						return rowsCopyID;
					}
				}
				
			}catch(SQLException e) {
				System.out.println(e);
			}
		}catch(SQLException e) {
			System.out.println(e);
		}
		
		//System.out.println("Inside the getCopyID function : "+bookID + " binding :  "+ binding+ " ");
		
		
		
//		for (BookBindCopies bbc : bookBindCopies) {
//			if(bbc.bookID == bookID && bbc.binding == binding) {
//				return bbc.copyID;
//			}
//		}
		return "A Book with this specific Binding never existed";
	}
	

	
	public static boolean isCopyAvailavble(String copyID) {
		try(Connection connection = DatabaseUtil.getConnection()){
			String sql = "Select * from BookBindCopies";
			
			try(PreparedStatement preparedStatement = connection.prepareStatement(sql)){
				ResultSet resultSet = preparedStatement.executeQuery();
				
				while(resultSet.next()) {
					String rowsCopyID = resultSet.getString("copyID");
					Integer rowsCopies = resultSet.getInt("copies");
//					String rowsBinding = resultSet.getString("binding");
					//String inputCategory = name;
					
					if(rowsCopyID.equals(copyID) && rowsCopies > 0) {
						return true;
					}
				}
				
			}catch(SQLException e) {
				System.out.println(e);
			}
		}catch(SQLException e) {
			System.out.println(e);
		}
		
		
		
//		for (BookBindCopies bbc : bookBindCopies) {
//			if(bbc.copyID == copyID && bbc.copies > 0) {
//				return true;
//			}
//		}
		return false;
	}
	
	public static BookBindCopies getObjectByID(String id) {
		for (BookBindCopies bbc : bookBindCopies) {
			if(bbc.copyID == id) {
				return bbc;
			}
		}
		return null;
	}
	
	
	public static void reduceCopyCount(String copyID) {
		try(Connection connection = DatabaseUtil.getConnection()){
			String sql = "UPDATE BookBindCopies SET Copies = Copies - 1 WHERE copyID = ? ";
			
			try(PreparedStatement preparedStatement = connection.prepareStatement(sql)){
				preparedStatement.setString(1, copyID);

				
				preparedStatement.executeUpdate();
			}catch(SQLException e) {
				System.out.println("error in execution : " + e);
			}
		}catch(SQLException e) {
			System.out.println("error in connection");
		}
	
	}
	
	@Override
	public String toString() {
		return "BookBindCopies [copyID=" + this.copyID + ", bookID=" + this.bookID + ", binding=" + this.binding + ", "
				+ "copies=" + this.copies + "]";
	}

}
