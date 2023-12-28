package demoproject.springbootdemo.models;

import java.sql.Date;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "ThongTinMuonSach")
public class BorrowInfo {
    @Id
    @Column(name = "Id")
    private String id;

    @Column(name = "NgayMuon", nullable = false)
    private Date borrowDate;

    @Column(name = "NgayTra", nullable = false)
    private Date returnDate;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "SoThe", referencedColumnName = "SoThe")
    private LibraryCard card;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "SachId", referencedColumnName = "Id")
    private Book book;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "TrangThaiMuonId", referencedColumnName = "Id")
    private BorrowStatus status;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getBorrowDate() {
        return borrowDate;
    }

    public void setBorrowDate(Date borrowDate) {
        this.borrowDate = borrowDate;
    }

    public Date getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }

    public LibraryCard getCard() {
        return card;
    }

    public void setCard(LibraryCard card) {
        this.card = card;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public BorrowStatus getStatus() {
        return status;
    }

    public void setStatus(BorrowStatus status) {
        this.status = status;
    }

}