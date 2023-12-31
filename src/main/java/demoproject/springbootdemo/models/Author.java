package demoproject.springbootdemo.models;

import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "TacGia")
public class Author {
    @Id
    @Column(name = "Id")
    private String id;

    @Column(name = "Ten", nullable = false)
    private String name;

    @OneToMany(mappedBy = "author")
    private Set<Book> books;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}