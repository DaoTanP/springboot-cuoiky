package demoproject.springbootdemo.repositories;

import org.springframework.data.repository.CrudRepository;
import demoproject.springbootdemo.models.BorrowStatus;

public interface BorrowStatusRepository extends CrudRepository<BorrowStatus, String> {
}