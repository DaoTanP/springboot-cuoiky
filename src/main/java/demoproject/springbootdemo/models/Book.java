package demoproject.springbootdemo.models;

import java.sql.Date;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "Sach")
public class Book {
    @Id
    @Column(name = "Id")
    private String id;

    @Column(name = "TieuDe", nullable = false)
    private String title;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "TheLoaiId", referencedColumnName = "Id")
    private Category category;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "TacGiaId", referencedColumnName = "Id")
    private Author author;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "NhaXuatBanId", referencedColumnName = "Id")
    private Publisher publisher;

    @Column(name = "NgayXuatBan")
    private Date publishDate;

    @Column(name = "SoTrang")
    private int numberOfPages;

    @Column(name = "GioiThieu")
    private String overview;

    @Column(name = "AnhBia")
    private String image;

    @Column(name = "SoLuong")
    private int inStock;

    @OneToMany(mappedBy = "book")
    private Set<BorrowInfo> borrowInfos;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCategory() {
        return category.getName();
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getAuthor() {
        return author.getName();
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public String getPublisher() {
        return publisher.getName();
    }

    public void setPublisher(Publisher publisher) {
        this.publisher = publisher;
    }

    public Date getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(Date publishDate) {
        this.publishDate = publishDate;
    }

    public int getNumberOfPages() {
        return numberOfPages;
    }

    public void setNumberOfPages(int numberOfPages) {
        this.numberOfPages = numberOfPages;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getStock() {
        return inStock;
    }

    public void setStock(int inStock) {
        this.inStock = inStock;
    }
}