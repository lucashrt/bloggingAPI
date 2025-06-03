package com.blogging.api.controllers;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.blogging.api.domain.Blogpost;
import com.blogging.api.domain.BlogpostCreateRequestDTO;
import com.blogging.api.domain.BlogpostUpdateRequestDTO;
import com.blogging.api.service.BlogpostService;

@RestController
@RequestMapping("/api/blog")
public class blogpostController {

    @Autowired
    private BlogpostService serviceBlogpost;

    @PostMapping("/posts/create")
    public ResponseEntity<Blogpost> createBlogPost(@RequestBody BlogpostCreateRequestDTO request) {
        Blogpost newPost = this.serviceBlogpost.createBlogPost(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(newPost);
    }

    @PutMapping("/posts/{id}")
    public ResponseEntity<?> updateBlogPost(@PathVariable UUID id, @RequestBody BlogpostUpdateRequestDTO request) {
        Blogpost updatedPost = this.serviceBlogpost.updateBlogPost(id, request);
        
        if (updatedPost != null) {
            return ResponseEntity.ok(updatedPost);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Blog post was not found.");
        }
        
    }

    @DeleteMapping("/posts/{id}")
    public ResponseEntity<Void> deleteBlogPost(@PathVariable UUID id) {
        Blogpost deletePost = this.serviceBlogpost.deleteBlogPost(id);

        if (deletePost != null) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}