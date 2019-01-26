package com.nkongara.springrest.service;


import com.nkongara.springrest.domain.Post;
import com.nkongara.springrest.repository.AuthorRepository;
import com.nkongara.springrest.repository.PostRepository;
import org.springframework.stereotype.Service;


@Service
public class PostServiceImpl implements PostService {

    private PostRepository postRepository;
    private AuthorRepository authorRepository;

    public PostServiceImpl(PostRepository postRepository, AuthorRepository authorRepository) {
        this.postRepository = postRepository;
        this.authorRepository = authorRepository;
    }
    @Override
    public Iterable<Post> list() {
        return postRepository.findAll();
    }

    @Override
    public Post read(long id) {
        return postRepository.findById(id);
    }

    @Override
    public Post create(Post post) {
        authorRepository.save(post.getAuthor());
        return postRepository.save(post);
    }

    @Override
    public Post update(long id, Post update) {
        Post post = postRepository.findById(id);
        if (update.getTitle() != null ) {
            post.setTitle(update.getTitle());
        }

        return postRepository.save(post);
    }

    @Override
    public void delete(long id) {
        postRepository.deleteById(id);
    }
}
