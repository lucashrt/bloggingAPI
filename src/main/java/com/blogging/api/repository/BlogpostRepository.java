package com.blogging.api.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.blogging.api.domain.Blogpost;

public interface BlogpostRepository extends JpaRepository<Blogpost, UUID> {

    @Query("SELECT e FROM Blogpost e " +
    "WHERE LOWER(e.title) LIKE LOWER(CONCAT('%', :term, '%')) " +
    "OR LOWER(e.content) LIKE LOWER(CONCAT('%', :term, '%')) " +
    "OR LOWER(e.category) LIKE LOWER(CONCAT('%', :term, '%'))")
    public List<Blogpost> findByTerm(@Param("term") String term);
}