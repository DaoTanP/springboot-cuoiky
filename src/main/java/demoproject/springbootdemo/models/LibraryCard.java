package demoproject.springbootdemo.models;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "TheThuVien")
public class LibraryCard {
    @Id
    @Column(name = "SoThe")
    private String id;

    @Column(name = "MatKhauThe", nullable = false)
    private String password;

    @Column(name = "NgayCap", nullable = false)
    private Date issueDate;

    @Column(name = "NgayHetHan", nullable = false)
    private Date expirationDate;

    @OneToOne(mappedBy = "libraryCard")
    private User user;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(Date issueDate) {
        this.issueDate = issueDate;
    }

    public Date getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate;
    }

}
