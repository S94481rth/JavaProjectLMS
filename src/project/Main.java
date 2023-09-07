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
		 

//		BookBindCopies bbc1 = new BookBindCopies("Harry potter", BindingEnum.HARDBOUND,2);
//		BookBindCopies bbc2 = new BookBindCopies("Harry potter", BindingEnum.SOFTBOUND,2);
//		BookBindCopies bbc3 = new BookBindCopies("And Then There Were None", BindingEnum.SPIRALBOUND,1);
//		BookBindCopies bbc4 = new BookBindCopies("Murder on the Orient Express", BindingEnum.HARDBOUND,4);

//		System.out.println(bbc1);

		
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
		
		
		
//		BookBindCopies bbc5 = new BookBindCopies("Harry potter", BindingEnum.HARDBOUND, 2);
//		BookBindCopies bbc6 = new BookBindCopies("Harry potter", BindingEnum.SOFTBOUND, 2);
//		BookBindCopies bbc7 = new BookBindCopies("Harry potter", BindingEnum.PAPERBACK, 2);
//		BookBindCopies bbc8 = new BookBindCopies("Harry potter", BindingEnum.EBOOK, 2);
//		For "And Then There Were None":
//		5. BookBindCopies bbc9 = new BookBindCopies("And Then There Were None", BindingEnum.HARDBOUND, 4);

//		BookBindCopies bbc10 = new BookBindCopies("And Then There Were None", BindingEnum.SOFTBOUND, 4);
//		BookBindCopies bbc11 = new BookBindCopies("And Then There Were None", BindingEnum.PAPERBACK, 4);
//		BookBindCopies bbc12 = new BookBindCopies("And Then There Were None", BindingEnum.EBOOK, 4);
////		For "Murder on the Orient Express":
////		9. BookBindCopies bbc13 = new BookBindCopies("Murder on the Orient Express", BindingEnum.HARDBOUND, 4);
//
//		BookBindCopies bbc14 = new BookBindCopies("Murder on the Orient Express", BindingEnum.SOFTBOUND, 4);
//		BookBindCopies bbc15 = new BookBindCopies("Murder on the Orient Express", BindingEnum.PAPERBACK, 4);
//		BookBindCopies bbc16 = new BookBindCopies("Murder on the Orient Express", BindingEnum.EBOOK, 4);
////		For "The Adventures of Sherlock Holmes":
////		13. BookBindCopies bbc17 = new BookBindCopies("The Adventures of Sherlock Holmes", BindingEnum.HARDBOUND, 3);
//
//		BookBindCopies bbc18 = new BookBindCopies("The Adventures of Sherlock Holmes", BindingEnum.SOFTBOUND, 3);
//		BookBindCopies bbc19 = new BookBindCopies("The Adventures of Sherlock Holmes", BindingEnum.PAPERBACK, 3);
//		BookBindCopies bbc20 = new BookBindCopies("The Adventures of Sherlock Holmes", BindingEnum.EBOOK, 3);
////		For "Gone Girl":
////		17. BookBindCopies bbc21 = new BookBindCopies("Gone Girl", BindingEnum.HARDBOUND, 5);
//
//		BookBindCopies bbc22 = new BookBindCopies("Gone Girl", BindingEnum.SOFTBOUND, 5);
//		BookBindCopies bbc23 = new BookBindCopies("Gone Girl", BindingEnum.PAPERBACK, 5);
//		BookBindCopies bbc24 = new BookBindCopies("Gone Girl", BindingEnum.EBOOK, 5);
////		For "The Girl with the Dragon Tattoo":
////		21. BookBindCopies bbc25 = new BookBindCopies("The Girl with the Dragon Tattoo", BindingEnum.HARDBOUND, 4);
//
//		BookBindCopies bbc26 = new BookBindCopies("The Girl with the Dragon Tattoo", BindingEnum.SOFTBOUND, 4);
//		BookBindCopies bbc27 = new BookBindCopies("The Girl with the Dragon Tattoo", BindingEnum.PAPERBACK, 4);
//		BookBindCopies bbc28 = new BookBindCopies("The Girl with the Dragon Tattoo", BindingEnum.EBOOK, 4);
		
		
		try {
			Date issueDate = dateFormat.parse("24/08/2020");
			Issue issue1 = new Issue("Aravind", "The Adventures of Sherlock Holmes", BindingEnum.SOFTBOUND, issueDate);
			System.out.println(issue1);
			//System.out.println("\n");
			//System.out.println("Here is your book : ");
			//System.out.println(issue1.giveBook());
		} catch (Exception e) {
			System.out.println(e);
		}
		
		
	}
}
