package project;
import java.util.UUID;

import Enumerations.BindingEnum;

import java.util.List;
import java.util.ArrayList;



public class BookBindCopies {
	private String copyID;
	public String bookID;
	public BindingEnum binding;
	public int copies;
	public static List<BookBindCopies> bookBindCopies = new ArrayList<>();
	
	
	public String getCopyID() {
		return this.copyID;
	}
	
	BookBindCopies(String bookName, BindingEnum binding, int copies){
		this.copyID = UUID.randomUUID().toString();
		this.binding = binding;
		this.copies = copies;
		this.bookID = Book.getBookIDFromName(bookName);
		bookBindCopies.add(this);	
	}
	
	public static void getBookBindCopies() {
		for (BookBindCopies bbc : bookBindCopies) {
			System.out.println(bbc.toString());
		}
	}
	
	public static String getCopiesIDFromBookIDAndBinding(String bookID, BindingEnum binding) {
		
		//System.out.println("Inside the getCopyID function : "+bookID + " binding :  "+ binding+ " ");
		for (BookBindCopies bbc : bookBindCopies) {
			if(bbc.bookID == bookID && bbc.binding == binding) {
				return bbc.copyID;
			}
		}
		return "A Book with this specific Binding never existed";
	}
	

	
	public static boolean isCopyAvailavble(String copyID) {
		for (BookBindCopies bbc : bookBindCopies) {
			if(bbc.copyID == copyID && bbc.copies > 0) {
				return true;
			}
		}
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
	
	
	@Override
	public String toString() {
		return "BookBindCopies [copyID=" + copyID + ", bookID=" + bookID + ", binding=" + binding + ", "
				+ "copies=" + copies + "]";
	}

}
