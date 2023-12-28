package demoproject.springbootdemo.models.utilModels;

import demoproject.springbootdemo.models.BorrowInfo;

public class BookBorrowModel extends BorrowInfo {
    private String cardNumber;
    private String bookId;

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

}
