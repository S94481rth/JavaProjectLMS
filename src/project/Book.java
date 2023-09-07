package project;

import java.util.UUID;

import Enumerations.CategoriesEnum;

import java.util.List;
import java.util.ArrayList;
import java.sql.Connection;
import Database.DatabaseUtil;
import java.sql.SQLException;
import java.sql.PreparedStatement;

public class Book {
	public String name;
	public String author;
	String bookID;
	String categoryID;
	static List<Book> books = new ArrayList<>();
	
	private void insertBookIntoDatabase() {
		try(Connection connection = DatabaseUtil.getConnection()){
			String sql = "INSERT INTO Book(bookID, name, author, categoryID) VALUES (?, ?, ?, ?)";
			
			try(PreparedStatement preparedStatement = connection.prepareStatement(sql)){
				preparedStatement.setString(1, this.bookID);
				preparedStatement.setString(2, this.name);
				preparedStatement.setString(3, this.author);
				preparedStatement.setString(4, this.categoryID);
				
				preparedStatement.executeUpdate();
			}catch(SQLException e) {
				System.out.println("error in execution : " + e);
			}
		}catch(SQLException e) {
			System.out.println("error in connection");
		}
	}
	
	Book(String name, String author, CategoriesEnum category){
		this.name = name;
		this.author = author;
		this.bookID = UUID.randomUUID().toString();
		this.categoryID = Category.getCategoryID(category);
		this.insertBookIntoDatabase();
		books.add(this);
	}
	
	public static void getBooks() {
		for(Book book : books) {
			System.out.println(book.toString());
		}
	}
	
	public String getBook() {
		System.out.println(this.toString());
		return this.toString();
	}
	
	@Override
	public String toString() {
		return "Book id : "+ this.bookID + "\nBook name : " + this.name + 
				"\nAuthor : " + this.author + "\nCategory : " + this.categoryID + "\n\n"; 
	}
	
	public String getBookID() {
		return this.bookID;
	}
	
	public String getCategoryID() {
		return this.categoryID;
	}
	
	public static String getBookIDFromName(String name) {
		for(Book b : books) {
			if(b.name == name) {
				return b.bookID;
			}
		}
		return "No such book exists";
	}
	
	public static List<Book> getBooksInCategory(CategoriesEnum category){
		List<Book> booksUnderCategory = new ArrayList<>();
		String categoryID = Category.getCategoryID(category);
//		System.out.println("Category id inside the getBooks function : " + categoryID);
		//List of category ids
		List<String> listOfLeafCategories = new ArrayList<>();

		Category.getLeafChildren(categoryID, listOfLeafCategories);
//		System.out.println("listOfLeafCategories : " + listOfLeafCategories);

		for (Book b : books) {
			if(listOfLeafCategories.contains(b.categoryID)) {
				booksUnderCategory.add(b);
			}
		}
//		System.out.println("These are the books under category : " + booksUnderCategory);
		return booksUnderCategory;
	}
	
	public static Book getObjectFromID(String id) {
		for(Book b : books) {
			if(b.bookID == id) {
				return b;
			}
		}
		return null;
	}
}
