package project;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import Enumerations.BindingEnum;
import Enumerations.CategoriesEnum;

public class Main {
	public static void main(String args[]) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		
//		User user1 = new User("Aravind", 21 , UserTypes.LIBRARIAN);
//		User user2 = new User("Aneesh", 25 , UserTypes.CUSTOMER);
//		User user3 = new User("Akash", 19 , UserTypes.CUSTOMER);
//	
//		User.getUsers();
//		user1.getUser();
		


//		System.out.println(User.getUsers());
//		System.out.println(User.getUserIDFromName("Aravind"));
//		System.out.println(User.getUserNameFromUserID("6b7e2a0f-62f9-4359-bdc3-5f189f20631d"));
//		Category.getCategorise();
//		category6.getCategory();
//		System.out.println(Category.getCategoryID(CategoriesEnum.CRIME));
		
//		 Book Creation Working
//		Book book1 = new Book("Harry potter", "JK Rowling", CategoriesEnum.MAGIC);
//		Book book2 = new Book("And Then There Were None", "Agatha Chirstie", CategoriesEnum.CRIME);
//		Book.getBooks();
//		System.out.println(book2.getCategoryID());
		 
		
		
//		 Making sure catedory id assigned during category creation and book's category id are the same
		 
//		Category category1 = new Category(CategoriesEnum.CRIME, CategoriesEnum.NONFICTION, true);
//		Category category2 = new Category(CategoriesEnum.ROMANCE, CategoriesEnum.NONFICTION, true);
//		Category category3 = new Category(CategoriesEnum.MAGIC, CategoriesEnum.FICTION, true);
//		Category category4 = new Category(CategoriesEnum.VAMPIRE, CategoriesEnum.FICTION, true);
//		Category category5 = new Category(CategoriesEnum.FICTION, CategoriesEnum.GENERAL, false);
//		Category category6 = new Category(CategoriesEnum.NONFICTION, CategoriesEnum.GENERAL, false);
//		Category category7 = new Category(CategoriesEnum.GENERAL, CategoriesEnum.NULL, false);
		
		
//		Book book1 = new Book("And Then There Were None", "Agatha Chirstie", CategoriesEnum.CRIME);
//		Book book2 = new Book("Murder on the Orient Express", "Agatha Chirstie", CategoriesEnum.CRIME);
//		Book book3 = new Book("Harry potter", "JK Rowling", CategoriesEnum.MAGIC);

	
//		Making sure that the bbc and books have making ids (ukwim)
		 

		BookBindCopies bbc1 = new BookBindCopies("Harry potter", BindingEnum.HARDBOUND,2);
		BookBindCopies bbc2 = new BookBindCopies("Harry potter", BindingEnum.SOFTBOUND,2);
		BookBindCopies bbc3 = new BookBindCopies("And Then There Were None", BindingEnum.SPIRALBOUND,1);
		BookBindCopies bbc4 = new BookBindCopies("Murder on the Orient Express", BindingEnum.HARDBOUND,4);

		

		
//
//		
//		//BookBindCopies.getBookBindCopies();
//      basic app works
//		try {
//			Date issueDate = dateFormat.parse("24/08/2020");
//			Issue issue1 = new Issue("Aravind", "Harry potter", BindingEnum.HARDBOUND, issueDate);
//			System.out.println(issue1);
//			//System.out.println("\n");
//			System.out.println("Here is your book : ");
//			System.out.println(issue1.giveBook());
//		} catch (Exception e) {
//			System.out.println(e);
//		}
		
//		System.out.println("\n\n\n\n\n");
		//implement search
		//DFS SEARCH success
//		List<Book> booksForUsersRequest = Book.getBooksInCategory(CategoriesEnum.GENERAL);
//
//
//		for(Book b : booksForUsersRequest) {
//			System.out.println(b);
//		}
		
		
	}
}
