package demoproject.springbootdemo.models.utilModels;

import java.sql.Date;

public class BookSearchModel {
    private String bookTitle;
    private String category;
    private String author;
    private String publisher;
    private Date publishedFrom;
    private Date publishedTo;

    public String getBookTitle() {
        return bookTitle;
    }

    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public Date getPublishedFrom() {
        return publishedFrom;
    }

    public void setPublishedFrom(Date publishedFrom) {
        this.publishedFrom = publishedFrom;
    }

    public Date getPublishedTo() {
        return publishedTo;
    }

    public void setPublishedTo(Date publishedTo) {
        this.publishedTo = publishedTo;
    }

}