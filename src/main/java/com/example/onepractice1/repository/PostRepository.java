package com.example.onepractice1.repository;

import com.example.onepractice1.models.Post;

import java.util.List;

public interface PostRepository {
    List<Post> findAll();
    Post findPostById(Long id);
    void savePost(Post post);
    boolean deletePostById(Long id);
}
