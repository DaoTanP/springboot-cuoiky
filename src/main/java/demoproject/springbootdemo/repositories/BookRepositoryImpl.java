package demoproject.springbootdemo.repositories;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;

import demoproject.springbootdemo.models.Book;
import demoproject.springbootdemo.models.utilModels.BookSearchModel;

public class BookRepositoryImpl implements BookRepositoryCustom {

    @Autowired
    @Lazy
    BookRepository bookRepository;

    @Override
    public List<Book> findAllByAuthor(String author) {
        List<Book> bookList = new ArrayList<Book>();
        Iterable<Book> iterable = bookRepository.findAll();

        iterable.forEach(new Consumer<Book>() {
            @Override
            public void accept(Book b) {
                if (b.getAuthor().equals(author))
                    bookList.add(b);
            }
        });
        return bookList;
    }

    @Override
    public List<Book> findAllByCategory(String category) {
        List<Book> bookList = new ArrayList<Book>();
        Iterable<Book> iterable = bookRepository.findAll();

        iterable.forEach(new Consumer<Book>() {
            @Override
            public void accept(Book b) {
                if (b.getCategory().equals(category))
                    bookList.add(b);
            }
        });
        return bookList;
    }

    @Override
    public List<Book> findAllByPublisher(String publisher) {
        List<Book> bookList = new ArrayList<Book>();
        Iterable<Book> iterable = bookRepository.findAll();

        iterable.forEach(new Consumer<Book>() {
            @Override
            public void accept(Book b) {
                if (b.getPublisher().equals(publisher))
                    bookList.add(b);
            }
        });
        return bookList;
    }

    @Override
    public List<Book> findAllByTitle(String title) {
        List<Book> bookList = new ArrayList<Book>();
        Iterable<Book> iterable = bookRepository.findAll();

        iterable.forEach(new Consumer<Book>() {
            @Override
            public void accept(Book b) {
                if (b.getTitle().equals(title))
                    bookList.add(b);
            }
        });
        return bookList;
    }

    @Override
    public List<Book> search(BookSearchModel searchModel) {
        List<Book> bookList = new ArrayList<Book>();
        Iterable<Book> iterable = bookRepository.findAll();

        iterable.forEach(new Consumer<Book>() {
            @Override
            public void accept(Book b) {
                if (searchModel.getBookTitle() != null
                        && b.getTitle().toLowerCase().contains(searchModel.getBookTitle().toLowerCase())) {
                    bookList.add(b);
                    return;
                }

                if (searchModel.getAuthor() != null
                        && b.getAuthor().toLowerCase().equals(searchModel.getAuthor().toLowerCase())) {
                    bookList.add(b);
                    return;
                }

                if (searchModel.getPublisher() != null
                        && b.getPublisher().toLowerCase().equals(searchModel.getPublisher().toLowerCase())) {
                    bookList.add(b);
                    return;
                }

                if (searchModel.getCategory() != null
                        && b.getCategory().toLowerCase().equals(searchModel.getCategory().toLowerCase())) {
                    bookList.add(b);
                    return;
                }

                if (b.getPublishDate() != null &&
                        ((searchModel.getPublishedFrom() != null
                                && b.getPublishDate().after(searchModel.getPublishedFrom())) ||
                                (searchModel.getPublishedTo() != null
                                        && b.getPublishDate().before(searchModel.getPublishedTo())))) {
                    bookList.add(b);
                    return;
                }
            }
        });
        return bookList;
    }

}
