package com.blogging.api.service;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blogging.api.domain.Blogpost;
import com.blogging.api.domain.BlogpostRequestDTO;
import com.blogging.api.repository.BlogpostRepository;

@Service
public class BlogpostService {

    @Autowired
    private BlogpostRepository blogpostRepository;

    public Blogpost createBlogPost(BlogpostRequestDTO request) {
        Blogpost newBlogpost = new Blogpost();
        newBlogpost.setTitle(request.title());
        newBlogpost.setContent(request.content());
        newBlogpost.setCategory(request.category());
        newBlogpost.setTags(request.tags());
        newBlogpost.setCreated_at(LocalDateTime.now());
        newBlogpost.setUpdated_at(LocalDateTime.now());

        blogpostRepository.save(newBlogpost);
        return newBlogpost;
    }
}
