package jquey.demo.sevices;

import jquey.demo.repositories.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class AuthorService {
    @Autowired
    private AuthorRepository authorRepository;

    public String save(Map<String,Author> mapObj) {
        Author author = new Author();
        authorRepository.save(author);
        return "Author save successfully !";
    }
}
