package demoproject.springbootdemo.repositories;

import org.springframework.data.repository.CrudRepository;
import demoproject.springbootdemo.models.Author;

public interface AuthorRepository extends CrudRepository<Author, String> {
}