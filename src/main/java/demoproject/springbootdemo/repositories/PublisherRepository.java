package demoproject.springbootdemo.repositories;

import org.springframework.data.repository.CrudRepository;
import demoproject.springbootdemo.models.Publisher;

public interface PublisherRepository extends CrudRepository<Publisher, String> {
}