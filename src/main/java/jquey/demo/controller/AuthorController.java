package jquey.demo.controller;

import jquey.demo.models.Author;
import jquey.demo.repositories.AuthorRepository;
import jquey.demo.sevices.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class AuthorController {
    @Autowired
    private AuthorService authorService;
    @Autowired
    private AuthorRepository authorRepository;
    @RequestMapping(value ="/save")
    public String save(@RequestBody Map<String, String> mapObj){
        Author author = new Author();
        author.setName(mapObj.get("name"));
        authorRepository.save(author);
        return null;
    }
}
