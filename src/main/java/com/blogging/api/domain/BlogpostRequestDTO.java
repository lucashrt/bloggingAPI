package com.blogging.api.domain;

public record BlogpostRequestDTO(String title, String content, String category, String[] tags) {

    public BlogpostRequestDTO {
        if (title == null || title.isBlank()) {
            throw new IllegalArgumentException("Title cannot be null or blank");
        }
        if (content == null || content.isBlank()) {
            throw new IllegalArgumentException("Content cannot be null or blank");
        }
        if (category == null || category.isBlank()) {
            throw new IllegalArgumentException("Category cannot be null or blank");
        }
        if (tags == null || tags.length == 0) {
            throw new IllegalArgumentException("Tags cannot be null or empty");
        }
    }
}
