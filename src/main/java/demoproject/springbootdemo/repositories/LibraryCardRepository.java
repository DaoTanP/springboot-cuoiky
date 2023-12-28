package demoproject.springbootdemo.repositories;

import org.springframework.data.repository.CrudRepository;
import demoproject.springbootdemo.models.LibraryCard;

public interface LibraryCardRepository extends CrudRepository<LibraryCard, String> {
}