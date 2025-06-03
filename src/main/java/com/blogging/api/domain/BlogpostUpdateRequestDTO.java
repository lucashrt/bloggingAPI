package com.blogging.api.domain;

public record BlogpostUpdateRequestDTO(String title, String content, String category, String[] tags) {

}
