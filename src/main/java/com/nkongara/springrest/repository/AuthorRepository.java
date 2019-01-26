package com.nkongara.springrest.repository;

import com.nkongara.springrest.domain.Author;
import com.nkongara.springrest.domain.Post;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author, Long> {

    Author findById(long id);

}
