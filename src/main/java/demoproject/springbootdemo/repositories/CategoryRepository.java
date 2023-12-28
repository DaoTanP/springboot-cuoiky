package demoproject.springbootdemo.repositories;

import org.springframework.data.repository.CrudRepository;
import demoproject.springbootdemo.models.Category;

public interface CategoryRepository extends CrudRepository<Category, String> {
}