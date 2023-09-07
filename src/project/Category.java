package project;

import java.util.UUID;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import Database.DatabaseUtil;
import Enumerations.CategoriesEnum;
import java.sql.SQLException;

public class Category {

	private String categoryID;
	public CategoriesEnum name;
	public CategoriesEnum parentCategory;
	public boolean isChild;
	public static List<Category> categories = new ArrayList<>();
	
	private void insertCategoryIntoDatabase() {
		try(Connection connection = DatabaseUtil.getConnection()){
			String sql = "INSERT INTO Category (categoryID, name, parentCategory, isChild) VALUES (?, ?, ?, ?)";
			
			try(PreparedStatement preparedStatement = connection.prepareStatement(sql)){
				preparedStatement.setString(1, this.categoryID);
				preparedStatement.setString(2, this.name.toString());
				preparedStatement.setString(3, this.parentCategory != null ? this.parentCategory.toString() : null);
				preparedStatement.setBoolean(4, this.isChild);
				
				
				preparedStatement.executeUpdate();
			}catch(SQLException e) {
				System.out.println(e.getStackTrace());
			}
			
		}catch(SQLException e) {
			System.out.println(e.getStackTrace());
		}
	}
	
	
	Category(CategoriesEnum name, CategoriesEnum parentCategory, boolean isChild){
		this.name = name;
		this.parentCategory = parentCategory;
		this.isChild = isChild;
		this.categoryID = UUID.randomUUID().toString();
        //this.insertCategoryIntoDatabase();
		categories.add(this);
	}
	
	
	public static void getCategorise() {
		for(Category category : categories) {
			System.out.println(category.toString());
		}
	}
	
	public String getCategory() {
		System.out.println(this.toString());
		return this.toString();
	}
	
	@Override
	public String toString() {
		return "Category id : "+ this.categoryID + "\nCategory name : " + this.name + 
				"\nParent Category : " + this.parentCategory + "\nIt is a child : " + this.isChild + "\n\n"; 
	}
	

	public static String getCategoryID(CategoriesEnum category) {
		try(Connection connection = DatabaseUtil.getConnection()){
			String sql = "Select * from Category";
			
			try(PreparedStatement preparedStatement = connection.prepareStatement(sql)){
				ResultSet resultSet = preparedStatement.executeQuery();
				
				while(resultSet.next()) {
					String rowsID = resultSet.getString("categoryID");
					String rowsCategoryName = resultSet.getString("name");
					String inputCategory = category.toString();
					
					if(rowsCategoryName.equals(inputCategory)) {
						return rowsID;
					}
				}
				
			}catch(SQLException e) {
				System.out.println(e);
			}
		}catch(SQLException e) {
			System.out.println(e);
		}
		
//		for(Category cat : categories) {
//			if(cat.name == category) {
//				return cat.categoryID;
//			}
//		}
		return "No such category";
	}
	
	public static Category getObjectFromID(String CategoryID) {
		for(Category c : categories) {
			if(c.categoryID == CategoryID) {
				return c;
			}
		}
		return null;
	}
	
	public static void getImmediateChildren(List<String> immediateChildren, String CategoryID) {
		for(Category c : categories) {
			if(getCategoryID(c.parentCategory) == CategoryID) {
				immediateChildren.add(c.categoryID);
			}
		}
	}
	
	
	//*************DFS*******************//
	public static void getLeafChildren(String CategoryID, List<String> listOfChildren) {
		//System.out.println("listOfChildren : "+listOfChildren);
		
		if(getObjectFromID(CategoryID).isChild) {
			//System.out.println("i am adding a new leaf category " + getObjectFromID(CategoryID).name);
			listOfChildren.add(CategoryID);
			return;
		}
		
		//categoryIDs
		List<String> immediateChildren = new ArrayList<>();
		getImmediateChildren(immediateChildren, CategoryID);
		
		for(String child : immediateChildren) {
			getLeafChildren(child, listOfChildren);
		}
	}
	
	
	
	
}
