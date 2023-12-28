package demoproject.springbootdemo.models;

import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "NhaXuatBan")
public class Publisher {
    @Id
    @Column(name = "Id")
    private String id;

    @Column(name = "TenNhaXuatBan", nullable = false)
    private String publisherName;

    @OneToMany(mappedBy = "publisher")
    private Set<Book> books;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPublisherName() {
        return publisherName;
    }

    public void setPublisherName(String publisherName) {
        this.publisherName = publisherName;
    }
}