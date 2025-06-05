package com.blogging.api.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blogging.api.domain.Blogpost;
import com.blogging.api.domain.BlogpostCreateRequestDTO;
import com.blogging.api.domain.BlogpostUpdateRequestDTO;
import com.blogging.api.repository.BlogpostRepository;

@Service
public class BlogpostService {

    @Autowired
    private BlogpostRepository blogpostRepository;

    public Blogpost createBlogPost(BlogpostCreateRequestDTO request) {
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

    public Blogpost updateBlogPost(UUID id, BlogpostUpdateRequestDTO request) {
        Blogpost existingBlogpost = this.blogpostRepository.findById(id).orElse(null);

        if (existingBlogpost == null) {
            return existingBlogpost;
        } else {
            String title = request.title() != null ? request.title() : existingBlogpost.getTitle();
            String content = request.content() != null ? request.content() : existingBlogpost.getContent();
            String category = request.category() != null ? request.category() : existingBlogpost.getCategory();
            String[] tags = request.tags() != null ? request.tags() : existingBlogpost.getTags();

            existingBlogpost.setTitle(title);
            existingBlogpost.setContent(content);
            existingBlogpost.setCategory(category);
            existingBlogpost.setTags(tags);
            existingBlogpost.setUpdated_at(LocalDateTime.now());

            blogpostRepository.save(existingBlogpost);
            return existingBlogpost;
        }
    }

    public Blogpost deleteBlogPost(UUID id) {
        Blogpost existingBlogpost = this.blogpostRepository.findById(id).orElse(null);
        
        if (existingBlogpost != null) {
            blogpostRepository.delete(existingBlogpost);
        }
        
        return existingBlogpost;
    }

    public Blogpost getSpecificBlogPost(UUID id) {
        Blogpost existingBlogpost = this.blogpostRepository.findById(id).orElse(null);
        return existingBlogpost;
    }
    
    public List<Blogpost> getBlogPost(String term) {
        if (term == null || term.isEmpty()) {
            List<Blogpost> allBlogposts = this.blogpostRepository.findAll();
            return allBlogposts;
        } else {
            List<Blogpost> allBlogposts = this.blogpostRepository.findByTerm(term);
            return allBlogposts;
        }
    }
}
