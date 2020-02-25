package jquey.demo.sevices;

import jquey.demo.repositories.AuthorRepository;
import jquey.demo.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {
    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private AuthorRepository authorRepository;

    public String save(Book book){
//        Author author = authorRepository.getOneAuthor(id);
//        book.setAuthor(author);
        bookRepository.save(book);
        return "Book Save Successfully !";
    }

    public Author finOne(int authorId){
       return authorRepository.findById(authorId).get();
    }
}
