package demoproject.springbootdemo.models;

import java.sql.Date;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "ThongTinMuonSach")
public class BorrowInfo {
    @Id
    @Column(name = "Id")
    private String id;

    @Column(name = "SoThe", nullable = false)
    private String cardNumber;

    @Column(name = "SachId", nullable = false)
    private String bookId;

    @Column(name = "NgayMuon", nullable = false)
    private Date borrowDate;

    @Column(name = "NgayTra", nullable = false)
    private Date returnDate;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

}