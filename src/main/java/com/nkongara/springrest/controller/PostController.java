package com.nkongara.springrest.controller;


import com.nkongara.springrest.domain.Post;
import com.nkongara.springrest.exception.PostNotFoundException;
import com.nkongara.springrest.service.PostService;
import javassist.util.proxy.ProxyObjectOutputStream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController
@RequestMapping("/posts")
public class PostController {

    private PostService postService;

    //public PostController() {}

    @Autowired
    public PostController(PostService postService){
        this.postService = postService;
    }

    @RequestMapping( value="/", method = RequestMethod.GET)
    public Iterable<Post> list() {
        return postService.list();
    }

    @RequestMapping( value="/", method = RequestMethod.POST)
    public Post create(@RequestBody Post post) {
        return postService.create(post);
    }

    @RequestMapping( value = "/{id}", method = RequestMethod.GET)
    public Post read(@PathVariable(value = "id") long id) throws PostNotFoundException {
        Post post =  postService.read(id);
        if( post == null ){
            throw new PostNotFoundException("Post with id: " + id + " not found.");
        }
        return post;
    }

    @RequestMapping( value = "/{id}", method = RequestMethod.PUT)
    public Post update(@PathVariable(value = "id") long id, @RequestBody Post post) {
        return postService.update(id, post);
    }

    @RequestMapping( value = "/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable(value = "id") long id) {
        postService.delete(id);
    }

    @ExceptionHandler(PostNotFoundException.class)
    public void handlePostNotFound(PostNotFoundException exception, HttpServletResponse response) throws IOException {
        response.sendError( HttpStatus.NOT_FOUND.value(), exception.getMessage() );
    }
}

