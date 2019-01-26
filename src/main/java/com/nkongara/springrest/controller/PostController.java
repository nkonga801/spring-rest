package com.nkongara.springrest.controller;


import com.nkongara.springrest.domain.Post;
import com.nkongara.springrest.service.PostService;
import javassist.util.proxy.ProxyObjectOutputStream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    public Post read(@PathVariable(value = "id") long id) {
        return postService.read(id);
    }

    @RequestMapping( value = "/{id}", method = RequestMethod.PUT)
    public Post update(@PathVariable(value = "id") long id, @RequestBody Post post) {
        return postService.update(id, post);
    }

    @RequestMapping( value = "/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable(value = "id") long id) {
        postService.delete(id);
    }
}

