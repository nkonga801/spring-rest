package com.nkongara.springrest;


import com.nkongara.springrest.domain.Author;
import com.nkongara.springrest.domain.Post;
import com.nkongara.springrest.repository.AuthorRepository;
import com.nkongara.springrest.repository.PostRepository;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;

@SpringBootApplication
public class RestStarterApplication {

    public static void main(String[] args){
        SpringApplication.run(RestStarterApplication.class, args);
    }

    @Bean
    CommandLineRunner runner(AuthorRepository authorRepository, PostRepository postRepository) {
        return args -> {
            Author nk = new Author("Naga", "K", "naga007@gmail.com");
            authorRepository.save( nk );

            Post post = new Post("Spring boot rocks!");
            post.setSlug("spring-data-rocks");
            post.setTitle("Post Teaser");
            post.setBody("Post Body");
            post.setPostedOn(new Date());
            post.setAuthor(nk);
            postRepository.save(post);

            Post rest = new Post("REST is what all the cool kids are doing");
            rest.setSlug("rest-is-cool");
            rest.setTeaser("REST Teaser");
            rest.setBody("REST BODY");
            rest.setPostedOn(new Date());
            rest.setAuthor(nk);
            postRepository.save(rest);
        };
    }
}
