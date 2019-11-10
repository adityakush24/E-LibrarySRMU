package com.example.e_librarysrmu;

public class BookInformation {
    public String BookId;
    public String BookName;
    public String NumberOfCopies;

    BookInformation()
    {

    }

    public BookInformation(String bookId, String bookName, String numberOfCopies) {
        BookId = bookId;
        BookName = bookName;
        NumberOfCopies = numberOfCopies;
    }

    public String getBookId() {
        return BookId;
    }

    public String getBookName() {
        return BookName;
    }

    public String getNumberOfCopies() {
        return NumberOfCopies;
    }

    public void setBookId(String bookId) {
        BookId = bookId;
    }

    public void setBookName(String bookName) {
        BookName = bookName;
    }

    public void setNumberOfCopies(String numberOfCopies) {
        NumberOfCopies = numberOfCopies;
    }
}
