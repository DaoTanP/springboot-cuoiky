package demoproject.springbootdemo.repositories;

import java.util.List;

import demoproject.springbootdemo.models.Book;
import demoproject.springbootdemo.models.utilModels.BookSearchModel;

public interface BookRepositoryCustom {
    public List<Book> findAllByTitle(String title);

    public List<Book> findAllByAuthor(String author);

    public List<Book> findAllByPublisher(String publisher);

    public List<Book> findAllByCategory(String category);

    public List<Book> search(BookSearchModel searchModel);
}
