package demoproject.springbootdemo.controllers;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Random;
import java.util.function.Consumer;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import demoproject.springbootdemo.models.Author;
import demoproject.springbootdemo.models.Book;
import demoproject.springbootdemo.models.Category;
import demoproject.springbootdemo.models.Publisher;
import demoproject.springbootdemo.models.utilModels.BookSearchModel;
import demoproject.springbootdemo.repositories.AuthorRepository;
import demoproject.springbootdemo.repositories.BookRepository;
import demoproject.springbootdemo.repositories.CategoryRepository;
import demoproject.springbootdemo.repositories.PublisherRepository;

@Controller
@RequestMapping(path = "/api/book")
public class BookController {

    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private AuthorRepository authorRepository;
    @Autowired
    private PublisherRepository publisherRepository;
    @Autowired
    private CategoryRepository categoryRepository;

    // @Autowired
    // private JwtService authService;

    @GetMapping(path = "")
    public @ResponseBody Iterable<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    @GetMapping(path = "/{id}")
    public @ResponseBody Optional<Book> getBook(@PathVariable("id") String id) {
        return bookRepository.findById(id);
    }

    @GetMapping(path = "/randomRecommendation")
    public @ResponseBody List<Book> getRandom() {
        List<Book> bookList = new ArrayList<Book>();
        Iterable<Book> iterable = bookRepository.findAll();

        iterable.forEach(new Consumer<Book>() {
            @Override
            public void accept(Book b) {
                bookList.add(b);
            }
        });
        Collections.shuffle(bookList, new Random());

        return bookList.stream().limit(10).collect(Collectors.toList());
    }

    @GetMapping(path = "/borrow")
    public @ResponseBody ResponseEntity<Boolean> borrow() {
        List<Book> bookList = new ArrayList<Book>();
        Iterable<Book> iterable = bookRepository.findAll();

        iterable.forEach(new Consumer<Book>() {
            @Override
            public void accept(Book b) {
                bookList.add(b);
            }
        });
        Collections.shuffle(bookList, new Random());

        return null;
    }

    @GetMapping(path = "/search")
    public @ResponseBody List<Book> search(@RequestParam Map<String, String> qparams) {
        BookSearchModel searchModel = new BookSearchModel();
        qparams.forEach((k, v) -> {
            System.out.println(k + ": " + v);
            if (k.equals("bookTitle") && v != null && !v.equals(""))
                searchModel.setBookTitle(v);

            if (k.equals("author") && v != null && !v.equals(""))
                searchModel.setAuthor(v);

            if (k.equals("publisher") && v != null && !v.equals(""))
                searchModel.setPublisher(v);

            if (k.equals("publishedFrom") && v != null && !v.equals(""))
                searchModel.setPublishedFrom(Date.valueOf(v + "-1-1"));

            if (k.equals("publishedTo") && v != null && !v.equals(""))
                searchModel.setPublishedTo(Date.valueOf(v + "-12-31"));

            if (k.equals("category") && v != null && !v.equals(""))
                searchModel.setCategory(v);
        });

        if (searchModel.getBookTitle() != null ||
                searchModel.getAuthor() != null ||
                searchModel.getCategory() != null ||
                searchModel.getPublisher() != null ||
                searchModel.getPublishedFrom() != null ||
                searchModel.getPublishedTo() != null) {
            return bookRepository.search(searchModel);
        }

        List<Book> books = new ArrayList<Book>();
        bookRepository.findAll().forEach((b) -> books.add(b));
        return books;
    }

    @GetMapping(path = "/author")
    public @ResponseBody Iterable<Author> getAuthors() {
        return authorRepository.findAll();
    }

    @GetMapping(path = "/publisher")
    public @ResponseBody Iterable<Publisher> getPublishers() {
        return publisherRepository.findAll();
    }

    @GetMapping(path = "/category")
    public @ResponseBody Iterable<Category> getCategories() {
        return categoryRepository.findAll();
    }
}