package project;

import java.util.Date;
import java.util.Calendar;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import Enumerations.BindingEnum;
import Enumerations.StatusEnum;

public class Issue {
	private String issueID;
	public String userID;
	public String bookCopyID;
	public Date issueDate;
	public Date returnDate;
	public int fine;
	public StatusEnum status;
	public static List<Issue> issues = new ArrayList<>();
	
	
    public Issue(String UserName, String bookName, BindingEnum binding, Date issueDate) throws OutOfStockExcpetion {
        this.issueID = UUID.randomUUID().toString();
        this.userID = User.getUserIDFromName(UserName);
        this.bookCopyID = BookBindCopies.getCopiesIDFromBookIDAndBinding(Book.getBookIDFromName(bookName), binding);
        
//        System.out.println(this.bookCopyID);
        if(!BookBindCopies.isCopyAvailavble(this.bookCopyID)) {
        	throw new OutOfStockExcpetion("Extremely Sorry " + User.getUserNameFromUserID(this.userID) + ", The book "+ bookName +" is out of stock! ");
        }
        
        this.issueDate = issueDate;

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(issueDate);
        calendar.add(Calendar.DAY_OF_MONTH, 14);
        this.returnDate = calendar.getTime();

        this.fine = 0;
        this.status = StatusEnum.YET_TO_RETURN; 
        
        //decrement the available book Copy
        BookBindCopies.getObjectByID(this.bookCopyID).copies--;
        
        
        issues.add(this);
    }

    
    
	public String getIssueID() {
		return issueID;
	}



	public void setIssueID(String issueID) {
		this.issueID = issueID;
	}



	public String getUserID() {
		return userID;
	}



	public void setUserID(String userID) {
		this.userID = userID;
	}



	public String getBookCopyID() {
		return bookCopyID;
	}



	public void setBookCopyID(String bookCopyID) {
		this.bookCopyID = bookCopyID;
	}



	public Date getIssueDate() {
		return issueDate;
	}



	public void setIssueDate(Date issueDate) {
		this.issueDate = issueDate;
	}



	public Date getReturnDate() {
		return returnDate;
	}



	public void setReturnDate(Date returnDate) {
		this.returnDate = returnDate;
	}



	public int getFine() {
		return fine;
	}



	public void setFine(int fine) {
		this.fine = fine;
	}



	public StatusEnum getStatus() {
		return status;
	}



	public void setStatus(StatusEnum status) {
		this.status = status;
	}


	public static void updateFines() {
        Date currentDate = new Date();

        for (Issue issue : issues) {
            if (currentDate.after(issue.returnDate)) {
                long daysLate = (currentDate.getTime() - issue.returnDate.getTime()) / (1000 * 60 * 60 * 24); // Calculate days late
                int fine = (int) (daysLate * 10); // Fine is 10 rupees per extended day
                issue.fine = fine;
            }
        }
    }
	
	
	
	@Override
	public String toString() {
		return "Issue Info\nissueID=" + issueID + "\nuserID=" + userID + "\nbookCopyID=" + bookCopyID + "\nissueDate="
				+ issueDate + "\nreturnDate=" + returnDate + "\nfine=" + fine + "\nstatus=" + status + "\n\n";
	}
    
    
    public Book giveBook() {
    	return Book.getObjectFromID(BookBindCopies.getObjectByID(this.bookCopyID).bookID);
    }
    
}
