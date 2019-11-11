package com.example.e_librarysrmu;

public class BookInformation {
    public String bookDBid;
    public String bookId;
    public String bookName;
    public String numberOfCopies;

    BookInformation()
    {

    }

    public BookInformation(String DBid,String bookId, String bookName, String numberOfCopies) {
        this.bookDBid=DBid;
        this.bookId = bookId;
        this.bookName = bookName;
        this.numberOfCopies = numberOfCopies;
    }

    public String getBookId() {
        return bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public String getNumberOfCopies() {
        return numberOfCopies;
    }
}
