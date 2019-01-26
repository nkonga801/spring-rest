package com.nkongara.springrest.controller;


import com.nkongara.springrest.domain.Author;
import com.nkongara.springrest.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/authors")
public class AuthorController {

    private AuthorRepository authorRepository;

    @Autowired
    public AuthorController(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @RequestMapping("/")
    public Iterable<Author> list() {
        return authorRepository.findAll();
    }

    @RequestMapping("/{id}")
    public Author read(@PathVariable(value="id") long id) {
        return authorRepository.findById(id);
    }
}
