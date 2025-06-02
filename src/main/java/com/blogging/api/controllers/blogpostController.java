package com.blogging.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.blogging.api.domain.Blogpost;
import com.blogging.api.domain.BlogpostRequestDTO;
import com.blogging.api.service.BlogpostService;

@RestController
@RequestMapping("/api/blog")
public class blogpostController {

    @Autowired
    private BlogpostService serviceBlogpost;

    @PostMapping("/post/create")
    public ResponseEntity<Blogpost> createBlogPost(@RequestBody BlogpostRequestDTO request) {
        Blogpost newPost = this.serviceBlogpost.createBlogPost(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(newPost);
    }
}
