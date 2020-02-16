package jquey.demo.controller;

import jquey.demo.models.Author;
import jquey.demo.models.Book;
import jquey.demo.sevices.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class BookController {
    @Autowired
    private BookService bookService;

    @RequestMapping(value = "/saveBook")
    public String save(@RequestBody Map<String, String> mapObj) {
        Author author = bookService.finOne(Integer.parseInt(mapObj.get("authorId")));
        Book book = new Book();
        book.setAuthor(author);
        book.setTitle(mapObj.get("title"));
//        book.setTitle(mapObj.get("authorId"));
        bookService.save(book);
        return null;
    }

    @RequestMapping(value = "/getAuthor/{authorId}")
    public Author getAuthor(@PathVariable(value = "authorId") int authorId) {
        return bookService.finOne(authorId);
    }

}
