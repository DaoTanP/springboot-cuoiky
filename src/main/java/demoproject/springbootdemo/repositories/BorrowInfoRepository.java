package demoproject.springbootdemo.repositories;

import org.springframework.data.repository.CrudRepository;
import demoproject.springbootdemo.models.BorrowInfo;

public interface BorrowInfoRepository extends CrudRepository<BorrowInfo, String> {
}