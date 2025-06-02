package com.blogging.api.domain;

import java.time.LocalDateTime;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = "blogpost")
@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Blogpost {
    
    @Id
    @GeneratedValue
    private UUID id;

    private String title;
    private String content;
    private String category;

    @Column(columnDefinition = "text[]")
    private String[] tags;

    private LocalDateTime created_at;
    private LocalDateTime updated_at;
}