package com.blog.BloggingProject.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.blog.BloggingProject.model.Post;

public interface PostRepo extends JpaRepository<Post,Integer>{
    
}
