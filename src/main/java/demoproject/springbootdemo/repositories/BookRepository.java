package demoproject.springbootdemo.repositories;

import org.springframework.data.repository.CrudRepository;
import demoproject.springbootdemo.models.Book;

public interface BookRepository extends CrudRepository<Book, String>, BookRepositoryCustom {
}